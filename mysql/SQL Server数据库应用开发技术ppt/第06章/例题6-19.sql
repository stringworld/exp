CREATE TABLE 选课表
(
	   学号 char(11),
	   课程号 char(6) REFERENCES 课程表(课程号) ON UPDATE CASCADE,
	   成绩 numeric(5, 1),
) 
