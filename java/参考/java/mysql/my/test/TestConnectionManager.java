package my.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import my.dao.ConnectionManager;

public class TestConnectionManager {
	public static void main(String[] args) {
		Connection conn=ConnectionManager.getConn();
		try {
			DatabaseMetaData data=conn.getMetaData();
			ResultSet rs=null;
			//查询表
//			rs=data.getTables(null,"%","%",null);
//			while(rs.next()){
//				System.out.println(rs.getString("TABLE_NAME"));
//			}
			//查询字段
			rs=data.getColumns(null,"%","employee",null);
			while(rs.next()){
				StringBuilder sb=new StringBuilder();
				sb.append("字段名称:"+rs.getString("COLUMN_NAME"));
				sb.append("\t");
				sb.append("字段类型:"+rs.getString("TYPE_NAME"));
				sb.append("\t");
				sb.append("长度:"+rs.getString("COLUMN_SIZE"));
				sb.append("\t");
				sb.append("是否允许为空:"+rs.getString("NULLABLE"));
				System.out.println(sb.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}