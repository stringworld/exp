package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DownloadServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		//ȡ���ļ���,get��ʽ��Ҫת�봦��
		String filename=new String(request.getParameter("filename").getBytes("iso-8859-1"),"gbk");
		File dir=new File(request.getRealPath("\\download"));
		//���downloadĿ¼�������򴴽�
		if(!dir.exists())
			dir.mkdir();
		//Ҫ���ص��ļ�Ӧ���Ѿ���ӵ�downloadĿ¼��
		File file=new File(dir.getAbsolutePath()+"\\"+filename);
		if(!file.exists()){
			response.setCharacterEncoding("gbk");
			PrintWriter out=response.getWriter();
			out.print("<html><script>");
			out.print("alert('�ļ�������');");
			out.print("location='test.html';");
			out.print("</script></html>");
			return;
		}
		//���б�������,filename��������Ĭ�ϵ��ļ�����,��������к�����Ҫת�봦��
		response.setHeader("content-disposition","attachment;filename="+new String(filename.getBytes("gbk"),"iso-8859-1"));
		byte[] b=new byte[512];
		@SuppressWarnings("unused")
		int i;
		FileInputStream input=new FileInputStream(file);
		ServletOutputStream output=response.getOutputStream();
		while((i=input.read(b))!=-1)
			output.write(b);
		input.close();
		output.close();
	}
}