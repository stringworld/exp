--��7.38
  USE  ����������ݿ�
  SELECT ѧ��,����
  FROM ѧ����
  WHERE NOT EXISTS
    (SELECT * FROM ѡ�α� WHERE ѡ�α�.ѧ��=ѧ����.ѧ��)
