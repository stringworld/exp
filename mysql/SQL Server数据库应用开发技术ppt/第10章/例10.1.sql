--����10.1��ʹ���α�������ʾ���ݡ�
DECLARE c_�γ��α� CURSOR FOR SELECT  �γ̺�,�γ���,ѧ�� FROM �γ̱�
OPEN c_�γ��α�
FETCH NEXT FROM c_�γ��α�
WHILE @@fetch_status = 0
   FETCH NEXT FROM c_�γ��α�
CLOSE c_�γ��α�
DEALLOCATE c_�γ��α�
