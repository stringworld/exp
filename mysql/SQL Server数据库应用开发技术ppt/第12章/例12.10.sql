--����12.10����ԭ������־����1������Ϊ��dump2���ı����豸�ĵ�һ�����ݼ�����ԭtest���ݿ���������ݣ����õڶ������ݼ�����ԭ������־���ݣ��������һ����ԭ�������������л�ԭ����������Ҫ����NORECOVERY��STANDBY������
USE master
RESTORE DATABASE test FROM dump2 WITH FILE = 1, NORECOVERY
RESTORE DATABASE test FROM dump2 WITH FILE = 2
