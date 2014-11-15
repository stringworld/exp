CREATE TABLE dbo.学生表(
	  学号 char(11) NULL,
	  姓名 nchar(5) NULL,
	  性别 nchar(1)  NULL,
	  出生日期 datetime NULL,
      身份证号 char(18) UNIQUE,  --设置唯一约束，省略约束名，系统自动命名
	  政治面貌 varchar(10), 
	  入学时间 datetime NULL,
	  联系电话 char(20)  NULL,
	  班级 char(5)  NULL,
	  备注 varchar(200)  NULL
)
