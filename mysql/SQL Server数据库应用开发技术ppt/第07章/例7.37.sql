--例7.37
  USE  教务管理数据库
  SELECT 学号,姓名
  FROM 学生表
  WHERE EXISTS
    (SELECT * FROM 选课表 
     WHERE 选课表.学号=学生表.学号 AND 课程号='000001')
