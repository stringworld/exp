--��7.27
  use ����������ݿ�
  select �༶, �Ա�, 
    max(datediff(year,��������,getdate())) �������,
    min(datediff(year,��������,getdate())) ��С����,
    avg(datediff(year,��������,getdate())) ƽ������,
    count(*) as ����
  from ѧ����
  group by �༶,�Ա�












