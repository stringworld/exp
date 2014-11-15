--【例10.5】显式事务的例子。
SELECT  *  INTO  班级表1  FROM 班级表
SET xact_abort ON  
BEGIN TRANSACTION
  INSERT INTO 班级表1(班号,班名) values ('jy063','计算机应用班')
  INSERT INTO 班级表1(班号,班名) values ('jy064','计算机应用班')
  INSERT INTO 班级表1(班号,班名) values ('jr061','计算机软件开发技术与应用班')
  INSERT INTO 班级表1(班号,班名) values ('jy065','计算机应用班')
COMMIT TRANSACTION

