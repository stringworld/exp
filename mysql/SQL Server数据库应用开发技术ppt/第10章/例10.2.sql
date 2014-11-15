--【例10.2】创建触发器“增加学生”，以保证在向学生表插入记录时，班级表中的学生人数相应正确更新。

CREATE TRIGGER 增加学生
   ON  学生表
   AFTER  INSERT
AS 
BEGIN
  SET NOCOUNT ON
  IF UPDATE(班级)
  BEGIN   
    --插入了多条学生记录
    DECLARE @i int
    DECLARE @classId char(5)
    DECLARE @sum int
    DECLARE c_插入学生游标 CURSOR FOR SELECT  班级,count(*) FROM inserted GROUP BY 班级
    OPEN c_插入学生游标
    SET @i=1
    WHILE @i<=@@CURSOR_ROWS   
    BEGIN      
      FETCH NEXT FROM c_插入学生游标 into @classId,@sum
      UPDATE 班级表
        SET 学生人数=学生人数+@sum
        WHERE 班号=@classId
      set @i=@i+1
    END
    CLOSE c_插入学生游标
    DEALLOCATE c_插入学生游标
  END
END
