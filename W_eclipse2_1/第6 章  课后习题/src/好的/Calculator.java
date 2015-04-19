/**
 * 文件名：Calculator.java
 * 项目-包：第6章 GUI - 课后习题
 * 作者：张文迪
 * 创建日期：2014-5-7
 */
package 好的;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * @author 张文迪
 * 类名：Calculator
 * 类说明：
 */
public class Calculator extends JFrame
{
    public Calculator()
    {
    	 this.setBounds(100, 100, 400, 400);
         this.setTitle("简单计算机");          
         this.getContentPane().add(new CalculatorPanel());
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
    	new Calculator().setVisible(true);
    }
}


class CalculatorPanel extends JPanel
{
     private boolean start;
     private String lastCommand;
     private double result;
     private JPanel panel;
     private JLabel display;
    
     
  
     public CalculatorPanel()
     {
    	
    	
    	 setLayout(new BorderLayout());
    	 result = 0;
    	 lastCommand = "=";
    	 start = true;
    	 display = new JLabel("0");
    	
    	 add(display,BorderLayout.NORTH);
    	 ActionListener insert = new InsertAction();
    	 ActionListener command = new CommandAction();    	 
     	 panel = new JPanel();

    	 panel.setLayout(new GridLayout(4, 4));
    	 addButton("7",insert);
    	 addButton("8",insert);
    	 addButton("9",insert);
    	 addButton("/",command);
    	 
    	 addButton("4",insert);
    	 addButton("5",insert);
    	 addButton("6",insert);
    	 addButton("*",command);
    	 
    	 addButton("1",insert);
    	 addButton("2",insert);
    	 addButton("3",insert);
    	 addButton("-",command);
    	 
    	 addButton("0",insert);
    	 addButton(".",insert);
    	 addButton("=",command);
    	 addButton("+",command);
    	 
    	 
    	 
    	 add(panel,BorderLayout.CENTER);
   	 
    	 
     }   	
     
     void addButton(String desp,ActionListener listener)
     {
    	 JButton btn = new JButton(desp);
    	 btn.addActionListener(listener);
    	 panel.add(btn);
     }
     
     class InsertAction implements ActionListener
     {
		public void actionPerformed(ActionEvent e)
		{
            String input = e.getActionCommand();
            if(start)
            {
            	display.setText("");
            	start = false;
            }
            display.setText(display.getText()+input);
		}   	 
     }


    class CommandAction implements ActionListener
    {
	       public void actionPerformed(ActionEvent e)
	       {
		       String command = e.getActionCommand();
		       if(start)
		       {
			      if(command.equals("-"))
			      {
			         display.setText(command);
			         start = false ;			 
			      }
			      else 
				  lastCommand = command;			
		       }
		       else 
		        {
			       calculate(Double.parseDouble(display.getText()));
			       lastCommand = command;
			       start = true;
                }
            }   
    }	
	public void calculate(double x)
	{
		if(lastCommand.equals("+")) 
			result += x;
		else if(lastCommand.equals("-")) 
			result -= x;
		else if(lastCommand.equals("*")) 
			result *= x;
		else if(lastCommand.equals("/")) 
			result /= x;
		else if(lastCommand.equals("=")) 
			result = x;
		display.setText(""+result);
	}
}



