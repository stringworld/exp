package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDAO;
import entity.News;

@SuppressWarnings("serial")
public class NewsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean ok=false;
		try {
			ok=addNews(request);
		} catch (Exception e) {}
		request.setAttribute("ok",ok);
		request.getRequestDispatcher("back/news_add.jsp").forward(request, response);
	}
	/**
	 * ��װ��������ŵ�ϸ��
	 */
	@SuppressWarnings("deprecation")
	private boolean addNews(HttpServletRequest request) throws IOException {
		News news=new News();
		ServletInputStream input=request.getInputStream();//������
		FileOutputStream output=null;//�����
		String charset="gbk";//ҳ�����
		byte[] b=new byte[1024];//����
		int i;//ÿ��ʵ�ʶ�ȡ�����ֽ���
		String line;//ÿ����Ϣ
		String first="-----------------------------";//���ɵĵط�
		List<String> names=new ArrayList<String>();//��ֹ�ظ���ȡ
		List<String> imgs=new ArrayList<String>();//ͼƬ����
		while((i=input.readLine(b,0,b.length))!=-1){
			line=new String(b,0,i);
			if(line.indexOf("Content-Disposition:")!=-1){
				String name=null;//name����
				if(line.indexOf("filename")!=-1){//��ͼƬ
					name=line.substring(line.indexOf("name")+6,line.lastIndexOf(";")-1);
					if(names.contains(name))
						continue;
					//ע���ļ�������Ϊ��
					String suffix=line.substring(line.lastIndexOf(".")+1,line.lastIndexOf("\""));//ȡ���ļ���׺
					if(!suffix.matches("\\w+"))//�����׺������,�ļ���һ��Ϊ��ʱ
						continue;
					String filename=UUID.randomUUID()+"."+suffix;
					imgs.add(filename);
					File file=new File(request.getRealPath("\\")+"images_news");
					if(!file.exists())
						file.mkdir();
					output=new FileOutputStream(file+"\\"+filename);
					input.readLine(b,0,b.length);
					input.readLine(b,0,b.length);
					while((i=input.readLine(b,0,b.length))!=-1){
						line=new String(b,0,i);
						if(line.indexOf(first)!=-1)
							break;
						output.write(b,0,i);
					}
					output.close();
				}else{//���ı�
					name=line.substring(line.indexOf("name")+6,line.lastIndexOf("\""));
					if(names.contains(name))
						continue;
					input.readLine(b,0,b.length);
					if("title".equals(name)){
						i=input.readLine(b,0,b.length);
						line=new String(b,0,i,charset);
						news.setTitle(line.trim());
					}else if("time".equals(name)){
						i=input.readLine(b,0,b.length);
						line=new String(b,0,i,charset);
						try{
							Date date = DateFormat.getDateInstance().parse(line);
							news.setTime(date);
						}catch(Exception e){}
					}else if("content".equals(name)){
						StringBuilder sb=new StringBuilder();
						while((i=input.readLine(b,0,b.length))!=-1){
							line=new String(b,0,i,charset);
							if(line.indexOf(first)!=-1)
								break;
							sb.append(line);
						}
						news.setContent(sb.toString().trim().replace("\r\n","<br/>"));
					}
				}
				names.add(name);
			}
		}
		input.close();
		news.setImgs(imgs.toArray(new String[0]));
		return new NewsDAO().addNews(news);
	}
}