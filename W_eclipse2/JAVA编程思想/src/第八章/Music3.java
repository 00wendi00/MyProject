/**
 * 文件名：Music3.java
 * 项目-包：JAVA编程思想 - 第八章
 * 作者：张文迪
 * 创建日期：2014-9-10
 */
package 第八章;

import java.util.Random;

/**
 * @author 张文迪
 * 类名：Music3
 * 类说明：练习 6,7,8.   
 */
enum Note
{
    好的吧,额,哈哈;
}
class Instrument
{
    void play(Note n)
    {
    	System.out.println("Instrument.play()"+n);
    }
    public String toString()
    {   
    	return "Instrument";
    }
    void adjust()
    {
    	System.out.println("Adjusting Instrument");
    }
}
class Wind extends Instrument
{
    void play(Note n)
    {
    	System.out.println("Wind.play()"+n);
    }
    public String toString()
    {   
    	return "Wind";
    }
    void adjust()
    {
    	System.out.println("Adjusting Wind");
    }
}
class Percussin extends Instrument
{
    void play(Note n)
    {
    	System.out.println("Percussin.play()"+n);
    }
    public String toString()
    {   
    	return "Percussin";
    }
    void adjust()
    {
    	System.out.println("Adjusting Percussin");
    }
}
class Stringed extends Instrument
{
    void play(Note n)
    {
    	System.out.println("Stringed.play()"+n);
    }
    public String toString()
    {   
    	return "Stringed";
    }
    void adjust()
    {
    	System.out.println("Adjusting Stringed");
    }
}
class Brass extends Wind
{
    void play(Note n)
    {
    	System.out.println("Brass.play()"+n);
    }
    void adjust()
    {
    	System.out.println("Adjusting Brass");
    }
}
class Woodwind extends Wind
{
    void play(Note n)
    {
    	System.out.println("Woodwind.play()"+n);
    }
    void adjust()
    {
    	System.out.println("Adjusting Woodwind");
    }
}
public class Music3
{
    public static void tune(Instrument i)
    {
    	i.play(Note.好的吧);
    	
    }
    /*
     * public static void tuneAll(Instrument[] e)
    {
    	for(Instrument i:e)
    	 tune(i);
    }
    */
    
    public static void main(String args[])
    {
    	/*  Instrument[] allInstruments = 
    	{
    	     new Wind(),
    	     new Percussin(),
    	     new Stringed(),
    	     new Brass(),
    	     new Woodwind(),
    	     new Instrument()
    	};
    	tuneAll(allInstruments);
    	for(Instrument i :allInstruments)
    		System.out.println(i);
    	
    	*/
    	Random random = new Random(47);	
    	switch (random.nextInt(6))
		{
 
		case 0: 
			        Instrument inst1 = new Wind();
			        tune(inst1);
			        System.out.println(inst1);
		        
        
		case 1: 	Instrument inst2 = new Percussin();
					tune(inst2);
				    System.out.println(inst2);
		
		case 2:		Instrument inst3 = new Stringed();
					tune(inst3);
					System.out.println(inst3);
		
		case 3:		Instrument inst4 = new Brass();
		            tune(inst4);
		            System.out.println(inst4);
		
		case 4:		Instrument inst5 = new Woodwind();
					tune(inst5);
					System.out.println(inst5);
	
		case 5:		Instrument inst6 = new Instrument();
					tune(inst6);
					System.out.println(inst6);
		}   	
    }
}
