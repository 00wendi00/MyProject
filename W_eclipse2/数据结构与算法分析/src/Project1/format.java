/**
 *文件名:format.java
 *项目-包:数据结构与算法分析,Project1
 *作者:张文迪
 *时间:2015年4月17日
 */
package Project1;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author 张文迪
 * 类名:format
 * 类说明:  保留两位小数的4种方法~~
 */
public class format {
    double f = 111231.5585;
    public void m1() {
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }
    /**
     * DecimalFormat转换最简便
     */
    public void m2() {
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(f));
    }
    /**
     * String.format打印最简便
     */
    public void m3() {
        System.out.println(String.format("%.2f", f));
    }
    public void m4() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(f));
    }
    public static void main(String[] args) {
        format f = new format();
        f.m1();
        f.m2();
        f.m3();
        f.m4();
    }
}
