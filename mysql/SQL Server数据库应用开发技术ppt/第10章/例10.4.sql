--����10.3��ʹ���α���¡��༶�����������Ρ���������Ϊ ����������
DECLARE c_�༶�α� CURSOR FOR SELECT * FROM �༶��
OPEN c_�༶�α�
FETCH FROM c_�༶�α�
--��10.4�������α�ɾ���༶���еĵڶ������ݡ�
DECLARE c_�༶�α� CURSOR FOR SELECT  * FROM �༶��
OPEN c_�༶�α�
FETCH FROM c_�༶�α�
FETCH FROM c_�༶�α�
DELETE FROM �༶�� WHERE CURRENT OF c_�༶�α�
CLOSE c_�༶�α�
DEALLOCATE c_�༶�α�
SELECT * FROM �༶��
