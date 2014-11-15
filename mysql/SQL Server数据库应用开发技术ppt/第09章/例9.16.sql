--【例9.16】查看学号为“20070101101”的学生的姓名和年龄。
DECLARE  @name nchar(5)
DECLARE @age int 
EXEC  查询学生  '20070101101' , @name output , @age output
PRINT @name
PRINT @age
