package my.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import my.util.ProgramBundle;

public final class ConnectionManager {
	private static ThreadLocal<Connection> conns=new ThreadLocal<Connection>();
	static{
		try {
			Class.forName(ProgramBundle.getString("dbDriverClassName"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConn(){
		Connection conn=conns.get();
		if(conn==null){
			try {
				conn=DriverManager.getConnection(
						ProgramBundle.getString("dbUrl"),
						ProgramBundle.getString("dbUsername"),
						ProgramBundle.getString("dbPassword")
					);
				conns.set(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	public static void closeConn(){
		Connection conn=conns.get();
		if(conn!=null){
			conns.remove();
		}
	}
}