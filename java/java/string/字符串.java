package string;

/**�õ���String ����
 * 
 * 1.equals()�Ƚ�
 * 2.length()��ȡ����
 * 3.substring()��ȡ�ַ�
 * 4.Trim()ȥ����β�Ŀո�
 * 5.concat()�����ַ���
 * 6.charAt()��ȡһ���ַ�
 * 7.getchars()��ȡ����ַ�
 * 8.replace()�滻�ַ�
 * 9.statsWith()�ж��ַ��Ŀ�ͷ
 * 10.endsWith()�ж��ַ��Ľ�β
 * 11.toLowerCase()ת��ΪСд
 * 12.toUpperCase()ת��Ϊ��д
 *
 */

public class �ַ��� {
	public static void main(String[] args) {
		String s1="  abc ds rjnd   fmmmt SSGFF  HFGGttj  ";
		String s2="abcd";
		if(s1.equals(s2)){//����equals()�����Ƚ������ַ����Ƿ����
			System.out.println("s1��s2���");
		}
		else{
			System.out.println("s1��s2�����");
		}
		
		int n=s1.length();
		System.out.println("s1�ĳ���Ϊ��"+n);
		
		String a = s1.trim();//ȥ����β�Ŀո�
		System.out.println("ȥ���ո�"+a);
		
		String b=s1.concat(s2);
		System.out.println("����2���ַ���"+b);
		
		String s=s1.substring(5);//����substring()������ȡ�ַ������ַ�������������0��ʼ�ģ������������2������ַ���ʼ��
		String c=s1.substring(3,8);//�ӵ�3����ʼ����8������
		System.out.println("��ȡ�Ժ�ʣ�µ��ַ���"+s);
		System.out.println("��ȡ�м���ַ�"+c);
		
		System.out.println("��ȡ�ַ�����"+s1.charAt(2));
		char ch[]=new char[s1.length()];
		s1.getChars(1,3,ch,0);//1��ʾ��ȡ���ַ��Ŀ�ʼλ�ã�3��ʾ������λ�ã�ch��ʾ��ȡ����ַ�Ҫ��ŵ�λ�ã�0��ʾ�����ƫ����
		for (int i=0;i<3;i++) {
			System.out.println("��ȡ����ַ�"+ch[i]);
		}
		
		String e = s1.replace("fmmm","0000");//�滻���е�һ���ַ�����һ���ַ�����������ĸ�������Ǻ���
		System.out.println(e);
		
		
		String str1="abcd";//��ͷ
		String str2="j";//����
		System.out.println("�ַ���s1����"+s1.startsWith(str1)+"Ϊ��ͷ��");//����startsWith()�����ж��ַ����Ƿ�����kjjjj��ͷ
		System.out.println("�ַ���s1����"+s1.endsWith(str2)+"Ϊ��β��");//����endsWith()�����ж��ַ����Ƿ�����ijfi��β��
	
		System.out.println("ת��ΪСд"+s1.toLowerCase());//���ַ���ת����ΪСд�������Сд����ֱ�����
		System.out.println("ת��Ϊ��д"+s1.toUpperCase());//���ַ���ת���ɴ�д
		
		
	}

}
