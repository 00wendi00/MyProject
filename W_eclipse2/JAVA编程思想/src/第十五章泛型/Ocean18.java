/**
 * �ļ�����Ocean.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���·���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-21
 */
package ��ʮ���·���;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import net.mindview.util.Generator;

/**
 * @author ���ĵ�
 * ������Ocean
 * ��˵������ϰ18  �����������ڲ����е�ʹ��
 */
public class Ocean18
{
	public static void eat(BigFish bf,LittleFish lf)
	{
		System.out.println(bf+" eat "+lf);
	}
	public static void main(String args[])
	{
		Random random = new Random(47);
		List<BigFish> listB = new ArrayList<BigFish>();
		Generators.fill(listB, BigFish.generator(), 3);
		Queue<LittleFish> listL = new LinkedList<LittleFish>();
		Generators.fill(listL, LittleFish.generator(), 10);
		for(LittleFish l:listL)
			eat(listB.get(random.nextInt(listB.size())),l);
	}
}
class BigFish
{
	private static long counter = 1;
	private final long id = counter ++;
	private BigFish() {}
	public String toString() {return "BigFish "+id;}
	public static Generator<BigFish> generator()
	{
		return new Generator<BigFish>()
		{
			public BigFish next() {return new BigFish();}
		};	
	}
}
class LittleFish
{
	private static long counter = 1;
	private final long id = counter ++;
	private LittleFish() {}
	public String toString() {return "LittleFish "+id;}
	public static Generator<LittleFish> generator()
	{
		return new Generator<LittleFish>()
		{
			public LittleFish next() {return new LittleFish();}
		};
	}
}
