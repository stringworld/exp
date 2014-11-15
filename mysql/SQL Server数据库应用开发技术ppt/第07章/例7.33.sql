--例7.33 
  Use  教务管理数据库
  SELECT 学号,姓名
  FROM 学生表
  WHERE 班级='jy072' AND 学号 NOT IN
    (SELECT 学号 FROM 选课表 WHERE 课程号='000001')












