--����9.19����ѧ���������봥����������һ���µļ�¼������У��͸��°༶������Ӧ�༶��������
USE ����������ݿ�
GO
CREATE TRIGGER ����ѧ��
   ON  ѧ����
   AFTER  INSERT
AS 
BEGIN
SET NOCOUNT ON
IF UPDATE(�༶)
    BEGIN   
      UPDATE �༶��
        SET ѧ������=ѧ������+1
        FROM inserted 
        WHERE �༶��.���=inserted.�༶
     END
END
