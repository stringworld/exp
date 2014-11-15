package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 数据库连接管理器
 */
public final class ConnectionManager {
	private static String dbpath;
	private static ThreadLocal<Connection> conns=new ThreadLocal<Connection>();
	static{
		try{
			dbpath=new File(ConnectionManager.class.getResource("/").toURI()).toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			Class.forName(ProgramBundle.get("driverClassName"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private ConnectionManager(){}
	/**
	 * 获取连接
	 */
	public static Connection get(){
		if(conns.get()==null){
			try {
				conns.set(DriverManager.getConnection("jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};pwd=;"
						 +"DBQ="+dbpath+"\\"+ProgramBundle.get("db"))
						);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conns.get();
	}
	/**
	 * 施放连接
	 */
	public static void release(){
		Connection conn=conns.get();
		if(conn!=null){
			try{
				if(!conn.isClosed()){
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			conns.remove();
		}
	}
}