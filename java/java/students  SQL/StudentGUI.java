package students;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class StudentGUI extends JFrame{
		/**
	 * 
	 */
	    private static final long serialVersionUID = 1L;
		//���崰���е�7����ǩ�������Ҷ���
		private final JLabel labStuNo=new JLabel("ѧ��",JLabel.RIGHT);
		private final JLabel labStuName=new JLabel("����",JLabel.RIGHT);
		private final JLabel labStuAge=new JLabel("����",JLabel.RIGHT);
		private final JLabel labStuSex=new JLabel("�Ա�",JLabel.RIGHT);
		private final JLabel labStuDepartment=new JLabel("ϵ��",JLabel.RIGHT);
		private final JLabel labStuPhone=new JLabel("�绰",JLabel.RIGHT);
		private final JLabel labStuEmail=new JLabel("e-mail",JLabel.RIGHT);//History
		
		//7���ı���
		private final JTextField txtStuNo=new JTextField(12);
		private final JTextField txtStuName=new JTextField(12);
		private final JTextField txtStuAge=new JTextField(12);
		private final JTextField txtStuSex=new JTextField(12);
		private final JTextField txtStuDepartment=new JTextField(12);
		private final JTextField txtStuPhone=new JTextField(12);
		private final JTextField txtStuEmail=new JTextField(12);
		
		//���崰������ʾѧ��������Ϣ���ı���
		private final JTextArea txtArea=new JTextArea(13,34);
		
		//��������
		private final JScrollPane scrollPane=new JScrollPane(txtArea);
		
		//��ʾѧ����Ϣ��4����ť
		private final JButton btnFirst=new JButton("<<",new ImageIcon("students/images/first.gif"));
		private final JButton btnPrior=new JButton("<",new ImageIcon("students/images/pre.gif"));
		private final JButton btnNext=new JButton(">",new ImageIcon("students/images/next.gif"));
		private final JButton btnLast=new JButton(">>",new ImageIcon("students/images/last.gif"));
		
		//���幤����
		JToolBar toolBar=new JToolBar("�ı�������");
		private final JButton btnUpdate=new JButton("�޸�",new ImageIcon("students/images/update.gif"));
		private final JButton btnDelete=new JButton("ɾ��",new ImageIcon("students/images/Delete.gif"));
		private final JButton btnInsert=new JButton("���",new ImageIcon("students/images/Insert.gif"));
		private final JButton btnExit=new JButton("�˳�",new ImageIcon("students/images/Exit.gif"));
		
		//ѡ�
		private final JTabbedPane tabbedPane=new JTabbedPane();
		
		//ѡ��е�2�����
		private final JPanel tabbedPanel1=new JPanel();
		private final JPanel tabbedPanel2=new JPanel();
		
		//7����ǩ�����
		private final JPanel labPanel=new JPanel();
		
		//7���ı�������
		private final JPanel txtPanel=new JPanel();
		
		//4����ť�����
		private final JPanel btnPanel=new JPanel();
		
		//���幹�췽��
		StudentGUI()
		{
			
			//4�����߰�ť��ӵ�������
			toolBar.add(btnUpdate);
			toolBar.add(btnDelete);
			toolBar.add(btnInsert);
			toolBar.add(btnExit);
			
			//��ʾ��Ϣ
			btnUpdate.setToolTipText("����һ����¼");
			btnDelete.setToolTipText("ɾ��һ����¼");
			btnInsert.setToolTipText("����һ����¼");
			btnExit.setToolTipText("�˳�����");
			
			final Container cp=this.getContentPane();
			cp.setLayout(new BorderLayout(5,5));
			//��ӹ������
			cp.add(BorderLayout.NORTH,toolBar);
			
			//������
			labPanel.setLayout(new GridLayout(7,1,8,8));
			labPanel.add(labStuNo);
			labPanel.add(labStuName);
			labPanel.add(labStuAge);
			labPanel.add(labStuSex);
			labPanel.add(labStuDepartment);
			labPanel.add(labStuPhone);
			labPanel.add(labStuEmail);
			
			//�����ı������岼�ֹ�����
			txtPanel.setLayout(new GridLayout(7,1,8,8));
			
			//��ӵ�txtPanel��
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
			
			
			//��һ��ѡ��Ĺ�����
			tabbedPanel1.setLayout(new BorderLayout(10,10));
			
			//��ǩ
			tabbedPanel1.add(BorderLayout.WEST,labPanel);
			
			//�ı���
			tabbedPanel1.add(BorderLayout.CENTER,txtPanel);
			//������
			tabbedPanel2.add(scrollPane);
			//����ѡ�Կ�
			tabbedPane.add("������Ϣ",tabbedPanel1);
			tabbedPane.add("���˼���",tabbedPanel2);
			
			//ѡ�Կ�
			cp.add(tabbedPane);
			
			//4����ť�в�
			btnPanel.add(btnFirst);
			btnPanel.add(btnPrior);
			btnPanel.add(btnNext);
			btnPanel.add(btnLast);
			
			//�ϲ�
			cp.add(BorderLayout.SOUTH,btnPanel);
			
			//����
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
		  //��ɾ����ť����¼�������
		    btnDelete.addActionListener(new ActionListener(){
		    	public void actionPerformed(final ActionEvent e){
		    		StudentDBA.deleteStudent();
		    		refreshStudent();
		    	}
		    });
		    //����Ӱ�ť����¼�������
		    btnInsert.addActionListener(new ActionListener(){
		    	public void actionPerformed(final ActionEvent e){
		    		final Student s = getStudent();
		    		StudentDBA.addStudent(s);
		    		refreshStudent();
		    	}
		    });
		    //���˳���ť����¼�������
		    btnExit.addActionListener(new ActionListener(){
		    	public void actionPerformed(final ActionEvent e){
		    		System.exit(1);
		    	}
		    });
		    
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setTitle("ѧ����Ϣ����");
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