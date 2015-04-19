/**
 *文件名:Test1_2.java
 *项目-包:数据结构于算法分析,Project1
 *作者:张文迪
 *时间:2015年4月1日
 */
package Project1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张文迪
 * 类名:Test1_2
 * 类说明:控制台输入一个上限,输出其下的所有素数. 并且输出尾数是1,3,7,9的数的 个数以及百分比,
 *         	注意double 和 long 的精度$$$$$$$$
 *         	这个上限到了 百万 就很 卡了
 */
public class Test1_2 {
	static int m  ;
	static int  q1 = 0;
	static int q3 = 0;
	static int q7 = 0;
	static int q9 = 0;
	static int qQita = 0;
	public static void main(String args[]){
		m = Integer.parseInt(args[0]);  //入口函数  配置 args[].
		List<Integer> nums = new ArrayList<Integer>();
		outer:
		for(int i = 2;i<m;i++){
			for(int j =2 ;j<= Math.sqrt(i);j++){
				if( i !=2 && i%j ==0){
					continue outer;
				}
			}
			nums.add(i);
		}
		System.out.println(nums);
		 
		for(int i = 0;i<nums.size();i++){
			if(nums.get(i)%10==1){
				q1++;
			}else if (nums.get(i)%10==3) {
				q3 ++;
			}else if (nums.get(i)%10==7) {
				q7++;
			}else if (nums.get(i)%10==9) {
				q9++;
			}else {
				qQita++;
			}
		}
		System.out.println(nums.size()+"~~~~"+((double)nums.size()/m));
		System.out.println("尾数为1的个数:"+q1+"~~~"+((double)q1)/nums.size());
		System.out.println("尾数为3的个数:"+q3+"~~~"+((double)q3)/nums.size());
		System.out.println("尾数为7的个数:"+q7+"~~~"+((double)q7)/nums.size());
		System.out.println("尾数为9的个数:"+q9+"~~~"+((double)q9)/nums.size());
		System.out.println("尾数为其他的个数:"+qQita+"~~~"+((double)qQita)/nums.size());
	}
}
