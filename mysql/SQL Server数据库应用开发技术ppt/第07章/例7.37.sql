--��7.37
  USE  ����������ݿ�
  SELECT ѧ��,����
  FROM ѧ����
  WHERE EXISTS
    (SELECT * FROM ѡ�α� 
     WHERE ѡ�α�.ѧ��=ѧ����.ѧ�� AND �γ̺�='000001')
