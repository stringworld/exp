--例7.20
  USE 教务管理数据库;
  SELECT XS.学号,姓名,KC.课程名,成绩
  FROM 选课表 AS XK
    JOIN 学生表 AS XS ON XK.学号=XS.学号
    RIGHT JOIN 课程表 AS KC ON XK.课程号=KC.课程号










