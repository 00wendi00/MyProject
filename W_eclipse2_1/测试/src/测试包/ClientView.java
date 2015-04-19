/**
 * 文件名：ClientView.java
 * 项目-包：测试 - 测试包
 * 作者：张文迪
 * 创建日期：2014-5-17
 */
package 测试包;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.html.MinimalHTMLWriter;

/**
 * @author 张文迪
 * 类名：ClientView
 * 类说明：
 */
/**
 * 文件名：ClientView.java
 * 项目-包：打地鼠（游戏） - 窗口
 * 作者：张文迪
 * 创建日期：2014-5-14
 */


/**
 * @author 张文迪
 * 类名：Calculator
 * 类说明：
 */
public class ClientView extends JFrame
{
    public ClientView()
    {
    	 this.setBounds(100, 100, 400, 400);
         this.setTitle("打地鼠游戏");      
         
         this.getContentPane().add(new ClientPanel());
         
         
         this.addWindowListener(new WindowAdapter()
		{
		
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
        	
		});
       
    }
    public static void main(String args[])
    {
    	new ClientView().setVisible(true);
    }
}


class Dishu 
{
	
	Dishu dishu;
	Graphics g;
	Image dishuImage;
	
	public Dishu()
	{
		dishuImage = new ImageIcon("./图片/1.png").getImage();
	}
	
	int q,w,e,r;	
	public void drawItself(ClientPanel	panel,Graphics g)
	{
		
		int a[]={q,w,e,r};  
		g.drawImage(dishuImage,0,38,100,100,null);
		panel.repaint();
				
	}
	
	public void setImage(Image image)
	{
		dishuImage = image;
	}
	
}

class ClientPanel extends JPanel
{
     
	 Dishu dishu;
	 Graphics g;
	
	 private boolean start;
     private String lastCommand;
     private double result;
    
     private JPanel panel1;
     private JPanel panel2;
     private JLabel display1;
     private JLabel display2;
     private JButton button1;
     private JButton button2;
     
  
     public ClientPanel()
     {
    	 
       	 setLayout(new BorderLayout());              
    	 display1 = new JLabel("分数 "+" 0 ");
    	 display2 = new JLabel("关卡数 "+" 0 ");
    	 button1 = new JButton("开始");
    	 button2 = new JButton("结束");
    	 panel1 = new JPanel();
    	 panel2 = new JPanel();    	 
    	 panel1.setLayout(new FlowLayout());    	 
    	 panel1.add(display1);
    	 panel1.add(display2);
    	 panel1.add(button1);
    	 panel1.add(button2);  
    	 
    	 add(panel1,BorderLayout.NORTH);
    	 
    	 
    	 
 		 this.setFocusable(true);//获得输入焦点。
 		 
 		 panel2.setLayout(new GridLayout(3, 3));
 		 MyKeyListener Action = new MyKeyListener();
 		 this.addKeyListener(Action);
    	   	     	    	 
    	 addHoll("9",Action);
    	 addHoll("8",Action);
    	 addHoll("7",Action); 	 
    	 addHoll("6",Action);
    	 addHoll("5",Action);
    	 addHoll("4",Action); 	 
    	 addHoll("23",Action);
    	 addHoll("2",Action);
    	 addHoll("2",Action);
             	     	  	 
    	 add(panel2,BorderLayout.CENTER);

     }   	
       
     public void paint(Graphics g)
 	 {
 	    super.paint(g);
 	    this.g = g;
 		dishu.drawItself(this,g);

 	}
 
     void addHoll(String string,ActionListener listener)
     {
    	 dishu = new Dishu();
    	 JPanel myJPanel = new JPanel(){
    		 public void paintComponent(Graphics g) {
    			  super.paintComponent(g);
    			  ImageIcon img = new ImageIcon("./图片/1.png");
    			  g.drawImage(img.getImage(), 0, 0, 100, 100,  null);
    			 }
    			};;
    	 panel2.add(myJPanel);
    	 
     }
    
     
     class MyKeyListener extends KeyAdapter implements ActionListener 
     {
		public void actionPerformed(ActionEvent e)
		{			
			
		}
		public void keyPressed(KeyEvent e)
		{	
			
			switch (e.getKeyCode())
			{
			case KeyEvent.VK_NUMPAD1:			     			   		    					
			     
				dishu.setImage(new ImageIcon("./图片/6.png").getImage());				
				dishu.drawItself(ClientPanel.this, g); 
			
				break;
			case KeyEvent.VK_NUMPAD2:
				dishu.setImage(new ImageIcon("./图片/6.png").getImage());				
				dishu.drawItself(ClientPanel.this, g);  
				break;
			case KeyEvent.VK_NUMPAD3:
				dishu.setImage(new ImageIcon("./图片/6.png").getImage());				
				dishu.drawItself(ClientPanel.this, g);  
				break;
			case KeyEvent.VK_NUMPAD4:
				dishu.setImage(new ImageIcon("./图片/6.png").getImage());				
				dishu.drawItself(ClientPanel.this, g);  
				break;	
			case KeyEvent.VK_NUMPAD5:
				dishu.setImage(new ImageIcon("./图片/6.png").getImage());				
				dishu.drawItself(ClientPanel.this, g);  
				break;
			case KeyEvent.VK_NUMPAD6:
				dishu.setImage(new ImageIcon("./图片/6.png").getImage());				
				dishu.drawItself(ClientPanel.this, g);  
				break;
			case KeyEvent.VK_NUMPAD7:
				dishu.setImage(new ImageIcon("./图片/6.png").getImage());				
				dishu.drawItself(ClientPanel.this, g);  
				break;
			case KeyEvent.VK_NUMPAD8:
				dishu.setImage(new ImageIcon("./图片/6.png").getImage());				
				dishu.drawItself(ClientPanel.this, g);  
				break;
			case KeyEvent.VK_NUMPAD9:
				dishu.setImage(new ImageIcon("./图片/6.png").getImage());				
				dishu.drawItself(ClientPanel.this, g);  
				break;
				
				
			default:
				break;
			}
		}
		 	 
     }
   
	
}