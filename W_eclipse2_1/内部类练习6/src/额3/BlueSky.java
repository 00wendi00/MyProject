/**
 * �ļ�����BlueSky.java
 * ��Ŀ-�����ڲ�����ϰ6 - ��3
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-25
 */
package ��3;

import ��1.World;
import ��2.Sky;

/**
 * @author ���ĵ�
 * ������BlueSky
 * ��˵����
 */
public class BlueSky extends Sky
{	
	public World haha111()
	{
		return this.new ColorSky();
	}
	public static void main(String args[])
	{
		BlueSky b = new BlueSky();
		World world = b.haha111();
		world.haha();
	}
}
