--����10.5����ʽ��������ӡ�
SELECT  *  INTO  �༶��1  FROM �༶��
SET xact_abort ON  
BEGIN TRANSACTION
  INSERT INTO �༶��1(���,����) values ('jy063','�����Ӧ�ð�')
  INSERT INTO �༶��1(���,����) values ('jy064','�����Ӧ�ð�')
  INSERT INTO �༶��1(���,����) values ('jr061','������������������Ӧ�ð�')
  INSERT INTO �༶��1(���,����) values ('jy065','�����Ӧ�ð�')
COMMIT TRANSACTION

