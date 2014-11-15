--Àý4.20
ALTER DATABASE mytest
MODIFY FILE
 ( 
NAME = mytest,
FILENAME ='E:\sql\mytest.mdf'
)
	GO
ALTER DATABASE mytest
MODIFY FILE
 ( 
NAME = mytest_log,
FILENAME ='E:\sql\mytest_log.ldf'
)



