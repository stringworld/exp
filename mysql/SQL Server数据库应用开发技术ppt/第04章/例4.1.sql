--【例4.1】 创建“教务管理数据库”。
       CREATE DATABASE 教务管理数据库
       ON 
       (NAME = 教务管理_dat, 
       FILENAME ='E:\SQL\教务管理dat.mdf',
       SIZE =2, 
       FILEGROWTH =1)
       LOG ON 
       (NAME = 教务管理_log,
       FILENAME ='E:\SQL\教务管理log.ldf', 
       SIZE = 5MB,
       FILEGROWTH =10%)