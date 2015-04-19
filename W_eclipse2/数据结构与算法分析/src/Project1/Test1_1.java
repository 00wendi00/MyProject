/**
 *�ļ���:Test1_1.java
 *��Ŀ-��:���ݽṹ���㷨����,Project1
 *����:���ĵ�
 *ʱ��:2015��3��31��
 */
package Project1;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ���ĵ�
 * ����:Test1_1
 * ��˵��:�������n����(n<100000),ǰ��һ�����ð������<<<,
 * 			����һ�����,һ��һ����ǰ��һ������Ƚ�Ȼ���������(����forѭ��ʵ��)
 * 			����������������õ�ʱ��. 	
 * 			����10��.
 */
public class Test1_1 {
       public static final Random RANDOM = new Random(47);        //����N = 10    
       public static void main(String[] args) {       
    	   for (int i = 0; i < 10; i++) {            
    		   printResult(createArray(RANDOM.nextInt(100000)));       
    		   }   
    	   }        
       //ð������    
       public static void sort(int[] values){       
    	   for (int i = 1; i < values.length; i++) {            
    		   for (int j = 0; j < values.length - i; j++) {               
    			   if (values[j] > values[j + 1]) {                   //  < < <  С����
    				   int temp = values[j];                    
    				   values[j] = values[j + 1];                    
    				   values[j + 1] = temp;               
    				   }           
    			   }        
    		   }    
    	   }   
       //��������    
       public static int select(int[] values){       
    	   if (values == null || values.length == 0) {          
    		   throw new NullPointerException("values can't be null.");        
    		   }       
    	   int k = values.length / 2;        
    	   int[] temp = Arrays.copyOf(values, k);        //����÷���  copy����
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
       //�����漴����    
       public static int[] createArray(int length){       
    	   int[] values = new int[length];        
    	   for (int i = 0; i < length; i++) {           
    		   values[i] = RANDOM.nextInt(length * 2);       
    		   }       
    	   return values;    
    	   }    
       //��ӡ���    
       public static void printResult(int[] values){       
    	   System.out.println("length:" + values.length);       
    	   long start = System.currentTimeMillis();        
    	   System.out.println("result:" + select(values));       
    	   System.out.println("cost:" + (System.currentTimeMillis() - start) + "ms");       
    	   System.out.println("--------------------------------");   
    	   }  
       
}
