USE 教务管理数据库
GO 
CREATE VIEW XS_VIEW5
AS 
SELECT 学号,姓名,性别,政治面貌  FROM  XS_VIEW2 
WHERE 性别='女'
