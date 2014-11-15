package dao;
import java.sql.SQLException;

public final class InitialDB extends BaseDAO{
	private InitialDB(){}
	/**
	 * 初始化数据库数据
	 */
	public static void init(){
		InitialDB db=new InitialDB();
		try {
			db.update("drop table type");
		} catch (SQLException e) {}
		try {
			db.update("drop table product");
		} catch (SQLException e) {}
		try {
			db.update("drop table news");
		} catch (SQLException e) {}
		try {
			db.update("drop table newsContent");
		} catch (SQLException e) {}
		try {
			//创建产品类型表
			db.update("create table type(id autoincrement(1,1) primary key,name varchar(20) not null,img varchar(50),ptype int)");
			//创建产品表
			db.update("create table product(id counter primary key,name varchar(20) not null,img varchar(50) not null,info varchar(50) not null,type int not null)");
			//创建新闻表
			db.update("create table news(id counter primary key,title varchar(50) not null,sendTime datetime not null,pageCount int not null)");
			//创建新闻内容表
			db.update("create table newsContent(id counter primary key,newsID int not null,content text not null,img varchar(50),imgdescr varchar(50))");
				//添加产品类
				db.update("insert into type(name,img)values('内燃平衡重式叉车','type1.jpg')");
				db.update("insert into type(name,img)values('电瓶平衡重式叉车','type2.jpg')");
				db.update("insert into type(name,img)values('前移式叉车','type3.jpg')");
				db.update("insert into type(name,img)values('其它产业车辆','type4.jpg')");
				db.update("insert into type(name,img)values('属具','type5.jpg')");
				//添加产品系列
				db.update("insert into type(name,ptype)values('LHM系列',1)");
				db.update("insert into type(name,ptype)values('LWE系列',2)");
				db.update("insert into type(name,ptype)values('LPE系列',2)");
				db.update("insert into type(name,ptype)values('RR B/E系列',3)");
				db.update("insert into type(name,ptype)values('RR M系列',3)");
				//添加产品
				db.update("insert into product(name,img,info,type)values('叉车1','img1.jpg','info1.jpg',6)");
				db.update("insert into product(name,img,info,type)values('叉车2','img2.jpg','info2.jpg',7)");
				//添加新闻
				db.update("insert into news(title,sendTime,pageCount)values('第一条新闻','2011-11-25 5:20:30',2)");
				db.update("insert into newsContent(newsID,content)values(1,'没有什么可说的')");
				db.update("insert into newsContent(newsID,content)values(1,'这也没有什么可说的')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		InitialDB.init();
	}
}