--����9.20����ѧ������ɾ��������������һ����¼������У��ͼ��ٰ༶������Ӧ�༶��������
USE ����������ݿ�
GO
CREATE TRIGGER ɾ��ѧ��
ON  ѧ����
AFTER  DELETE
AS 
BEGIN
SET NOCOUNT ON
    BEGIN   
      UPDATE �༶��
        SET ѧ������=ѧ������-1
        FROM deleted 
        WHERE �༶��.���=deleted.�༶
    END
END
