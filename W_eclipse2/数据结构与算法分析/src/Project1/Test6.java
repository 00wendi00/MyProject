/**
 *文件名:Test6.java
 *项目-包:数据结构与算法分析,Project1
 *作者:张文迪
 *时间:2015年4月5日
 */
package Project1;

/**
 * @author 张文迪
 * 类名:Test6
 * 类说明:   这个递归怎么用~~?????????????????????????
 */
public class Test6 {
	public static void main(String args[]){
		permute("abc");
	}
	public static void permute(String str){
		char[] strChar = new char[str.length()];
		for(int i = 0 ;i<str.length();i++){
			strChar[i]  = str.charAt(i);
		}
		permute(strChar,0,6);
	}
	public static  void permute(char[] str,int low,int high){
		if (low>=high) {
			return;
		}
		System.out.println(str[low]+""+str[high]+""+str[high-1]);
		permute(str,low+1,high-1);
	}
}
