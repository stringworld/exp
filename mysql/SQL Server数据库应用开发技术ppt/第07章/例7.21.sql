--例7.21
  USE 教务管理数据库
  SELECT LEFT(XS.姓名,1) AS 姓氏,XS.姓名 AS 学生姓名,BJ.班主任 AS 班主任姓名
  FROM 班级表 AS BJ
  FULL JOIN 学生表 AS XS 
  ON LEFT(BJ.班主任,1) = LEFT(XS.姓名,1)










