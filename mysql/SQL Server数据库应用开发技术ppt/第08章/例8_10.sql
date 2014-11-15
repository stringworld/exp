USE 教务管理数据库
GO 
CREATE VIEW XS_VIEW1
AS 
SELECT *  FROM   学生表
WHERE 政治面貌='共产党员'
