--【例9.12】创建“某班学生名单”存储过程，其功能是查看某个班级的学生名单，结果按学号排序。
USE 教务管理数据库
GO
CREATE PROCEDURE 某班学生名单
@班名 varchar(20) 
AS
BEGIN
	SELECT 学号,姓名
      FROM 学生表,班级表
      WHERE 学生表.班级=班级表.班号 AND 班名=@班名
      ORDER BY 学号
END
