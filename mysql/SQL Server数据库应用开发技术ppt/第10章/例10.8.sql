--����10.8���ڴ�������ʹ��ROLLBACK�������ӡ�
CREATE TRIGGER T_student
   ON  ѧ����
   AFTER INSERT
AS 
BEGIN
    ROLLBACK   --�ع����������ִ��ǰ
    INSERT INTO ѧ����(ѧ��,����) VALUES('20070101119','������')  --ROLLBACK֮���������ִ��
END
GO
INSERT  INTO ѧ����(ѧ��,����)  VALUES('20070101116','����')

