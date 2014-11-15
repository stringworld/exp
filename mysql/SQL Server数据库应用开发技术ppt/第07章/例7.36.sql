--例7.36
  USE  教务管理数据库
  UPDATE 选课表
  SET 成绩=成绩+5
  WHERE 学号 IN
  (SELECT 学号 FROM 学生表 WHERE 班级='jy071')
