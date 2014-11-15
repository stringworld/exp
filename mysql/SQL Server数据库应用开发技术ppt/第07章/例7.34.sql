--例7.34
  USE  教务管理数据库
  SELECT 课程号,课程名
  FROM 课程表
  WHERE 课程号<>ALL(SELECT 课程号 FROM 选课表)
