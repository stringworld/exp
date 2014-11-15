CREATE TABLE dbo.学生表(
学号 char(11) NULL,
姓名 nchar(5) NULL,
性别 nchar(1)  CHECK(性别='男' OR 性别='女')  ,
出生日期 datetime NULL,
政治面貌 varchar(10), 
入学时间 datetime NULL,
联系电话 char(20)  CHECK (联系电话 LIKE '[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
班级 char(5)  NULL,
备注 varchar(200)  NULL
)
