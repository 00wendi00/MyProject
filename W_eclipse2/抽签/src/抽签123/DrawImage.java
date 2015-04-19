package 抽签123;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawImage 
{

	public static void main(String[] args) {
		  Inco ik = new Inco();
	}
	
}
class Inco extends JFrame{

	  JButton[] buttons = new JButton[12];
	  public Inco()
	  {
	   super("Inco");
	   setSize(335,318);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   JPanel panel = new JPanel();
                 //这里我用了图片的绝对路径，根据你的图片写路径就可以了
	   ImageIcon ic = new ImageIcon("./image/cs.jpg");
	      JLabel label=new JLabel();
	      label.setIcon(ic);
	      panel.add(label);
	      setContentPane(panel);
                     show();
	    
	   }  
	  }
