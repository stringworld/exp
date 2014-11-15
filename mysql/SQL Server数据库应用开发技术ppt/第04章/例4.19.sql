--Àý4.19
ALTER DATABASE mytest
MODIFY FILE
 ( 
NAME = test,
NEWNAME = mytest
)
	GO
ALTER DATABASE mytest
MODIFY FILE
 ( 
NAME = test_log,
NEWNAME = mytest_log
)


