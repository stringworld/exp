--��7.32
  USE	 ����������ݿ�
  SELECT ����, datediff(year,��������,getdate()) ����
  FROM   ѧ����
  WHERE  �༶<>'jy072' AND datediff(year,��������,getdate())<
					(SELECT MIN(datediff(year,��������,getdate())) 
					 FROM ѧ����
					 WHERE �༶='jy072')











