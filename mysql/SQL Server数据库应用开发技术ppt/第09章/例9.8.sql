--【例9.8】查看用户定义函数“某班某课成绩单”的依赖关系
USE 教务管理数据库
EXEC sp_depends @objname = 'dbo.某班某课成绩单' 


