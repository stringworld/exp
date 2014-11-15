--创建表的同时设置
CREATE TABLE dbo.学生表(
	学号 char(11) NOT NULL,--不允许为空
	姓名 nchar(5) NOT NULL, --不允许为空
	性别 nchar(1) NOT NULL, --不允许为空
	出生日期 datetime NULL,
	政治面貌 varchar(10), 
	入学时间 datetime NOT NULL, --不允许为空
	联系电话 char(20)  NULL,
	班级 char(5)  NULL,
	备注 varchar(200)  NULL
)
--修改表设置
ALTER TABLE 学生表
ALTER COLUMN 学号 CHAR(11) NOT NULL
ALTER TABLE 学生表
ALTER COLUMN 姓名 NCHAR(5) NOT NULL
ALTER TABLE 学生表
ALTER COLUMN 性别 NCHAR(1) NOT NULL
ALTER TABLE 学生表
ALTER COLUMN 入学时间 DATETIME NOT NULL
--执行下列插入数据进行验证效果。
INSERT INTO学生表(学号,姓名) VALUES ('20070101110','张致')
