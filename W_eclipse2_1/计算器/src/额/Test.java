/**
 * 文件名：Test.java
 * 项目-包：计算机 - 额
 * 作者：张文迪
 * 创建日期：2014-4-27
 */
package 额;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 * @author 张文迪
 * 类名：Test
 * 类说明：
 */
public class Test
{
     public static void main(String args[])
     {
    	 new Caculater();
     }
}

class Caculater extends JFrame
{
	TextField textField1 = new TextField(20);
	
	private boolean start;
    private String lastCommand;
    private double result;
    private JPanel panel;
    private JLabel display;
	
	public  Caculater()
	{		
		Panel panel1 = new Panel();
        Panel panel2 = new Panel();
		
		Label label = new Label("=");
		TextField textField2 = new TextField(10);
		Button button11 = new Button("1");
		Button button12 = new Button("2");
		Button button13 = new Button("3");
		Button button14 = new Button("加");
		Button button15 = new Button("减");
		Button button21 = new Button("4");
		Button button22 = new Button("5");
		Button button23 = new Button("6");
		Button button24 = new Button("乘");
		Button button25 = new Button("除");
		Button button31 = new Button("7");
		Button button32 = new Button("8");
		Button button33 = new Button("9");
		Button button34 = new Button("0");
		Button button35 = new Button("=");
		
		
		button11.addActionListener(new hehe1());

        
        panel1.add(textField1);
        panel1.add(label);
        panel1.add(textField2);
        panel1.setBounds(0, 0, 320, 30);

        panel2.setBounds(0,30, 320, 200);
        panel2.add(button11);
        panel2.add(button12);
        panel2.add(button13);
        panel2.add(button14);
        panel2.add(button15);
        panel2.add(button21);
        panel2.add(button22);
        panel2.add(button23);
        panel2.add(button24);
        panel2.add(button25);
        panel2.add(button31);
        panel2.add(button32);
        panel2.add(button33);
        panel2.add(button34);
        panel2.add(button35);
                                
        add(panel1);     
        add(panel2);
              
        panel2.setLayout(new GridLayout(3,5));
        setBounds(100, 100, 335, 270);
        setLayout(null);
        setVisible(true);
        addComponentListener(null);
        
        this.addWindowListener(new WindowAdapter()
		{
        	public void windowClosing(WindowEvent w)
        	{
        		System.exit(0);
        	}
		});
		
			
	}
	
	
	
	class hehe1 implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			
			textField1.setText("1");
		}	
	}
	
	class guanbi implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{			
			System.exit(0);
		}		
		
	}
}



