--【例9.19】对学生表创建插入触发器，当有一条新的记录插入表中，就更新班级表中相应班级的人数。
USE 教务管理数据库
GO
CREATE TRIGGER 增加学生
   ON  学生表
   AFTER  INSERT
AS 
BEGIN
SET NOCOUNT ON
IF UPDATE(班级)
    BEGIN   
      UPDATE 班级表
        SET 学生人数=学生人数+1
        FROM inserted 
        WHERE 班级表.班号=inserted.班级
     END
END
