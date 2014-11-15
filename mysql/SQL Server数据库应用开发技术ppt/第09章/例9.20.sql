--【例9.20】对学生表创建删除触发器，当有一条记录插入表中，就减少班级表中相应班级的人数。
USE 教务管理数据库
GO
CREATE TRIGGER 删除学生
ON  学生表
AFTER  DELETE
AS 
BEGIN
SET NOCOUNT ON
    BEGIN   
      UPDATE 班级表
        SET 学生人数=学生人数-1
        FROM deleted 
        WHERE 班级表.班号=deleted.班级
    END
END
