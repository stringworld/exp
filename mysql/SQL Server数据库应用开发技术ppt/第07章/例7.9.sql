--例7.9
  USE    教务管理数据库
  SELECT 学号,课程号,成绩 
  FROM   选课表
  WHERE (成绩<60) AND (课程号='000001')



