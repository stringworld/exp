--例7.3
  USE    教务管理数据库
  SELECT 姓名 学生姓名,性别,datediff(year,出生日期,getdate()) as 年龄
  FROM   学生表
  或
  SELECT 学生姓名=姓名,性别, 年龄=datediff(year,出生日期,getdate()) 
  FROM   学生表


