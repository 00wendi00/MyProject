
import javax.swing.JLabel;




public class HitMouseLauncher
{
	 public static void main( String args[] )
	   {
		    HitMouseFrame  frame=new HitMouseFrame();		    
	        frame.setVisible(true);             //��ʾ����	        
	        new Thread(frame).start();          //�����߳�     
        
	      
	    }
	        
	   
}








