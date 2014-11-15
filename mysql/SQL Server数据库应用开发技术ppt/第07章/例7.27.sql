--例7.27
  use 教务管理数据库
  select 班级, 性别, 
    max(datediff(year,出生日期,getdate())) 最大年龄,
    min(datediff(year,出生日期,getdate())) 最小年龄,
    avg(datediff(year,出生日期,getdate())) 平均年龄,
    count(*) as 人数
  from 学生表
  group by 班级,性别












