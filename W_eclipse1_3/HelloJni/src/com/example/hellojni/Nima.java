/**
 *文件名:Nima.java
 *项目-包:HelloJni,com.example.hellojni
 *作者:张文迪
 *时间:2015年4月6日
 */
package com.example.hellojni;

/**
 * @author 张文迪
 * 类名:Nima
 * 类说明:
 */
public class Nima {  
	 static {  
	        System.loadLibrary("hello-jni");
	    }
	 public native   int add(int a ,int b); 
}
