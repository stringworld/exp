CREATE TABLE 课程表(
	课程号 char(6) PRIMARY KEY,
	课程名 varchar(20)  NULL,
	学时 tinyint NULL,
	学分 tinyint NULL,
	课程类型 nchar(5)  NULL,
	课程性质 nchar(2)  NULL,
	考核方式 nchar(2)  NULL,
	学期 char(1)  NULL,
	备注 varchar(200)  NULL
) 
