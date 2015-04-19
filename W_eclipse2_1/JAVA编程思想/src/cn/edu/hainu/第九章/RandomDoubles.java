/**
 * 文件名：RandomDoubles.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第九章
 * 作者：张文迪
 * 创建日期：2014-9-24
 */
package cn.edu.hainu.第九章;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 张文迪
 * 类名：RandomDoubles
 * 类说明： append将指定字符添加到此缓冲区
 */
public class RandomDoubles
{
    private static Random rand = new Random(47);
    public double next()
    {
    	return rand.nextDouble();
    }
    public static void main(String args[])
    {
    	RandomDoubles rd = new RandomDoubles();
    	for(int i = 0; i<10;i++)
    		System.out.println(rd.next());
    	System.out.println();
    	
    	
    	float[] all = new float[10];//保存10个求出来的数据
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            double d = random.nextDouble() * 10000 * 1000;//保证在0-10000范围内
            float x = ((int) d) / 1000f;//为了去掉3位小数后面的值,所以先放大1000再缩小1000
            all[i] = x;//存入数组
            System.out.println(x + "\t 平方根：" + Math.sqrt(x));//显示所获得的数并示平方根
        }
        Arrays.sort(all);//对所有数据排序
        System.out.println("最小值：" + all[0]);//显示最小值
        System.out.println("最大值：" + all[9]);//显示最大值
    }
}
