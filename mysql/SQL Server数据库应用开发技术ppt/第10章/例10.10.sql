 --����10.10�����������д�������ӡ�
SELECT * INTO ѧ����2  FROM ѧ����
SET XACT_ABORT OFF
BEGIN TRAN
   INSERT INTO ѧ����2(ѧ��,����) VALUES(' 20070101211 ','��ǰ��')
   SAVE TRAN POINT1
BEGIN TRY
     INSERT INTO ѧ����2(ѧ��,����) VALUES(' 20070101212','���')
               INSERT INTO ѧ����2(ѧ��,����) VALUES(' 200701012133','֣��')  
 --Υ��Լ�����׳���������TRY����
     INSERT INTO ѧ����2(ѧ��,����) VALUES(' 200701012114','������')
END TRY
BEGIN CATCH
    IF @@ERROR<>0 
ROLLBACK TRAN POINT1
END CATCH
  INSERT INTO ѧ����2(ѧ��,����) VALUES(' 20070101215','�Ž���') 
COMMIT TRANSACTION
