--例7.32
  USE	 教务管理数据库
  SELECT 姓名, datediff(year,出生日期,getdate()) 年龄
  FROM   学生表
  WHERE  班级<>'jy072' AND datediff(year,出生日期,getdate())<
					(SELECT MIN(datediff(year,出生日期,getdate())) 
					 FROM 学生表
					 WHERE 班级='jy072')











