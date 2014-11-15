--例7.38
  USE  教务管理数据库
  SELECT 学号,姓名
  FROM 学生表
  WHERE NOT EXISTS
    (SELECT * FROM 选课表 WHERE 选课表.学号=学生表.学号)
