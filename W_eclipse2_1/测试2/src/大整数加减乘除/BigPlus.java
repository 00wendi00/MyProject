/**
 * 文件名：BigPlus.java
 * 项目-包：测试2 - 大整数加减乘除
 * 作者：张文迪
 * 创建日期：2014-9-1
 */
package 大整数加减乘除;

/**
 * @author 张文迪
 * 类名：BigPlus
 * 类说明：
 */
public class BigPlus {
    public static void main(String[] args) {
//        String str1 = "371357147513143524132413214351645165134513541354134515433713571475131435241324132143516451651345135413541345154337135714751314352413241321435164516513451354135413451543371357147513143524132413214351645165134513541354134515433713571475131435241324132143516451651345135413541345154337135714751314352413241321435164516513451354135413451543";
//        String str2 = "4546894889846846846848468454689488984684684684846845468948898468468468484684546894889846846846848468454689488984684684684846845468948898468468468484684546894889846846846848468454689488984684684684846845468948898468468468484684546894889846846846848468454689488984684684684846845468948898468468468484684546894889846846846848468454689488984684684684846";
        String str1 = "123456789";
        String str2 = "987654321";
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[] a1 = toIntArray(c1);
        int[] a2 = toIntArray(c2);
        int[] a = plus(a1, a2);
        System.out.println(str1);
        System.out.println(str2);
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i]);
        }
    }
     
    public static int[] toIntArray(char[] c) {
        int[] a = new int[c.length];
        for(int i=0; i<c.length; i++) {
            a[i] = Integer.valueOf(String.valueOf(c[i]));
        }
        return a;
    }
     
    public static boolean isSingleIntArray(int[] a) {
        for(int i=0; i<a.length; i++) {
            if(a[i] > 9) {
                return false;
            }
        }
        return true;
    }
     
    public static void toSingleIntArray(int[] a) {
        while(!isSingleIntArray(a)) {
            for(int i=a.length-1; i>=1; i--) {
                if(a[i] > 9) {
                    a[i-1] += a[i]/10;
                    a[i] = a[i] % 10;
                }
            }
        }
    }
     
    public static int[] plus(int[] a1, int[] a2) {
        int [] result = new int[a1.length + a2.length + 1];
        return formatIntArray(bigPlus(result, a1, a2));
    }
     
    public static int[] bigPlus(int[] result, int[] a1, int[] a2) {
        for(int i=1; i<=a2.length; i++) {
            int flag = i;
            int temp = 0;
            for(int j=1; j<=a1.length; j++) {
                flag = i + j;
                temp = a2[a2.length-i] * a1[a1.length-j];
                result[result.length+1-flag] += temp % 10;
                result[result.length-flag] += temp / 10;
                toSingleIntArray(result);
                flag = i;
                temp = 0;
            }
        }
        return result;
    }
     
    public static int[] formatIntArray(int[] a) {
        int i=0;
        while(0 == a[i]) {
            i++;
        }
        int[] temp = new int[a.length-i];
        for(int j=i; j<a.length; j++) {
            temp[j-i] = a[j];
        }
        return temp;
    }
}
