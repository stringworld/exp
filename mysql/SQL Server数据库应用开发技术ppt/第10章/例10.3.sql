--����10.3��ʹ���α���¡��༶�����������Ρ���������Ϊ ����������
DECLARE c_�༶�α� CURSOR FOR SELECT * FROM �༶��
OPEN c_�༶�α�
FETCH FROM c_�༶�α�
FETCH FROM c_�༶�α�
UPDATE �༶��  SET ������='����'  WHERE CURRENT OF c_�༶�α�
CLOSE c_�༶�α�
DEALLOCATE c_�༶�α�
SELECT * FROM �༶��
