--例7.23
  USE 教务管理数据库;
  SELECT XS1.姓名,XS1.学号,XS2.学号
  FROM 学生表 AS XS1
    JOIN 学生表 AS XS2 ON XS1.姓名=XS2.姓名
  WHERE XS1.学号<>XS2.学号











