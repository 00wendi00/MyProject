/**
 *�ļ���:Nima.java
 *��Ŀ-��:HelloJni,com.example.hellojni
 *����:���ĵ�
 *ʱ��:2015��4��6��
 */
package com.example.hellojni;

/**
 * @author ���ĵ�
 * ����:Nima
 * ��˵��:
 */
public class Nima {  
	 static {  
	        System.loadLibrary("hello-jni");
	    }
	 public native   int add(int a ,int b); 
}