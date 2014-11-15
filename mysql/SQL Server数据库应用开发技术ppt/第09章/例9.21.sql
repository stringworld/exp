--【例9.21】对学生表创建更新触发器，当有一条记录被更新，就修改班级表中相关班级的人数。
USE 教务管理数据库
GO
CREATE TRIGGER 更新学生
ON  学生表
AFTER UPDATE
AS 
BEGIN
  SET NOCOUNT ON
IF UPDATE(班级)    
  BEGIN
    UPDATE 班级表
      SET 学生人数=学生人数-1
      FROM deleted 
      WHERE 班级表.班号= deleted .班级
     UPDATE 班级表
      SET 学生人数=学生人数+1
      FROM inserted 
      WHERE 班级表.班号=inserted.班级
  END
END
