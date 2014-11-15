--【例10.3】使用游标更新“班级表”，将班主任“马力”改为 “马利”。
DECLARE c_班级游标 CURSOR FOR SELECT * FROM 班级表
OPEN c_班级游标
FETCH FROM c_班级游标
--【10.4】利用游标删除班级表中的第二行数据。
DECLARE c_班级游标 CURSOR FOR SELECT  * FROM 班级表
OPEN c_班级游标
FETCH FROM c_班级游标
FETCH FROM c_班级游标
DELETE FROM 班级表 WHERE CURRENT OF c_班级游标
CLOSE c_班级游标
DEALLOCATE c_班级游标
SELECT * FROM 班级表
