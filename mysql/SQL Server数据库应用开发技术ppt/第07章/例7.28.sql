--��7.28
  USE    ����������ݿ�
  SELECT �༶, ѡ�α�.ѧ��,����,AVG(�ɼ�) AS ����
  FROM   ѡ�α�,ѧ����
  WHERE  ѡ�α�.ѧ��=ѧ����.ѧ��
  GROUP BY �༶,ѡ�α�.ѧ��, ����
  HAVING AVG(�ɼ�) > 60 
  ORDER BY AVG(�ɼ�) DESC











