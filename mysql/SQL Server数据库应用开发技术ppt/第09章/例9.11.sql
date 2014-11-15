--【例9.11】创建“学生名单”存储过程，其功能是输出所有学生的名单。
USE 教务管理数据库
GO
CREATE PROCEDURE  学生名单
AS
BEGIN
	SELECT 学号,姓名 FROM 学生表
END
上例是没有参数的存储过程示例。
