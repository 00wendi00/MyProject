/**
 * �ļ�����TupleTest15.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���·���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-21
 */
package ��ʮ���·���;

/**
 * @author ���ĵ�
 * ������TupleTest15
 * ��˵����
 */
import static net.mindview.util.Tuple.tuple;
import net.mindview.util.FiveTuple;
import net.mindview.util.FourTuple;
import net.mindview.util.ThreeTuple;
import net.mindview.util.TwoTuple;

public class TupleTest15 
{
	static TwoTuple<String,Integer> f() 
	{
		return tuple("hi", 47);
	}
	static TwoTuple f2() { return tuple("hi", 47); }//�������������棬���ص���   ��  �������Ķ���.
	static ThreeTuple<Amphibian,String,Integer> g() 
	{
		return tuple(new Amphibian(), "hi", 47);
	}
	static FourTuple<Vehicle,Amphibian,String,Integer> h() 
	{
		return tuple(new Vehicle(), new Amphibian(), "hi", 47);
	}
	static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k() 
	{
		return tuple(new Vehicle(), new Amphibian(), "hi", 47,
		11.1);
	}
	public static void main(String[] args) 
	{
		TwoTuple<String,Integer> ttsi = f();
		// compiler warning: unchecked conversion:
		TwoTuple<String,Integer> ttsi2 = f2();
		System.out.println(ttsi);
		System.out.println(f2());
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
	}
}