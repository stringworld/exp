--【例9.9】修改“某专业男女比例”函数，将比值的小数位设置为1位。
USE 教务管理数据库
GO
ALTER FUNCTION  某专业男女比例
(	
	@专业名 char(6) 
)
RETURNS  numeric(5,1)
AS
BEGIN
	 DECLARE @man int
    DECLARE @woman int
    --统计班级男生人数
    SELECT @man=count(*)
    FROM 学生表,专业表,班级表
    WHERE 学生表.班级= 班级表.班号 AND 班级表.专业= 专业表.专业号 AND 性别='男'  AND 专业名=@专业名
	--统计班级女生人数
    SELECT @woman=count(*)
    FROM 学生表, 专业表, 班级表
    WHERE 学生表.班级= 班级表.班号 AND 班级表.专业= 专业表.专业号 AND 性别='女' AND 专业名=@专业名
	RETURN   cast(@man as float)/cast(@woman as float)
END


