package 数据库测试;
import java.sql.*;
public class JDBCTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		Connection conn=null;  //连接数据库
		Statement stmt=null;   //执行MySQL语句
		ResultSet rs=null;     //结果集
		String mysql="select * from person";
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
			stmt=conn.createStatement();//创建SQL语句，实现对数据库的操作功能
			rs=stmt.executeQuery(mysql);//反回查询结果
			String t=null;
			while(rs.next())
			{
				t=rs.getString("name");//结果集的内容
			}
			if(t!=null){
				System.out.println(t);
			}else{
				System.out.println("用户不存在");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			//关闭的顺序不能出错
			rs.close();//关闭语句
			stmt.close();//关闭结果集
			conn.close();//关闭数据库的连接
		}

	}

}
