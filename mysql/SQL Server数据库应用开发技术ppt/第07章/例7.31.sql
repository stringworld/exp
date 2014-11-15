--例7.31
  USE    教务管理数据库
  SELECT 选课表.学号,姓名
  FROM   选课表,学生表
  WHERE  选课表.学号=学生表.学号
  AND    课程号=(SELECT 课程号FROM 课程表WHERE 课程名='大学英语')










