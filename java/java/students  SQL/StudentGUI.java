package students;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class StudentGUI extends JFrame{
		/**
	 * 
	 */
	    private static final long serialVersionUID = 1L;
		//定义窗口中的7个标签，并向右对其
		private final JLabel labStuNo=new JLabel("学号",JLabel.RIGHT);
		private final JLabel labStuName=new JLabel("姓名",JLabel.RIGHT);
		private final JLabel labStuAge=new JLabel("年龄",JLabel.RIGHT);
		private final JLabel labStuSex=new JLabel("性别",JLabel.RIGHT);
		private final JLabel labStuDepartment=new JLabel("系别",JLabel.RIGHT);
		private final JLabel labStuPhone=new JLabel("电话",JLabel.RIGHT);
		private final JLabel labStuEmail=new JLabel("e-mail",JLabel.RIGHT);//History
		
		//7个文本框
		private final JTextField txtStuNo=new JTextField(12);
		private final JTextField txtStuName=new JTextField(12);
		private final JTextField txtStuAge=new JTextField(12);
		private final JTextField txtStuSex=new JTextField(12);
		private final JTextField txtStuDepartment=new JTextField(12);
		private final JTextField txtStuPhone=new JTextField(12);
		private final JTextField txtStuEmail=new JTextField(12);
		
		//定义窗口中显示学生简历信息的文本区
		private final JTextArea txtArea=new JTextArea(13,34);
		
		//滚动窗口
		private final JScrollPane scrollPane=new JScrollPane(txtArea);
		
		//显示学生信息的4个按钮
		private final JButton btnFirst=new JButton("<<",new ImageIcon("students/images/first.gif"));
		private final JButton btnPrior=new JButton("<",new ImageIcon("students/images/pre.gif"));
		private final JButton btnNext=new JButton(">",new ImageIcon("students/images/next.gif"));
		private final JButton btnLast=new JButton(">>",new ImageIcon("students/images/last.gif"));
		
		//定义工具栏
		JToolBar toolBar=new JToolBar("文本工具条");
		private final JButton btnUpdate=new JButton("修改",new ImageIcon("students/images/update.gif"));
		private final JButton btnDelete=new JButton("删除",new ImageIcon("students/images/Delete.gif"));
		private final JButton btnInsert=new JButton("添加",new ImageIcon("students/images/Insert.gif"));
		private final JButton btnExit=new JButton("退出",new ImageIcon("students/images/Exit.gif"));
		
		//选项卡
		private final JTabbedPane tabbedPane=new JTabbedPane();
		
		//选项卡中的2个面板
		private final JPanel tabbedPanel1=new JPanel();
		private final JPanel tabbedPanel2=new JPanel();
		
		//7个标签的面板
		private final JPanel labPanel=new JPanel();
		
		//7个文本框的面板
		private final JPanel txtPanel=new JPanel();
		
		//4个按钮的面板
		private final JPanel btnPanel=new JPanel();
		
		//定义构造方法
		StudentGUI()
		{
			
			//4个工具按钮添加到工具栏
			toolBar.add(btnUpdate);
			toolBar.add(btnDelete);
			toolBar.add(btnInsert);
			toolBar.add(btnExit);
			
			//提示信息
			btnUpdate.setToolTipText("更新一条记录");
			btnDelete.setToolTipText("删除一条记录");
			btnInsert.setToolTipText("插入一条记录");
			btnExit.setToolTipText("退出程序");
			
			final Container cp=this.getContentPane();
			cp.setLayout(new BorderLayout(5,5));
			//添加功夫巨烂
			cp.add(BorderLayout.NORTH,toolBar);
			
			//管理器
			labPanel.setLayout(new GridLayout(7,1,8,8));
			labPanel.add(labStuNo);
			labPanel.add(labStuName);
			labPanel.add(labStuAge);
			labPanel.add(labStuSex);
			labPanel.add(labStuDepartment);
			labPanel.add(labStuPhone);
			labPanel.add(labStuEmail);
			
			//放置文本框的面板布局管理器
			txtPanel.setLayout(new GridLayout(7,1,8,8));
			
			//添加到txtPanel中
			final JPanel p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
			p1.add(txtStuNo);
			txtPanel.add(p1);
			final JPanel p2=new JPanel(new FlowLayout(FlowLayout.LEFT));
			p2.add(txtStuName);
			txtPanel.add(p2);
			
			final JPanel p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
			p3.add(txtStuAge);
			txtPanel.add(p3);
			
			final JPanel p4=new JPanel(new FlowLayout(FlowLayout.LEFT));
			p4.add(txtStuSex);
			txtPanel.add(p4);
						
			final JPanel p5=new JPanel(new FlowLayout(FlowLayout.LEFT));
			p5.add(txtStuDepartment);
			txtPanel.add(p5);
			
			final JPanel p6=new JPanel(new FlowLayout(FlowLayout.LEFT));
			p6.add(txtStuPhone);
			txtPanel.add(p6);
			
			final JPanel p7=new JPanel(new FlowLayout(FlowLayout.LEFT));
			p7.add(txtStuEmail);
			txtPanel.add(p7);
			
			
			//第一个选项卡的管理器
			tabbedPanel1.setLayout(new BorderLayout(10,10));
			
			//标签
			tabbedPanel1.add(BorderLayout.WEST,labPanel);
			
			//文本框
			tabbedPanel1.add(BorderLayout.CENTER,txtPanel);
			//滚动条
			tabbedPanel2.add(scrollPane);
			//两个选显卡
			tabbedPane.add("个人信息",tabbedPanel1);
			tabbedPane.add("个人简历",tabbedPanel2);
			
			//选显卡
			cp.add(tabbedPane);
			
			//4个按钮中部
			btnPanel.add(btnFirst);
			btnPanel.add(btnPrior);
			btnPanel.add(btnNext);
			btnPanel.add(btnLast);
			
			//南部
			cp.add(BorderLayout.SOUTH,btnPanel);
			
			//调用
			refreshStudent();
			
		    btnFirst.addActionListener(new ActionListener(){
		    	public void actionPerformed(final ActionEvent e)
		    	{
		    		final Student s=StudentDBA.getFirstStudent();
		    		showStudent(s);
		    	}
		    });
		    
		    btnPrior.addActionListener(new ActionListener(){
		    	public void actionPerformed(final ActionEvent e)
		    	{
		    		final Student s=StudentDBA.getPrevStudent();
		    		showStudent(s);
		    	}
		    });
		    
		    btnNext.addActionListener(new ActionListener(){
		    	public void actionPerformed(final ActionEvent e)
		    	{
		    		final Student s=StudentDBA.getNextStudent();
		    		showStudent(s);
		    	}
		    });
		    
		    btnLast.addActionListener(new ActionListener(){
		    	public void actionPerformed(final ActionEvent e)
		    	{
		    		final Student s=StudentDBA.getLastStudent();
		    		showStudent(s);
		    	}
		    });
		    
		    btnUpdate.addActionListener(new ActionListener(){
		    	public void actionPerformed(final ActionEvent e)
		    	{
		    		Student s=new Student();
		    		s=getStudent();
		    		StudentDBA.updateStudent(s);
		    		refreshStudent();
		    	}
		    });
		  //给删除按钮添加事件监听器
		    btnDelete.addActionListener(new ActionListener(){
		    	public void actionPerformed(final ActionEvent e){
		    		StudentDBA.deleteStudent();
		    		refreshStudent();
		    	}
		    });
		    //给添加按钮添加事件监听器
		    btnInsert.addActionListener(new ActionListener(){
		    	public void actionPerformed(final ActionEvent e){
		    		final Student s = getStudent();
		    		StudentDBA.addStudent(s);
		    		refreshStudent();
		    	}
		    });
		    //给退出按钮添加事件监听器
		    btnExit.addActionListener(new ActionListener(){
		    	public void actionPerformed(final ActionEvent e){
		    		System.exit(1);
		    	}
		    });
		    
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setTitle("学生信息管理");
		    this.setSize(400,400);
		    this.setVisible(true);
		    }
		    private void showStudent(final Student s){
		    	txtStuNo.setText(s.getStuNo());
		    	txtStuName.setText(s.getStuName());
		    	txtStuAge.setText(s.getStuAge());
		    	txtStuSex.setText(s.getStuSex());
		    	txtStuDepartment.setText(s.getStuDepartment());
		    	txtStuPhone.setText(s.getStuPhone());
		    	txtStuEmail.setText(s.getStuEmail());
		       
		    }

		    private void clearStudent(){
		    	txtStuNo.setText("");
		    	txtStuName.setText("");
		    	txtStuAge.setText("");
		    	txtStuSex.setText("");
		    	txtStuDepartment.setText("");
		    	txtStuPhone.setText("");
		    	txtStuEmail.setText("");
		    	txtArea.setText("");
		    }

		    private Student getStudent(){
		    	final Student s = new Student();
		    	s.setStuNo(txtStuNo.getText());
		    	s.setStuName(txtStuName.getText());
		    	s.setStuAge(txtStuAge.getText());
		    	s.setStuSex(txtStuSex.getText());
		    	s.setStuDepartment(txtStuDepartment.getText());
		    	s.setStuPhone(txtStuPhone.getText());
		    	s.setStuEmail(txtStuEmail.getText());
		    	return s;
		    }

		    private void refreshStudent(){
		    	StudentDBA.getAllStudents();
		    	final Student s = StudentDBA.getCurrentStudent();
		    	if(s != null){
		    		showStudent(s);
		    	}
		    	else clearStudent();
		    }
		    public static void main(String[] args)
		    {
		    	new StudentGUI();
		    }
}