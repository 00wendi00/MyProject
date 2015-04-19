
import javax.swing.JLabel;




public class HitMouseLauncher
{
	 public static void main( String args[] )
	   {
		    HitMouseFrame  frame=new HitMouseFrame();		    
	        frame.setVisible(true);             //显示窗体	        
	        new Thread(frame).start();          //启动线程     
        
	      
	    }
	        
	   
}








