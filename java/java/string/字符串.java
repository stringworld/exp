package string;

/**用到的String 方法
 * 
 * 1.equals()比较
 * 2.length()获取长度
 * 3.substring()截取字符
 * 4.Trim()去除首尾的空格
 * 5.concat()连接字符串
 * 6.charAt()获取一个字符
 * 7.getchars()获取多个字符
 * 8.replace()替换字符
 * 9.statsWith()判断字符的开头
 * 10.endsWith()判断字符的结尾
 * 11.toLowerCase()转换为小写
 * 12.toUpperCase()转换为大写
 *
 */

public class 字符串 {
	public static void main(String[] args) {
		String s1="  abc ds rjnd   fmmmt SSGFF  HFGGttj  ";
		String s2="abcd";
		if(s1.equals(s2)){//调用equals()方法比较两个字符串是否相等
			System.out.println("s1与s2相等");
		}
		else{
			System.out.println("s1与s2不相等");
		}
		
		int n=s1.length();
		System.out.println("s1的长度为："+n);
		
		String a = s1.trim();//去掉首尾的空格
		System.out.println("去除空格"+a);
		
		String b=s1.concat(s2);
		System.out.println("连接2个字符串"+b);
		
		String s=s1.substring(5);//调用substring()方法截取字符串，字符串的索引是以0开始的，所以输出是以2后面的字符开始的
		String c=s1.substring(3,8);//从第3个开始到第8个结束
		System.out.println("截取以后剩下的字符串"+s);
		System.out.println("获取中间的字符"+c);
		
		System.out.println("获取字符串："+s1.charAt(2));
		char ch[]=new char[s1.length()];
		s1.getChars(1,3,ch,0);//1表示获取的字符的开始位置，3表示结束的位置，ch表示获取后的字符要存放的位置，0表示数组的偏移量
		for (int i=0;i<3;i++) {
			System.out.println("获取多个字符"+ch[i]);
		}
		
		String e = s1.replace("fmmm","0000");//替换其中的一个字符或者一个字符串，除了字母还可以是汉字
		System.out.println(e);
		
		
		String str1="abcd";//开头
		String str2="j";//结束
		System.out.println("字符串s1是以"+s1.startsWith(str1)+"为开头的");//调用startsWith()方法判断字符串是否是以kjjjj开头
		System.out.println("字符串s1是以"+s1.endsWith(str2)+"为结尾的");//调用endsWith()方法判断字符串是否是以ijfi结尾的
	
		System.out.println("转换为小写"+s1.toLowerCase());//把字符串转换成为小写，如果是小写的则直接输出
		System.out.println("转换为大写"+s1.toUpperCase());//把字符串转换成大写
		
		
	}

}
