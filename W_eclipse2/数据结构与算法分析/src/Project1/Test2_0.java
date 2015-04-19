/**
 *文件名:Test2_0.java
 *项目-包:数据结构与算法分析,Project1
 *作者:张文迪
 *时间:2015年4月5日
 */
package Project1;

/**
 * @author 张文迪
 * 类名:Test2_0
 * 类说明:		输出    ASCII码     ,0~27为控制字符
 * 							32～126(共95个)是字符(32是空格），其中48～57为0到9十个阿拉伯数字。
								65～90为26个大写英文字母，97～122号为26个小写英文字母，其余为一些标点符号、运算符号等
 */
public class Test2_0
{
	public static void main(String args[])
	{
		for(int i = 0 ;i <10;i++){
			System.out.print(i+"	    ");
		}
		System.out.println();
		for(int i = 0;i<255;i++){
			System.out.print((char)i+"	  ");
			if((i+1)%10==0)
				System.out.println("");
		}
	}
}
