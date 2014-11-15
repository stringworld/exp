package dao;
import java.sql.*;
public class JDBCTest {

	/**
	 * 连接数据库的方法
	 * @param args
	 */
	public static void hello()
	{
		Connection conn=null;  //连接数据库
		Statement stmt=null;   //执行MySQL语句
		ResultSet rs=null;     //结果集
		try{
			String url="jdbc:mysql://localhost:3306/greatwqsuser";//数据库地址
		    String user="root";		//MySQL用户名
		    String password="";		//MySQL密码
			Class.forName("com.mysql.jdbc.Driver").newInstance();//驱动
			conn=DriverManager.getConnection(url, user, password); //连接数据库
			/**
			 * 连接数据库jdbc:mysql://localhost:3306/greatwqsuser 数据库为greatwqsuser
			 * 端口为 3306(可以不用写）
			 * 
			 * 用户名 user=root
			 * 
			 * 用戶密碼password=空
			 */
			String mysql="select * from person";//要查询的内容
			stmt=conn.createStatement();//创建SQL语句，实现对数据库的操作功能
			rs=stmt.executeQuery(mysql);//反回查询结果
			System.out.println(" 学号" + "\t" + "姓名"+ "\t" + "性别"+ "\t" + "   出生日期"+ "\t" + "              联系电话"+ "\t" + " 班级"+ "\t" + " 备注");
			while(rs.next())
			{
				//t=rs.getString("学号");//结果集的内容
				System.out.print(rs.getString("学号").toString()+"\t");
				System.out.print(rs.getString("姓名").toString()+"\t");
				System.out.print(rs.getString("性别").toString()+"\t");
				System.out.print(rs.getString("出生日期").toString()+"\t");
				System.out.print(rs.getString("联系电话").toString()+"\t");
				System.out.print(rs.getString("班级").toString()+"\t");
				System.out.print(rs.getString("备注").toString()+"\t");
			}
			
		}catch(ClassNotFoundException e)
		{
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		}catch(SQLException e)
		{    
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			//关闭的顺序不能出错
			try {
				rs.close();//关闭语句
				stmt.close();//关闭结果集
				conn.close();//关闭数据库的连接
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
