--【例10.9】在事务中使用保存点的例子。
BEGIN TRANSACTION
   INSERT INTO 学生表(学号,姓名) VALUES('20070101116','张三')
   SAVE TRANSACTION point1   
   INSERT INTO 学生表(学号,姓名) VALUES ('20070101117','李四')
   ROLLBACK TRANSACTION point1   --取消到point1之间的操作
   INSERT INTO 学生表(学号,姓名) VALUES ('20070101118','王五')
COMMIT
