--����10.6����ʽ���������
SELECT  *  INTO  �༶��2  FROM �༶��
SET xact_abort ON  
SET IMPLICIT_TRANSACTIONS ON
  INSERT INTO �༶��2(���,����) VALUES ('jy063','a�����Ӧ�ð�')
  INSERT INTO �༶��2(���,����) VALUES ('jy064','a�����Ӧ�ð�')
COMMIT TRANSACTION  --����ʽ����ģʽ��Ҫ�������������䣬�������ݿ���һֱ�����������ܱ������û����ʡ�
GO
INSERT INTO �༶��2(���,����) VALUES ('jy066','a�����Ӧ�ð�')
INSERT INTO �༶��2(���,����) VALUES ('jr061','a������������������Ӧ�ð�') 
--�ַ�������Խ��
INSERT INTO �༶��2(���,����) VALUES ('jy065','a�����Ӧ�ð�')
COMMIT TRANSACTION  
GO
INSERT INTO �༶��2(���,����) VALUES ('jy067','a�����Ӧ�ð�')
INSERT INTO �༶��2(���,����) VALUES ('jy068','a�����Ӧ�ð�')
COMMIT TRANSACTION
SET IMPLICIT_TRANSACTIONS OFF        --����ɱ��������޸���������һ������֮��Ӧ�ر��������񣬷�ֹ����������
GO
DROP table �༶��2
