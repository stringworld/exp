--����9.21����ѧ���������´�����������һ����¼�����£����޸İ༶������ذ༶��������
USE ����������ݿ�
GO
CREATE TRIGGER ����ѧ��
ON  ѧ����
AFTER UPDATE
AS 
BEGIN
  SET NOCOUNT ON
IF UPDATE(�༶)    
  BEGIN
    UPDATE �༶��
      SET ѧ������=ѧ������-1
      FROM deleted 
      WHERE �༶��.���= deleted .�༶
     UPDATE �༶��
      SET ѧ������=ѧ������+1
      FROM inserted 
      WHERE �༶��.���=inserted.�༶
  END
END
