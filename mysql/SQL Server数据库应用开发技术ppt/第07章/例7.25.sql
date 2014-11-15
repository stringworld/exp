--例7.25
  USE  教务管理数据库
  SELECT  max(成绩) 最高分,
          min(成绩) 最低分,
          avg(成绩) 均分,
          sum(成绩) 总分,
          count(*) AS 人数
  FROM 选课表
  WHERE 课程号='000001'












