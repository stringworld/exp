CREATE TABLE dbo.ѧ����(
ѧ�� char(11) NULL,
���� nchar(5) NULL,
�Ա� nchar(1)  CHECK(�Ա�='��' OR �Ա�='Ů')  ,
�������� datetime NULL,
������ò varchar(10), 
��ѧʱ�� datetime NULL,
��ϵ�绰 char(20)  CHECK (��ϵ�绰 LIKE '[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
�༶ char(5)  NULL,
��ע varchar(200)  NULL
)
