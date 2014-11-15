--【例12.10】还原事务日志备份1。用名为“dump2”的备份设备的第一个备份集来还原test数据库的完整备份，再用第二个备份集来还原事务日志备份，除了最后一个还原操作，其他所有还原操作都必须要加上NORECOVERY或STANDBY参数。
USE master
RESTORE DATABASE test FROM dump2 WITH FILE = 1, NORECOVERY
RESTORE DATABASE test FROM dump2 WITH FILE = 2
