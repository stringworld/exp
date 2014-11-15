package dao;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;
@SuppressWarnings({"unchecked"})
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
	 */
	protected int update(String sql,Object... args) throws SQLException{
		int count=0;
		Connection conn=null;
		try {
			conn=ConnectionManager.get();
			conn.setAutoCommit(false);
			init(sql, args);
			count=ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw e1;
			}
			throw e;
		}finally{
			release();
		}
		return count;
	}
	/**
	 * 执行查询操作
	 * @param sql 准备预编译的SQL语句
	 * @param args 参数列表,按先后顺序
	 * @return 查询得到的结果集,map数组,每行信息为一个map,以列名为键
	 */
	protected Result query(String sql,Object... args) throws SQLException{
		Result result=null;
		try {
			init(sql, args);
			rs=ps.executeQuery();
			result=ResultSupport.toResult(rs);
		}finally{
			release();
		}
		return result;
	}
	/**
	 * 查询符合条件的信息量(查询语句列名要改为count)
	 * @param sql 准备预编译的SQL语句
	 * @param args 参数列表,按先后顺序
	 */
	protected int queryCount(String sql,Object... args) throws SQLException{
		try {
			init(sql, args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs=ps.executeQuery();
		if(rs!=null){
			rs.next();
			return rs.getInt("count");
		}
		return 0;
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
	protected <T>T getT(Map map,Class<T> cls){
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
		ps=ConnectionManager.get().prepareStatement(sql);
		if(args!=null)
			for(int i=0;i<args.length;i++)
				ps.setObject(i+1,args[i]);
	}
	/**
	 * 释放资源
	 */
	private void release(){
		rs=null;
		ps=null;
		ConnectionManager.release();
	}
}