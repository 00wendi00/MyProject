/**
 *�ļ���:JNITest.java
 *��Ŀ-��:Haha,com.example.haha
 *����:���ĵ�
 *ʱ��:2015��4��8��
 */
package com.example.haha;

/**
 * @author ���ĵ�
 * ����:JNITest
 * ��˵��:
 */
public class JNITest {
	static{
		System.loadLibrary("Haha");
	}
	public native int add(int a,int b);
}