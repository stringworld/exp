package dao;
import java.sql.*;
public class JDBCTest {

	/**
	 * �������ݿ�ķ���
	 * @param args
	 */
	public static void hello()
	{
		Connection conn=null;  //�������ݿ�
		Statement stmt=null;   //ִ��MySQL���
		ResultSet rs=null;     //�����
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
			String mysql="select * from person";//Ҫ��ѯ������
			stmt=conn.createStatement();//����SQL��䣬ʵ�ֶ����ݿ�Ĳ�������
			rs=stmt.executeQuery(mysql);//���ز�ѯ���
			System.out.println(" ѧ��" + "\t" + "����"+ "\t" + "�Ա�"+ "\t" + "   ��������"+ "\t" + "              ��ϵ�绰"+ "\t" + " �༶"+ "\t" + " ��ע");
			while(rs.next())
			{
				//t=rs.getString("ѧ��");//�����������
				System.out.print(rs.getString("ѧ��").toString()+"\t");
				System.out.print(rs.getString("����").toString()+"\t");
				System.out.print(rs.getString("�Ա�").toString()+"\t");
				System.out.print(rs.getString("��������").toString()+"\t");
				System.out.print(rs.getString("��ϵ�绰").toString()+"\t");
				System.out.print(rs.getString("�༶").toString()+"\t");
				System.out.print(rs.getString("��ע").toString()+"\t");
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
			//�رյ�˳���ܳ���
			try {
				rs.close();//�ر����
				stmt.close();//�رս����
				conn.close();//�ر����ݿ������
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
