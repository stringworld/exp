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
	 * ִ�в�ѯ����
	 * @param sql ׼��Ԥ�����SQL���
	 * @param args �����б�,���Ⱥ�˳��
	 * @return ��ѯ�õ��Ľ����,map����,ÿ����ϢΪһ��map,������Ϊ��
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
	 * ��ѯ������������Ϣ��(��ѯ�������Ҫ��Ϊcount)
	 * @param sql ׼��Ԥ�����SQL���
	 * @param args �����б�,���Ⱥ�˳��
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
	 * ��ʼ��ps
	 */
	private void init(String sql,Object...args) throws SQLException{
		ps=ConnectionManager.get().prepareStatement(sql);
		if(args!=null)
			for(int i=0;i<args.length;i++)
				ps.setObject(i+1,args[i]);
	}
	/**
	 * �ͷ���Դ
	 */
	private void release(){
		rs=null;
		ps=null;
		ConnectionManager.release();
	}
}