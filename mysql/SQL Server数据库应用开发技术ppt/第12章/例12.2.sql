--【例12.2】创建备份设备JwglData，并将“教务管理数据库”完整备份到该设备。
    EXEC sp_addumpdevice 'disk', 'JwglData', 'd:\jiaowu\backup\JwglData.bak'
BACKUP DATABASE 教务管理数据库 TO JwglData 
