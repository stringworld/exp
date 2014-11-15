--例7.24
  USE  教务管理数据库
  SELECT 姓名
  FROM 学生表 WHERE 班级=’jy071’
  UNION
  SELECT 班主任
  FROM 班级表 WHERE 班号=’jy071’











