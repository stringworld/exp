--例7.18
  USE 教务管理数据库
  SELECT XK.学号,姓名,KC.课程名,成绩
  FROM 选课表 AS XK
    INNER JOIN 学生表 AS XS ON XK.学号=XS.学号
    INNER JOIN 课程表 AS KC ON XK.课程号=KC.课程号











