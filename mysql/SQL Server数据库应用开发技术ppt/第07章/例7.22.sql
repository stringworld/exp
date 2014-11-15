--例7.22
  USE    教务管理数据库
  SELECT 姓名,课程名
  FROM   学生表 CROSS JOIN 课程表
  WHERE  课程性质='必修'











