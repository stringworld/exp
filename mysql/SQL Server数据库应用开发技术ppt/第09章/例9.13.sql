--����9.13����������ѯѧ�����洢���̣��书���Ǹ���ѧ�Ų�ѯѧ�������������䡣
USE ����������ݿ�
GO
CREATE PROCEDURE ��ѯѧ��3
	@ѧ�� char(11), @���� nchar(5) OUTPUT,@���� int OUTPUT
AS
BEGIN
	SELECT @����=����,@����=DATEDIFF(year,��������,getdate())
      FROM ѧ����
      WHERE ѧ��=@ѧ��
END
