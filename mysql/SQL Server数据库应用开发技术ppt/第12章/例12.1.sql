--【例12.1】 添加一个名为 dump1 的磁盘备份设备，其物理位置为 d:\backup\dump1.bak。
EXEC sp_addumpdevice 'disk', 'dump1', ' d:\backup\dump1.bak'
