--Àý4.14
ALTER DATABASE test
ADD FILEGROUP Test1FG1;
GO
ALTER DATABASE test 
ADD FILE 
(
    NAME = testdat1,
    FILENAME = 'E:\SQL\tdat1.ndf',
    SIZE = 2MB,
    FILEGROWTH =5MB
),
(
    NAME = testdat2,
    FILENAME = 'E:\SQL\tdat2.ndf',
    SIZE =2MB,
    FILEGROWTH = 5MB
)
TO FILEGROUP Test1FG1

