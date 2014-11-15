--【例9.13】创建“查询学生”存储过程，其功能是根据学号查询学生的姓名和年龄。
USE 教务管理数据库
GO
CREATE PROCEDURE 查询学生3
	@学号 char(11), @姓名 nchar(5) OUTPUT,@年龄 int OUTPUT
AS
BEGIN
	SELECT @姓名=姓名,@年龄=DATEDIFF(year,出生日期,getdate())
      FROM 学生表
      WHERE 学号=@学号
END
