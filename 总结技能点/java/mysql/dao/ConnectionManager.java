package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
	private ConnectionManager(){}
	private static ThreadLocal<Connection> conns=new ThreadLocal<Connection>();
	static{
		try {
			Class.forName(ProgramBundle.getString("driverClassName"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获得连接
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		if(conns.get()==null)
			conns.set(DriverManager.getConnection(ProgramBundle.getString("url")
												 ,ProgramBundle.getString("username")
												 ,ProgramBundle.getString("password"))
												 );
		return conns.get();
	}
//	private static DataSource ds;
//	static{
//		try {
//			Context context=new InitialContext();
//			ds=(DataSource)context.lookup("java:comp/env/huiyuan");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
//	/**
//	 * 获得连接
//	 * @throws SQLException
//	 */
//	public static Connection getConnection() throws SQLException{
//		if(conns.get()==null)
//			conns.set(ds.getConnection());
//		return conns.get();
//	}
	/**
	 * 释放连接
	 * @throws SQLException
	 */
	public static void release() throws SQLException{
		Connection conn=conns.get();
		if(conn!=null){
			if(!conn.isClosed())
				conn.close();
			conns.remove();
		}
	}
}
