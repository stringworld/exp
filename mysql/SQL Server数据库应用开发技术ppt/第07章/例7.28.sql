--例7.28
  USE    教务管理数据库
  SELECT 班级, 选课表.学号,姓名,AVG(成绩) AS 均分
  FROM   选课表,学生表
  WHERE  选课表.学号=学生表.学号
  GROUP BY 班级,选课表.学号, 姓名
  HAVING AVG(成绩) > 60 
  ORDER BY AVG(成绩) DESC











