--例7.29
  USE 教务管理数据库
  SELECT 学生表.学号,姓名,课程名,成绩
  FROM   学生表,选课表,课程表
  WHERE  学生表.学号=选课表.学号
  AND 课程表.课程号=选课表.课程号
  AND 选课表.课程号='000001'
  COMPUTE MAX(成绩),MIN(成绩),AVG(成绩)











