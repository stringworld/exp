--【例12.11】还原事务日志备份2。使用RESTORE LOG语句也可以用来还原事务日志备份，【例12.9】可以改为以下代码实现：
	RESTORE DATABASE test FROM dump2 WITH FILE = 1, NORECOVERY
	RESTORE LOG test FROM dump2 WITH FILE =2
