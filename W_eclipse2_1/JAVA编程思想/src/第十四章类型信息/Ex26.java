/**
 * �ļ�����Ex26.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����������Ϣ
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-20
 */
package ��ʮ����������Ϣ;

import java.util.Random;

/**
 * @author ���ĵ�
 * ������Ex26
 * ��˵����
 */
public class Ex26
{
	public static void tune(Instrument i)
	{
		i.play();
	}
	public static void tuneAll(Instrument[] e)
	{
		for(Instrument i : e)
			tune(i);
	}
	public static void main(String args[])
	{
		RandomInstrumentGenerator r = new RandomInstrumentGenerator();
		Instrument[] orchestra = new Instrument[5];
		for(int i = 0; i < orchestra.length; i++)
			orchestra[i] = r.next();
		for(Instrument i : orchestra) 
		{
			if(i instanceof Wind) // get RTTI   //����~
				((Wind)i).clearSpitValve();
		}
		tuneAll(orchestra);
	}
}
class Instrument
{
	void play() {};
}
class Percussion extends Instrument
{
	void play()
	{
		System.out.println("Percussion Play");
	}
}
class Wind extends Instrument
{
	void clearSpitValve()
	{
		System.out.println("Wind ������");
	}
	void play()
	{
		System.out.println("Wind Play");
	}
}
class Brass extends Instrument
{
	void play()
	{
		System.out.println("Brass Play");
	}
}
class RandomInstrumentGenerator
{
		private Random rand = new Random();
		public Instrument next() 
		{
			switch(rand.nextInt(3)) 
			{
				default:
				case 0: return new Wind();
				case 1: return new Percussion();				
				case 2: return new Brass();				
			}
		}
}