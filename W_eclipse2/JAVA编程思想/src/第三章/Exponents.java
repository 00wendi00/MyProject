/**
 * 文件名：Exponents.java
 * 项目-包：JAVA编程思想 - 第三章
 * 作者：张文迪
 * 创建日期：2014-9-3
 */
package 第三章;

/**
 * @author 张文迪
 * 类名：Exponents
 * 类说明：float与double的区别

单精度浮点数在机内占4个字节，用32位二进制描述。 
双精度浮点数在机内占8个字节，用64位二进制描述。 

浮点数在机内用指数型式表示，分解为：数符，尾数，指数符，指数四部分。 
数符占1位二进制，表示数的正负。 
指数符占1位二进制，表示指数的正负。 
尾数表示浮点数有效数字，0.xxxxxxx,但不存开头的0和点 
指数存指数的有效数字。 

指数占多少位，尾数占多少位，由计算机系统决定。 
可能是数符加尾数占24位，指数符加指数占8位 -- float. 
数符加尾数占48位，指数符加指数占16位 -- double. 

知道了这四部分的占位，按二进制估计大小范围，再换算为十进制，就是你想知道的数值范围。 

对编程人员来说，double 和 float 的区别是double精度高，有效数字16位，float精度7位。但double消耗内存是float的两倍，
double的运算速度比float慢得多，java语言中数学函数名称double 和 float不同，不要写错，
能用单精度时不要用双精度（以省内存，加快运算速度）
 */
public class Exponents
{
    public static void main(String args[])
    {
    	float expFloat = 1.39e-43f;
    	expFloat = 1.39e-43f;
    	System.out.println(expFloat);
    	double expDouble = 47e47d;
    	double expDouble2 = 47e47;
    	System.out.println(expDouble);
    	System.out.println(expDouble2);
    	   	
    	float fmax = Float.MAX_VALUE;
    	float fmin = Float.MIN_VALUE;
    	double dmax = Double.MAX_VALUE;
    	double dmin = Double.MIN_VALUE;

    	System.out.println(fmax);
    	System.out.println(fmin);

    	System.out.println(dmax);
    	System.out.println(dmin);
    	
    	
    	
    	
    }
}
