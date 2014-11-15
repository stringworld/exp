package my.dao;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao{
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private boolean autoRelease=true;
	
	public <T>T getOne(Class<T> cls,String sql,Object... args){
		T obj=null;
		try {
			init(sql, args);
			rs=ps.executeQuery();
			if(rs.next()){
				obj=getT(cls, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(autoRelease){
			release();
		}else{
			close();
		}
		return obj;
	}
	
	public <T>List get(Class<T> cls,String sql,Object... args){
		List<T> list=new ArrayList<T>();
		try {
			init(sql, args);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(getT(cls, rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(autoRelease){
			release();
		}else{
			close();
		}
		return list;
	}
	private <T>T getT(Class<T> cls,ResultSet rs){
		T obj=null;
		try {
			obj=cls.newInstance();
			Method[] methods=cls.getMethods();
	        for(Method m:methods){
	            String name=m.getName();
	            if(name.matches("^set[A-Z][A-Za-z]*")){
	                name=name.substring(3,4).toLowerCase()+name.substring(4);
	                if(rs.findColumn(name)!=-1){
	                	try{
	                		m.invoke(obj,rs.getObject(name));
	                	}catch(Exception e){
	                		e.printStackTrace();
	                	}
	                }
	            }
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	public long count(String sql, Object... args) {
		long count=0;
		try {
			init(sql, args);
			rs=ps.executeQuery();
			rs.next();
			count=rs.getLong(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(autoRelease){
			release();
		}else{
			close();
		}
		return count;
	}
	public long execute(String sql,Object... args) {
		long count=0;
		try {
			init(sql, args);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(autoRelease){
			release();
		}else{
			close();
		}
		return count;
	}
	private void init(String sql,Object...args){
		conn=ConnectionManager.getConn();
		try {
			ps=conn.prepareStatement(sql);
			if(args!=null){
				for(int i=0;i<args.length;i++){
					ps.setObject(i+1,args[i]);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setAutoRelease(boolean autoRelease){
		this.autoRelease=autoRelease;
	}
	protected void finalize() throws Throwable {
		release();
	}
	private void close(){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs=null;
		try {
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ps=null;
	}
	public void release(){
		close();
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn=null;
		ConnectionManager.closeConn();
	}
	/**
	 * 把json转换成查询条件，追加在where后面
	 * 格式：{"age":20,"name":"abc"}
	 */
	public static String jsonFilter(String json){
		StringBuilder sb=new StringBuilder("1=1");
		if(json!=null && json.matches("^\\{.+\\}$")){
			try{
				String[] items=json.substring(1,json.length()-1).split(",");
				for(String item:items){
					String[] map=item.split(":");
					if(map[1].charAt(0)=='\"'){	//字符串
						sb.append(String.format(" and %s like '%%%s%%'",
							map[0].substring(1,map[0].length()-1),
							map[1].substring(1,map[1].length()-1))
						);
					}else{	//数字
						sb.append(String.format(" and %s=%s",
							map[0].substring(1,map[0].length()-1),
							map[1]));
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}