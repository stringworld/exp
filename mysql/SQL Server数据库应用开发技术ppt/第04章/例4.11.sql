--例4.11
     ALTER DATABASE 教务管理数据库
     ADD FILE 
     (
      NAME =jwgl_dat1,
      FILENAME='E:\SQL\jwgl_dat1.ndf',
      SIZE=2MB,
      FILEGROWTH=1MB
      )