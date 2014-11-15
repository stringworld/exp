--例7.26
  USE    教务管理数据库
  SELECT 课程号,
         max(成绩) 最高分,
         min(成绩) 最低分,
         avg(成绩) 均分
  FROM 选课表
  GROUP BY 课程号












