--����10.9����������ʹ�ñ��������ӡ�
BEGIN TRANSACTION
   INSERT INTO ѧ����(ѧ��,����) VALUES('20070101116','����')
   SAVE TRANSACTION point1   
   INSERT INTO ѧ����(ѧ��,����) VALUES ('20070101117','����')
   ROLLBACK TRANSACTION point1   --ȡ����point1֮��Ĳ���
   INSERT INTO ѧ����(ѧ��,����) VALUES ('20070101118','����')
COMMIT
