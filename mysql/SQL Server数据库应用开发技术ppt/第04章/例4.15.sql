--Àý4.15
ALTER DATABASE test 
ADD LOG FILE 
(
    NAME = testlog1,
    FILENAME = 'E:\SQL\tlog1.ldf',
    SIZE = 5MB,
    MAXSIZE = 100MB,
    FILEGROWTH = 5MB
),
(
    NAME = testlog2,
    FILENAME = 'E:\SQL\tlog2.ldf',
    SIZE = 5MB,
    MAXSIZE = 100MB,
    FILEGROWTH = 5MB
)
