/**
 * �ļ�����ReferenceCounting.java
 * ��Ŀ-����JAVA���˼�� - �ڰ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-10
 */
package �ڰ���;

import org.w3c.dom.css.Counter;

/**
 * @author ���ĵ�
 * ������ReferenceCounting
 * ��˵������ϰ13 ��  ��ֹ ���� ��������������������������
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
    	   System.out.println("�����ˣ�");
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
