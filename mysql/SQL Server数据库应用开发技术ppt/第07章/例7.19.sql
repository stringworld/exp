--例7.19
  USE  教务管理数据库
  SELECT XS.学号,姓名,KC.课程名,成绩
  FROM 学生表 AS XS
    LEFT JOIN 选课表 AS XK ON XK.学号=XS.学号
    LEFT JOIN 课程表 AS KC ON XK.课程号=KC.课程号










