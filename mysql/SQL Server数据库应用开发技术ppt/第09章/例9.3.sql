--【例9.3】创建用户定义函数，其功能是可用于查看某班某课程的成绩单。
USE 教务管理数据库
GO
CREATE FUNCTION 某班某课成绩单
(	
	@班名 char(20), 
	@课程名 varchar(20)
)
RETURNS TABLE 
AS
RETURN 
	SELECT 班名, 学生表.学号, 姓名, 课程名,成绩
    FROM 班级表,课程表, 选课表, 学生表
    WHERE 课程表.课程号 = 选课表.课程号 AND 学生表.学号 = 选课表.学号 
      AND 学生表.班级 = 班级表.班号 AND 班名= @班名 AND 课程名= @课程名
