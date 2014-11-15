USE 教务管理数据库
GO 
CREATE VIEW XS_VIEW3
AS 
SELECT 学生表.学号,姓名,性别,课程号 FROM  学生表,选课表
WHERE  学生表.学号=选课表.学号AND 班级='jy071'
