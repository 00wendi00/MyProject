package 哈哈;


//��������Ŀ~~
public class MyThread extends Thread implements Runnable 
{  
	  
    @Override  
    public void run() 
    {  
        // TODO Auto-generated method stub  
        for (int i = 0; i < 50; i++) 
        {  
            System.out.println("This is the test"+i);  
        }  
    }  
  
    /**  
     * @param args  
     */  
    public static void main(String[] args) 
    {  
        // TODO Auto-generated method stub  
        Thread thread = new Thread(new MyThread());  
        thread.start();  
    }  
  
} 
