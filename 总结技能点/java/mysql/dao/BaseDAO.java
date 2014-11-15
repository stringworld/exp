package dao;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;
@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class BaseDAO{
	/**
	 * 预编译的SQL语句的对象
	 */
	private PreparedStatement ps;
	/**
	 * 数据库结果集的数据表
	 */
	private ResultSet rs;
	/**
	 * 执行一条增删改的SQL语句
	 * @param sql 准备预编译的SQL语句
	 * @param args 参数列表,按先后顺序
	 * @return 受影响的行数或新增标识ID
	 */
	protected int update(String sql,Object... args) {
		int count=0;
		Connection conn=null;
		try {
			conn=ConnectionManager.getConnection();
			conn.setAutoCommit(false);
			init(sql, args);
			count=ps.executeUpdate();
//			如果是插入语句,则返回新增数据的ID
//			if(sql.indexOf("insert")!=-1){
//				ResultSet rs=ps.getGeneratedKeys();
//				if(rs.next())
//					count=rs.getInt(1);
//			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			close();
		}
		return count;
	}
	/**
	 * 执行多条sql语句
	 * @param sqls 准备执行的sql语句
	 * @return 相应sql语句影响的行数-数组
	 */
	protected int[] updates(String... sqls) {
		if(sqls==null||sqls.length==0)
			return null;
		int[] counts=null;
		Connection conn=null;
		try {
			conn=ConnectionManager.getConnection();
			conn.setAutoCommit(false);
			ps=conn.prepareStatement(sqls[0]);
			ps.addBatch();
			for(int i=1;i<sqls.length;i++)
				ps.addBatch(sqls[i]);
			counts=ps.executeBatch();
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return counts;
	}
	/**
	 * 执行查询操作
	 * @param sql 准备预编译的SQL语句
	 * @param args 参数列表,按先后顺序
	 * @return 查询得到的结果集,map数组,每行信息为一个map,以列名为键
	 */
	protected Result query(String sql,Object... args) {
		Result result=null;
		try {
			init(sql, args);
			rs=ps.executeQuery();
			result=ResultSupport.toResult(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return result;
	}
	/**
	 * 查询符合条件的信息量(查询语句列名要改为count)
	 * @param sql 准备预编译的SQL语句
	 * @param args 参数列表,按先后顺序
	 * @return 信息量
	 */
	protected int queryCount(String sql,Object... args){
		int count=0;
		try {
			init(sql, args);
			rs=ps.executeQuery();
			if(rs!=null){
				rs.next();
				count=rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 根据sql语句把查询结果放进list集合
	 * @param cls 查询的类型
	 * @param sql 查询语句
	 * @param args 查询参数
	 */
	protected <T>List getTList(Class<T> cls,String sql,Object... args){
		List<T> list=new ArrayList();
		try {
			Result result=query(sql,args);
			Map[] maps=result.getRows();
			for(int i=0;i<maps.length;i++)
				list.add(getT(cls,maps[i]));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
     * 创建一个实体对象，并把Map中的信息赋值给对象
     * @param map 储存信息的map
     * @param cls 要创建对象的类型
     */
	protected <T>T getT(Class<T> cls,Map map){
		Object obj=null;
        try {
			obj=cls.newInstance();
			Method[] methods=cls.getMethods();
	        for(Method m:methods){
	            String name=m.getName();
	            if(name.matches("^set[_\\$A-Z][_\\$\\w]*")){
	                name=name.substring(3);
	                if(name.length()==1)
	                	name=name.toLowerCase();
	                else
	                	name=name.substring(0,1).toLowerCase()+name.substring(1);
	                if(map.containsKey(name))
	                	try{
	                		m.invoke(obj,map.get(name));
	                	}catch(Exception e){}
	            }
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
        return (T)obj;
    }
	/**
	 * 初始化ps
	 */
	private void init(String sql,Object...args) throws SQLException{
		ps=ConnectionManager.getConnection().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		if(args!=null)
			for(int i=0;i<args.length;i++)
				ps.setObject(i+1,args[i]);
	}
	/**
	 * 释放资源
	 */
	private void close(){
		rs=null;
		ps=null;
		try {
			ConnectionManager.release();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}