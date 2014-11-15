--【例10.6】隐式事务的例子
SELECT  *  INTO  班级表2  FROM 班级表
SET xact_abort ON  
SET IMPLICIT_TRANSACTIONS ON
  INSERT INTO 班级表2(班号,班名) VALUES ('jy063','a计算机应用班')
  INSERT INTO 班级表2(班号,班名) VALUES ('jy064','a计算机应用班')
COMMIT TRANSACTION  --在隐式事务模式不要忘了事务结束语句，否则数据可能一直被加锁，不能被并发用户访问。
GO
INSERT INTO 班级表2(班号,班名) VALUES ('jy066','a计算机应用班')
INSERT INTO 班级表2(班号,班名) VALUES ('jr061','a计算机软件开发技术与应用班') 
--字符串长度越界
INSERT INTO 班级表2(班号,班名) VALUES ('jy065','a计算机应用班')
COMMIT TRANSACTION  
GO
INSERT INTO 班级表2(班号,班名) VALUES ('jy067','a计算机应用班')
INSERT INTO 班级表2(班号,班名) VALUES ('jy068','a计算机应用班')
COMMIT TRANSACTION
SET IMPLICIT_TRANSACTIONS OFF        --在完成保护数据修改所需的最后一个事务之后，应关闭隐性事务，防止启动新事务
GO
DROP table 班级表2
