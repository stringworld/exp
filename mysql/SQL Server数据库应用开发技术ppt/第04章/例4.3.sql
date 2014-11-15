--¡¾Àý4.3¡¿
CREATE DATABASE  Sales
ON PRIMARY
( NAME = SPri1_dat,
    FILENAME = 'E:\SQL\SPri1dat.mdf',
    SIZE = 2,
    MAXSIZE = 10,
    FILEGROWTH = 15% ),
( NAME = SPri2_dat,
 FILENAME = 'E:\SQL\SPri2dt.ndf',
    SIZE = 2,
    MAXSIZE = 10,
    FILEGROWTH = 15% ),
FILEGROUP SalesGroup1
( NAME = SGrp1Fi1_dat,
    FILENAME = 'E:\SQL\SG1Fi1dt.ndf',
    SIZE = 2,
    MAXSIZE = 10,
    FILEGROWTH = 1 ),
( NAME = SGrp1Fi2_dat,
    FILENAME = 'E:\SQL\SG1Fi2dt.ndf',
    SIZE = 2,
MAXSIZE = 10,
    FILEGROWTH = 1 )
LOG ON
( NAME = Sales_log,
    FILENAME = 'E:\SQL\salelog.ldf',
    SIZE = 5MB,
    MAXSIZE = 25MB,
    FILEGROWTH = 5MB )
