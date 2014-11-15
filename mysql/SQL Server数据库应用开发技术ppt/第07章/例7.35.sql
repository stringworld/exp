--例7.35
  USE  教务管理数据库
  GO
  CREATE TABLE 选课表1
  (
	学号 char(11),
	课程号 char(6),
	成绩 numeric(5, 1)
  ) 
  INSERT INTO 选课表
  SELECT * FROM 选课表WHERE 课程号='000001'
