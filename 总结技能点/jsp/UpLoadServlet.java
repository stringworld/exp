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
	 * 封装了添加新闻的细节
	 */
	@SuppressWarnings("deprecation")
	private boolean addNews(HttpServletRequest request) throws IOException {
		News news=new News();
		ServletInputStream input=request.getInputStream();//输入流
		FileOutputStream output=null;//输出流
		String charset="gbk";//页面编码
		byte[] b=new byte[1024];//缓存
		int i;//每行实际读取到的字节数
		String line;//每行信息
		String first="-----------------------------";//规律的地方
		List<String> names=new ArrayList<String>();//防止重复读取
		List<String> imgs=new ArrayList<String>();//图片集合
		while((i=input.readLine(b,0,b.length))!=-1){
			line=new String(b,0,i);
			if(line.indexOf("Content-Disposition:")!=-1){
				String name=null;//name属性
				if(line.indexOf("filename")!=-1){//是图片
					name=line.substring(line.indexOf("name")+6,line.lastIndexOf(";")-1);
					if(names.contains(name))
						continue;
					//注意文件名不能为空
					String suffix=line.substring(line.lastIndexOf(".")+1,line.lastIndexOf("\""));//取出文件后缀
					if(!suffix.matches("\\w+"))//如果后缀不正常,文件名一般为空时
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
				}else{//是文本
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