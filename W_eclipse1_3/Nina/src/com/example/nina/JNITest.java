/**
 *�ļ���:JNITest.java
 *��Ŀ-��:Haha,com.example.haha
 *����:���ĵ�
 *ʱ��:2015��4��8��
 */
package com.example.nina;

/**
 * @author ���ĵ�
 * ����:JNITest
 * ��˵��:
 */
public class JNITest {
	static{
		System.loadLibrary("AndroidNDK");
	}
	public native int add(int a,int b);
}