USE 教务管理数据库
GO 
CREATE VIEW XS_VIEW4
AS 
SELECT 学号,SUM(成绩) AS 总成绩 FROM  选课表
GROUP BY 学号
