--【例10.7】自动提交事务。
SELECT * INTO 班级表2 FROM 班级表
INSERT INTO 班级表2(班号,班名) values ('jy063','a计算机应用班')
INSERT INTO 班级表2(班号,班名) values ('jy064','a计算机应用班')
INSERT INTO 班级表2(班号,班名) values ('jr061','a计算机软件开发技术与应用班')
INSERT INTO 班级表2(班号,班名) values ('jy065','a计算机应用班')
SELECT * INTO 班级表2

