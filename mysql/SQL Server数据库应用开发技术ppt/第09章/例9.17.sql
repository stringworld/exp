--【例9.17】修改“学生名单”存储过程，结果按学号排序。
USE 教务管理数据库
GO
ALTER PROCEDURE  学生名单
AS
BEGIN
	SELECT 学号,姓名
    FROM 学生表 
    ORDER BY 学号
END
