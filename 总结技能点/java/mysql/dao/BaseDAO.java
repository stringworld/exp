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
	 * Ԥ�����SQL���Ķ���
	 */
	private PreparedStatement ps;
	/**
	 * ���ݿ����������ݱ�
	 */
	private ResultSet rs;
	/**
	 * ִ��һ����ɾ�ĵ�SQL���
	 * @param sql ׼��Ԥ�����SQL���
	 * @param args �����б�,���Ⱥ�˳��
	 * @return ��Ӱ���������������ʶID
	 */
	protected int update(String sql,Object... args) {
		int count=0;
		Connection conn=null;
		try {
			conn=ConnectionManager.getConnection();
			conn.setAutoCommit(false);
			init(sql, args);
			count=ps.executeUpdate();
//			����ǲ������,�򷵻��������ݵ�ID
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
	 * ִ�ж���sql���
	 * @param sqls ׼��ִ�е�sql���
	 * @return ��Ӧsql���Ӱ�������-����
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
	 * ִ�в�ѯ����
	 * @param sql ׼��Ԥ�����SQL���
	 * @param args �����б�,���Ⱥ�˳��
	 * @return ��ѯ�õ��Ľ����,map����,ÿ����ϢΪһ��map,������Ϊ��
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
	 * ��ѯ������������Ϣ��(��ѯ�������Ҫ��Ϊcount)
	 * @param sql ׼��Ԥ�����SQL���
	 * @param args �����б�,���Ⱥ�˳��
	 * @return ��Ϣ��
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
	 * ����sql���Ѳ�ѯ����Ž�list����
	 * @param cls ��ѯ������
	 * @param sql ��ѯ���
	 * @param args ��ѯ����
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
     * ����һ��ʵ����󣬲���Map�е���Ϣ��ֵ������
     * @param map ������Ϣ��map
     * @param cls Ҫ�������������
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
	 * ��ʼ��ps
	 */
	private void init(String sql,Object...args) throws SQLException{
		ps=ConnectionManager.getConnection().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		if(args!=null)
			for(int i=0;i<args.length;i++)
				ps.setObject(i+1,args[i]);
	}
	/**
	 * �ͷ���Դ
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