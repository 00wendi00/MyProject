/**
 * 文件名：Ex28.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-9
 */
package 第十一章.持有对象;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author 张文迪
 * 类名：Ex28
 * 类说明：
 */
public class Ex28
{
    public static void main(String args[])
    {
    	PriorityQueue<Double> queue = new PriorityQueue<Double>();
    	Random random = new Random(47);
    	for(int i = 0;i<10;i++)  	
    		queue.offer(random.nextDouble()*10);
    	while(queue.peek() != null)
    		System.out.println(queue.poll()+" ");	//remove()  ~~~~~~
    	System.out.println();
    }
}
