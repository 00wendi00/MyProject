/**
 *文件名:BitsTip.java
 *项目-包:数据结构与算法分析,Project1
 *作者:张文迪
 *时间:2015年4月17日
 */
package Project1;

/**
 * @author 张文迪
 * 类名:BitsTip
 * 类说明:    下面的示例程序使用 Float 的两个方法将一个浮点数转成比特，然后又将这些比特转成一个浮点数。
 *使用Float.floatToIntBits(float f) 方法可以将一个浮点数转成一个比特序列。
 *							这个方法返回一个32位整数，表示你作为参数提供的浮点数的 IEEE 754 比特排列。
 *使用Float.intBitsToFloat(int bits) 方法可以进行反方向转换。
 *							这个方法接受传入的整数作为参数，将这些比特转成一个 IEEE 浮点数。
 */
public class BitsTip {
    public static void main(String args[]) {   // 输入一个整数~~
        float f = Float.parseFloat(args[0]);
        int bits = Float.floatToIntBits(f);
        System.out.println("bits: " + bits);
        System.out.println("back to float: " + Float.intBitsToFloat(bits));
    }
}
