--【例10.8】在触发器中使用ROLLBACK语句的例子。
CREATE TRIGGER T_student
   ON  学生表
   AFTER INSERT
AS 
BEGIN
    ROLLBACK   --回滚至激发语句执行前
    INSERT INTO 学生表(学号,姓名) VALUES('20070101119','孙晓明')  --ROLLBACK之后的语句继续执行
END
GO
INSERT  INTO 学生表(学号,姓名)  VALUES('20070101116','张三')

