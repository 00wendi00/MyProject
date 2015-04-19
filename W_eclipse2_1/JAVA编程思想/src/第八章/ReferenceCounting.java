/**
 * 文件名：ReferenceCounting.java
 * 项目-包：JAVA编程思想 - 第八章
 * 作者：张文迪
 * 创建日期：2014-9-10
 */
package 第八章;

import org.w3c.dom.css.Counter;

/**
 * @author 张文迪
 * 类名：ReferenceCounting
 * 类说明：练习13 ：  终止 条件 ？？？？？？？？？？？？？
 */
public class ReferenceCounting
{
     public static void main(String args[])
     {
    	  Shared shared = new Shared();
    	  Composing[] composing = 
    	  {
    			 new Composing(shared),
    			 new Composing(shared),
    			 new Composing(shared),
    			 new Composing(shared),
    			 new Composing(shared)
    	  };
    	  for(Composing c:composing)
    		  c.dispose();
     }
}
class Shared
{
	 boolean checked = true;
     private int refcount = 0;
     private static long counter = 0;
     private final long id = counter++;
     public Shared()
     {
    	 System.out.println("Creating "+this);
     }
     public void addRef()
     {
    	 refcount++;
     }
     protected void dispose()
     {
    	 if(--refcount ==0)
    		 System.out.println("Disposing" +this);
     }
     public String toString()
     {
    	 return "Shared "+id;
     }
     protected void finalize()
     {
    	 if(checked)
    	   System.out.println("清理了！");
     }
}

class Composing
{
     private Shared shared;
     private static long counter = 0;
     private final long id = counter++;
     public Composing(Shared shared)
     {
    	 System.out.println("Creating"+this);
    	 this.shared = shared;
    	 this.shared.addRef();
     }
     protected void dispose()
     {
    	 System.out.println("disposing"+this);
    	 shared.dispose();
     }
     public String toString()
     {
    	 return "Composing"+id;
     }
}
