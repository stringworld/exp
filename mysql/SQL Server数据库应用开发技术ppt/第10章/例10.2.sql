--����10.2������������������ѧ�������Ա�֤����ѧ��������¼ʱ���༶���е�ѧ��������Ӧ��ȷ���¡�

CREATE TRIGGER ����ѧ��
   ON  ѧ����
   AFTER  INSERT
AS 
BEGIN
  SET NOCOUNT ON
  IF UPDATE(�༶)
  BEGIN   
    --�����˶���ѧ����¼
    DECLARE @i int
    DECLARE @classId char(5)
    DECLARE @sum int
    DECLARE c_����ѧ���α� CURSOR FOR SELECT  �༶,count(*) FROM inserted GROUP BY �༶
    OPEN c_����ѧ���α�
    SET @i=1
    WHILE @i<=@@CURSOR_ROWS   
    BEGIN      
      FETCH NEXT FROM c_����ѧ���α� into @classId,@sum
      UPDATE �༶��
        SET ѧ������=ѧ������+@sum
        WHERE ���=@classId
      set @i=@i+1
    END
    CLOSE c_����ѧ���α�
    DEALLOCATE c_����ѧ���α�
  END
END
