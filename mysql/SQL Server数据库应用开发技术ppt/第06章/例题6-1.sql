--�������ͬʱ����
CREATE TABLE dbo.ѧ����(
	ѧ�� char(11) NOT NULL,--������Ϊ��
	���� nchar(5) NOT NULL, --������Ϊ��
	�Ա� nchar(1) NOT NULL, --������Ϊ��
	�������� datetime NULL,
	������ò varchar(10), 
	��ѧʱ�� datetime NOT NULL, --������Ϊ��
	��ϵ�绰 char(20)  NULL,
	�༶ char(5)  NULL,
	��ע varchar(200)  NULL
)
--�޸ı�����
ALTER TABLE ѧ����
ALTER COLUMN ѧ�� CHAR(11) NOT NULL
ALTER TABLE ѧ����
ALTER COLUMN ���� NCHAR(5) NOT NULL
ALTER TABLE ѧ����
ALTER COLUMN �Ա� NCHAR(1) NOT NULL
ALTER TABLE ѧ����
ALTER COLUMN ��ѧʱ�� DATETIME NOT NULL
--ִ�����в������ݽ�����֤Ч����
INSERT INTOѧ����(ѧ��,����) VALUES ('20070101110','����')
