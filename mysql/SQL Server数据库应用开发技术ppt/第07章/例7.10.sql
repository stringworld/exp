--例7.10
  USE    教务管理数据库
  SELECT 学号,课程号,成绩 
  FROM   选课表
  WHERE (课程号='000001') AND(成绩 BETWEEN 90 AND 100)




