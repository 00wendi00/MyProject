/**
 * 文件名：TestArrayGeneration16.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-27
 */
package 第十六章数组;

/**
 * @author 张文迪
 * 类名：TestArrayGeneration16
 * 类说明：
 */

import static net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.Arrays;

import net.mindview.util.ConvertTo;

class TestArrayGeneration16 
{
	public static void main(String[] args) 
	{
		int size = 6;
		int skip = 7;
		boolean[] a1 = ConvertTo.primitive(Generated16.array(
			new Boolean[size], new SkipGenerator16.Boolean(skip), skip));
		print("a1 = " + Arrays.toString(a1));
		byte[] a2 = ConvertTo.primitive(Generated16.array(
			new Byte[size], new SkipGenerator16.Byte(skip), skip));
		print("a2 = " + Arrays.toString(a2));
		char[] a3 = ConvertTo.primitive(Generated16.array(
			new Character[size], new SkipGenerator16.Character(skip), skip));
		print("a3 = " + Arrays.toString(a3));
		short[] a4 = ConvertTo.primitive(Generated16.array(
			new Short[size], new SkipGenerator16.Short(skip), skip));
		print("a4 = " + Arrays.toString(a4));
		int[] a5 = ConvertTo.primitive(Generated16.array(
			new Integer[size], new SkipGenerator16.Integer(skip), skip));
		print("a5 = " + Arrays.toString(a5));
		long[] a6 = ConvertTo.primitive(Generated16.array(
			new Long[size], new SkipGenerator16.Long(skip), skip));
		print("a6 = " + Arrays.toString(a6));
		float[] a7 = ConvertTo.primitive(Generated16.array(
			new Float[size], new SkipGenerator16.Float(skip), skip));
		print("a7 = " + Arrays.toString(a7));
		double[] a8 = ConvertTo.primitive(Generated16.array(
			new Double[size], new SkipGenerator16.Double(skip), skip));
		print("a8 = " + Arrays.toString(a8));
	}
}


interface SkipGenerator<T> extends net.mindview.util.Generator<T> 
{ 
	T next();	
	T next(int n); 
}

class SkipGenerator16 
{
  public static class Boolean implements SkipGenerator<java.lang.Boolean> 
  {	
    private boolean value = false;
	private int n;
	Boolean(int n) { this.n = n; }
	public java.lang.Boolean next() { return !value; }
    public java.lang.Boolean next(int n) 
    {
    	value = n % 2 == 0 ? true : false;
	return value;
    }
  }
  public static class Byte implements SkipGenerator<java.lang.Byte> 
  {
    private byte value = 0;
	private int n;
	Byte(int n) { this.n = n; }
	public java.lang.Byte next() { return value++; }
    public java.lang.Byte next(int n) { return value += n; }
  }
  static char[] chars = ("abcdefghijklmnopqrstuvwxyz" +
    "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
  public static class
  Character implements SkipGenerator<java.lang.Character> {
    int index = -1;
	private int n;
	Character() { int index = -1; }
	Character(int n) { this.n = n; }
	public java.lang.Character next() 
	{
      index = (index + 1) % chars.length;
      return chars[index];
    }
    public java.lang.Character next(int n) 
    {
      index = (index + 1 + n) % chars.length;
      return chars[index];
    }
  }
  public static class
  String implements SkipGenerator<java.lang.String> 
  {
    private int length = 7;
    SkipGenerator<java.lang.Character> cg = new Character();
    public String() {}
    public String(int length) { this.length = length; }
    public java.lang.String next() 
    {
      char[] buf = new char[length];
      for(int i = 0; i < length; i++)
        buf[i] = cg.next();
      return new java.lang.String(buf);
    }
	public java.lang.String next(int n) 
	{
		char[] buf = new char[length];
		for(int i = 0; i < length; i++)
			buf[i] = cg.next(n);
		return new java.lang.String(buf);
	}
  }
  public static class Short implements SkipGenerator<java.lang.Short> 
  {
    private short value = 0;
	private int n;
	Short(int n) { this.n = n; }
	public java.lang.Short next() { return value++; }
    public java.lang.Short next(int n) { return value += n; }
  }
  public static class Integer implements SkipGenerator<java.lang.Integer> 
  {
    private int value = 0;
	private int n;
	Integer(int n) { this.n = n; }
	public java.lang.Integer next() { return value++; }
    public java.lang.Integer next(int n) { return value += n; }
  }
  public static class
  Long implements SkipGenerator<java.lang.Long> 
  {
    private long value = 0;
	private int n;
	Long(int n) { this.n = n; }
	public java.lang.Long next() { return value++; }
    public java.lang.Long next(int n) { return value += n; }
  }
  public static class
  Float implements SkipGenerator<java.lang.Float> 
  {
    private float value = 0;
	private int n;
	Float(int n) { this.n = n; }
	public java.lang.Float next() 
	{
	    float result = value;
      	value += 1.0;
      	return result;
	}
    public java.lang.Float next(int n) 
    {
    	float result = value;
    	value += (1.0 * n);
    	return result;
    }
  }
  public static class Double implements SkipGenerator<java.lang.Double> 
  {
    private double value = 0.0;
	private int n;
	Double(int n)  { this.n = n; }
	public java.lang.Double next() 
	{
		double result = value;
      	value += 1.0;
      	return result;
    }
    public java.lang.Double next(int n) 
    {
    	double result = value;
    	value += (1.0 * n);
    	return result;
    }
  }
} 



public class Generated16 
{
  // Fill an existing array:
   public static <T> T[] array(T[] a, SkipGenerator<T> gen, int skip) 
   {
	   return new CollectionData16<T>(gen, skip, a.length).toArray(a);
   }
} 

class CollectionData16<T> extends ArrayList<T> 
{
  public CollectionData16(SkipGenerator<T> gen, int skip, int quantity) 
  {
      for(int i = 0; i < quantity; i++)
      add(gen.next(skip));
  }
} 
