package ���ݿ����;
import java.sql.*;
public class JDBCTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		Connection conn=null;  //�������ݿ�
		Statement stmt=null;   //ִ��MySQL���
		ResultSet rs=null;     //�����
		String mysql="select * from person";
		try{
			String url="jdbc:mysql://localhost:3306/greatwqsuser";//���ݿ��ַ
		    String user="root";		//MySQL�û���
		    String password="";		//MySQL����
			Class.forName("com.mysql.jdbc.Driver").newInstance();//����
			conn=DriverManager.getConnection(url, user, password); //�������ݿ�
			/**
			 * �������ݿ�jdbc:mysql://localhost:3306/greatwqsuser ���ݿ�Ϊgreatwqsuser
			 * �˿�Ϊ 3306(���Բ���д��
			 * 
			 * �û��� user=root
			 * 
			 * �Ñ��ܴapassword=��
			 */
			stmt=conn.createStatement();//����SQL��䣬ʵ�ֶ����ݿ�Ĳ�������
			rs=stmt.executeQuery(mysql);//���ز�ѯ���
			String t=null;
			while(rs.next())
			{
				t=rs.getString("name");//�����������
			}
			if(t!=null){
				System.out.println(t);
			}else{
				System.out.println("�û�������");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			//�رյ�˳���ܳ���
			rs.close();//�ر����
			stmt.close();//�رս����
			conn.close();//�ر����ݿ������
		}

	}

}
