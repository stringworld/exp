--����9.9���޸ġ�ĳרҵ��Ů����������������ֵ��С��λ����Ϊ1λ��
USE ����������ݿ�
GO
ALTER FUNCTION  ĳרҵ��Ů����
(	
	@רҵ�� char(6) 
)
RETURNS  numeric(5,1)
AS
BEGIN
	 DECLARE @man int
    DECLARE @woman int
    --ͳ�ư༶��������
    SELECT @man=count(*)
    FROM ѧ����,רҵ��,�༶��
    WHERE ѧ����.�༶= �༶��.��� AND �༶��.רҵ= רҵ��.רҵ�� AND �Ա�='��'  AND רҵ��=@רҵ��
	--ͳ�ư༶Ů������
    SELECT @woman=count(*)
    FROM ѧ����, רҵ��, �༶��
    WHERE ѧ����.�༶= �༶��.��� AND �༶��.רҵ= רҵ��.רҵ�� AND �Ա�='Ů' AND רҵ��=@רҵ��
	RETURN   cast(@man as float)/cast(@woman as float)
END


