package dao;
import java.sql.SQLException;

public final class InitialDB extends BaseDAO{
	private InitialDB(){}
	/**
	 * ��ʼ�����ݿ�����
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
			//������Ʒ���ͱ�
			db.update("create table type(id autoincrement(1,1) primary key,name varchar(20) not null,img varchar(50),ptype int)");
			//������Ʒ��
			db.update("create table product(id counter primary key,name varchar(20) not null,img varchar(50) not null,info varchar(50) not null,type int not null)");
			//�������ű�
			db.update("create table news(id counter primary key,title varchar(50) not null,sendTime datetime not null,pageCount int not null)");
			//�����������ݱ�
			db.update("create table newsContent(id counter primary key,newsID int not null,content text not null,img varchar(50),imgdescr varchar(50))");
				//��Ӳ�Ʒ��
				db.update("insert into type(name,img)values('��ȼƽ����ʽ�泵','type1.jpg')");
				db.update("insert into type(name,img)values('��ƿƽ����ʽ�泵','type2.jpg')");
				db.update("insert into type(name,img)values('ǰ��ʽ�泵','type3.jpg')");
				db.update("insert into type(name,img)values('������ҵ����','type4.jpg')");
				db.update("insert into type(name,img)values('����','type5.jpg')");
				//��Ӳ�Ʒϵ��
				db.update("insert into type(name,ptype)values('LHMϵ��',1)");
				db.update("insert into type(name,ptype)values('LWEϵ��',2)");
				db.update("insert into type(name,ptype)values('LPEϵ��',2)");
				db.update("insert into type(name,ptype)values('RR B/Eϵ��',3)");
				db.update("insert into type(name,ptype)values('RR Mϵ��',3)");
				//��Ӳ�Ʒ
				db.update("insert into product(name,img,info,type)values('�泵1','img1.jpg','info1.jpg',6)");
				db.update("insert into product(name,img,info,type)values('�泵2','img2.jpg','info2.jpg',7)");
				//�������
				db.update("insert into news(title,sendTime,pageCount)values('��һ������','2011-11-25 5:20:30',2)");
				db.update("insert into newsContent(newsID,content)values(1,'û��ʲô��˵��')");
				db.update("insert into newsContent(newsID,content)values(1,'��Ҳû��ʲô��˵��')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		InitialDB.init();
	}
}