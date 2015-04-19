/**
 *文件名:Test1_1.java
 *项目-包:数据结构于算法分析,Project1
 *作者:张文迪
 *时间:2015年3月31日
 */
package Project1;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 张文迪
 * 类名:Test1_1
 * 类说明:随机产生n个数(n<100000),前面一半的数冒泡排序<<<,
 * 			后面一半的数,一个一个和前面一半的数比较然后插入其中(两个for循环实现)
 * 			返回最大的数输出所用的时间. 	
 * 			以上10遍.
 */
public class Test1_1 {
       public static final Random RANDOM = new Random(47);        //假设N = 10    
       public static void main(String[] args) {       
    	   for (int i = 0; i < 10; i++) {            
    		   printResult(createArray(RANDOM.nextInt(100000)));       
    		   }   
    	   }        
       //冒泡排序    
       public static void sort(int[] values){       
    	   for (int i = 1; i < values.length; i++) {            
    		   for (int j = 0; j < values.length - i; j++) {               
    			   if (values[j] > values[j + 1]) {                   //  < < <  小到大
    				   int temp = values[j];                    
    				   values[j] = values[j + 1];                    
    				   values[j + 1] = temp;               
    				   }           
    			   }        
    		   }    
    	   }   
       //分批处理    
       public static int select(int[] values){       
    	   if (values == null || values.length == 0) {          
    		   throw new NullPointerException("values can't be null.");        
    		   }       
    	   int k = values.length / 2;        
    	   int[] temp = Arrays.copyOf(values, k);        //这个好方法  copy数组
    	   sort(temp);       
    	   for (int i = k ; i < values.length; i++) {           
    		   if (values[i] < temp[k - 1]) {               
    			   temp[k - 1] = temp[k - 2];                
    			   for (int j = k - 2; j >0; j--) {                    
    				   if (values[i] > temp[j]) {                        
    					   temp[j + 1] = values[i];                        
    					   break;                    
    				   }else 
    					   {                       
    						   temp[j] = temp[j - 1];                   
    					   }               
    				   }            
    			   }        
    		   }        
    	   return temp[k - 1];   
    	   }    
       //创建随即数组    
       public static int[] createArray(int length){       
    	   int[] values = new int[length];        
    	   for (int i = 0; i < length; i++) {           
    		   values[i] = RANDOM.nextInt(length * 2);       
    		   }       
    	   return values;    
    	   }    
       //打印结果    
       public static void printResult(int[] values){       
    	   System.out.println("length:" + values.length);       
    	   long start = System.currentTimeMillis();        
    	   System.out.println("result:" + select(values));       
    	   System.out.println("cost:" + (System.currentTimeMillis() - start) + "ms");       
    	   System.out.println("--------------------------------");   
    	   }  
       
}
