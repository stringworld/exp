--【例10.1】使用游标逐行显示数据。
DECLARE c_课程游标 CURSOR FOR SELECT  课程号,课程名,学分 FROM 课程表
OPEN c_课程游标
FETCH NEXT FROM c_课程游标
WHILE @@fetch_status = 0
   FETCH NEXT FROM c_课程游标
CLOSE c_课程游标
DEALLOCATE c_课程游标
