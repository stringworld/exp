package students;

import java.sql.*;
import javax.swing.*;
import java.util.ArrayList;
public class StudentDBA {
	private static ArrayList<Student> students=new ArrayList<Student>();//��Ŷ�ȡ��ѧ����¼
	private static Connection conn=null;
	private static Statement statement =null;
	private static ResultSet rs=null;
	private static int loc=0;
	
	private static void getDBConnection()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn=DriverManager.getConnection("jdbc:odbc:students");
		}
		catch(ClassNotFoundException e1)
		{
			JOptionPane.showMessageDialog(null, "�Ҳ������ݿ����������࣡\n"+e1,"��ʾ",JOptionPane.ERROR_MESSAGE);
		}
		catch(SQLException e2)
		{
			JOptionPane.showMessageDialog(null,"�޷��������ݿ⣡\n"+e2,"��ʾ",JOptionPane.ERROR_MESSAGE);
		}
	}
	public static ArrayList<Student> getAllStudents()
	{
		String strSql="SELECT * FROM students ";
		students.clear();
		try
		{
			getDBConnection();
			statement=conn.createStatement();
			rs=statement.executeQuery(strSql);
			while(rs.next())
			{
				Student stu=new Student();
				stu.setStuNo(rs.getString(1));
				stu.setStuName(rs.getString(2));
				stu.setStuAge(rs.getString(3));
				stu.setStuSex(rs.getString(4));
				stu.setStuDepartment(rs.getString(5));
				stu.setStuPhone(rs.getString(6));
				stu.setStuEmail(rs.getString(7));
				stu.setStuHistory(rs.getString(8));
				students.add(stu);
			}
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"�޷��������ݿ⣡\n"+e,"��ʾ",JOptionPane.ERROR_MESSAGE);
		}
		finally
		{
			close();
		}
		return students;
	    }
		public static Student getCurrentStudent()
		{
			if(students.size()>0)
			{
				return (Student)students.get(loc);
			}
			else
			{
				return null;
			}
		}
		public static Student getNextStudent()
		{
			loc++;
			if(loc<students.size())
			{
				return (Student)students.get(loc);
			}
			else
			{
				loc--;
				return (Student)students.get(loc);
			}
		}
		public static Student getPrevStudent()
		{
			loc--;
			if(loc>=0)
			{
				return (Student)students.get(loc);
			}
			else
			{
				loc++;
				return (Student)students.get(loc);
			}
		}
		public static Student getFirstStudent()
		{
			Student s=new Student();
			if(students.size()>0)
			{
				loc=0;
				s=(Student)students.get(loc);
			}
		return s;
		}
		public static Student getLastStudent()
		{ 
			if(students.size()>0)
			{
				loc=students.size()-1;
				return (Student)students.get(loc);
			}
			else
			{
				return null;
			}
		}
		
		//�����Ϣ
		public static void addStudent(Student s)
		{
			String strSQL="INSERT INTO students VALUES(";
			strSQL+="'"+s.getStuNo()+"'"+",";
			strSQL+="'"+s.getStuName()+"'"+",";
			strSQL+="'"+s.getStuAge()+"'"+",";
			strSQL+="'"+s.getStuSex()+"'"+",";
			strSQL+="'"+s.getStuDepartment()+"'"+",";
			strSQL+="'"+s.getStuPhone()+"'"+",";
			strSQL+="'"+s.getStuEmail()+"'"+",";
			strSQL+="'"+s.getStuHistory()+"'"+")";
			try
			{
				getDBConnection();
				statement=conn.createStatement();
				statement.executeUpdate(strSQL);
				loc=students.size()-1;
				JOptionPane.showMessageDialog(null,"��¼����ȷ���룡");
			}
			catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null,"�������ݷ�������\n"+e,"����",JOptionPane.ERROR_MESSAGE);
			}
			finally
			{
				close();
			}
		}
		
		//ɾ��
		public static void deleteStudent()
		{
			Student s=getCurrentStudent();
			String strSQL="DELETE FROM students WHERE stuNo='"+s.getStuNo()+"'";
			try
			{
				getDBConnection();
				statement=conn.createStatement();
				int n=statement.executeUpdate(strSQL);
				JOptionPane.showMessageDialog(null,n+"�б�ɾ����");
				if(loc>0)
				{
					loc--;
				}
			}
			catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null,"����ɾ����������\n"+e,"����",JOptionPane.ERROR_MESSAGE);
			}
			finally
			{
				close();
			}
		}
		public static void updateStudent(Student s)
		{
			String strSQL="UPDATE students SET ";
			strSQL+="stuNo="+"'"+s.getStuNo()+"',";
			strSQL+="stuName="+"'"+s.getStuName()+"',";
			strSQL+="stuAge="+"'"+s.getStuAge()+"'"+",";
			strSQL+="stuSex="+"'"+s.getStuSex()+"'"+",";
			strSQL+="stuDepartment="+"'"+s.getStuDepartment()+"'"+",";
			strSQL+="stuPhone="+"'"+s.getStuPhone()+"'"+",";
			strSQL+="stuEmail="+"'"+s.getStuEmail()+"'";
			strSQL+="stuHistory="+"'"+s.getStuHistory()+"'";
			strSQL+="WHERE stuNo="+"'"+s.getStuNo()+"'";//
			
			try
			{
				getDBConnection();
				statement=conn.createStatement();
				int n=statement.executeUpdate(strSQL);
				JOptionPane.showMessageDialog(null,n+"�б��޸ģ�");
			}
			catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null,"�����޸�δ��ɣ�\n"+e,"����",JOptionPane.ERROR_MESSAGE);
			}
			finally
			{
				close();
			}
		}
		static void close()
		{
			try
			{
				if(statement!=null)
				{
					statement.close();
				}
				if(rs==null)
				{
					rs.close();
				}
				if(conn!=null)
				{
					conn.close();
				}
			}
			catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null,"���ݿ�رղ�����������\n"+e,"����",JOptionPane.ERROR_MESSAGE);
			}
		}		
}
