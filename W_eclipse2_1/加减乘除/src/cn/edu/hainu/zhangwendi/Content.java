/**
 * 文件名：Content.java
 * 项目-包：一百位数的加减乘除 - cn.edu.hainu.wendizhang
 * 作者：张文迪
 * 创建日期：2014-9-15
 */
package cn.edu.hainu.zhangwendi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 * @author 张文迪
 * 类名：Content
 * 类说明：退出时    显示对话框   是否退出 .进入时   text1获取焦点
  */
public class Content extends JFrame
{
	static int numberbuttun = 1;
	static int numberPoint1 = 0,
	           numberPoint2 = 0,
			   number = 0;
	  String[] num1 = null;
	  String[] num2 = null;
	  String[] num11 = new String[10000],
	           num22 = new String[10000];
	  
	Content()
	{
		JFrame f = new JFrame("大整数的加减乘除");
		JPanel jPanel1 = new JPanel();
		JPanel jPanel2 = new JPanel();
		JPanel jPanel3 = new JPanel();
		JPanel jPanel4 = new JPanel();
		JButton jButton1 = new JButton("加");
		JButton jButton2 = new JButton("减");
		JButton jButton3 = new JButton("乘");
		JButton jButton4 = new JButton("等于");
		JButton jButton5 = new JButton("继续运算");
		final JTextField jTextField1 = new JTextField(60);
		final JTextField jTextField2 = new JTextField(60);
		final JTextField jTextField3 = new JTextField(60);
		final JLabel jLabel1 = new JLabel("加");
		final JLabel jLabel2 = new JLabel("=");
		

		jButton4.addActionListener(new ActionListener()
		{
			//Add add = new Add();
			public void actionPerformed(ActionEvent e)
			{				  				  				  
				  num1 = new String[jTextField1.getText().length()];
				  num2 = new String[jTextField2.getText().length()];
				  				  
				  for(int i =0;i<jTextField1.getText().length();i++)
				  {							
					  num1[i] = String.valueOf(jTextField1.getText().charAt(i));
					 //  System.out.print(num1[i]);						 
				  }	
				  //System.out.println();
				  for(int i =0;i<jTextField2.getText().length();i++)
				  {					  
					  num2[i] = String.valueOf(jTextField2.getText().charAt(i));
					  //System.out.print(num2[i]);					  
				  }	
				 // System.out.println();
				 
				  
				  if(num1==null || num2==null)
				  {
					  JOptionPane.showMessageDialog(null, "请输入合法数字");
				  }
				  
	 //为什么num1[0].equals("+") 或者  charAt(0)=='+'或者charAt(0)=43  或者num1="+"  认不出来？？
				  if(num1[0].equalsIgnoreCase("+")||num1[0].equalsIgnoreCase("-"))
				  {
					  if (num1[1].charAt(0)>47&&num1[1].charAt(0)<=57)
					  {
						  for(int i = 2;i<num1.length;i++)
						  {
							  if(num1[i].equalsIgnoreCase("."))
							  {
								  numberPoint1++;
							  }
							  else if (num1[i] == null) 
							  {
								  
							  }
							  else if(num1[i].charAt(0)>47&&num1[i].charAt(0)<=57)
							  {}
							  else
							  {
								  JOptionPane.showMessageDialog(null, "请输入合法数字");
								  return;
							  }							  
						  }
					  }
					  else 
					  {
						  JOptionPane.showMessageDialog(null, "请输入合法数字");
						  return;
					  }
				  }
				  else  
				  {
					  if (num1[0].charAt(0)>47&&num1[0].charAt(0)<=57)
					  {
						  for(int i = 1;i<num1.length;i++)
						  {
							  if(num1[i].equalsIgnoreCase("."))
							  {
								  numberPoint1++;
							  }
							  else if (num1[i] == null) 
							  {}
							  else if(num1[i].charAt(0)>47&&num1[i].charAt(0)<=57)
							  {}
							  else
							  {
								   JOptionPane.showMessageDialog(null, "请输入合法数字");
								   return;
							  }
							  
						  }
					  }
					  else 
					  {
						  JOptionPane.showMessageDialog(null, "请输入合法数字");
						  return;
					  }
				  }				  
				  if(numberPoint1>1)
				  {
					  JOptionPane.showMessageDialog(null, "请输入合法数字");
					  return;
				  }
				  
				  if(num2[0].equalsIgnoreCase("+")||num2[0].equalsIgnoreCase("-"))
				  {
					  if (num2[1].charAt(0)>47&&num2[1].charAt(0)<=57)
					  {
						  for(int i = 2;i<num2.length;i++)
						  {
							  if(num2[i].equalsIgnoreCase("."))
							  {
								  numberPoint2++;
							  }
							  else if (num2[i] == null) 
							  {
								  
							  }
							  else if(num2[i].charAt(0)>47&&num2[i].charAt(0)<=57)
							  {}
							  else
							  {
								  JOptionPane.showMessageDialog(null, "请输入合法数字");
								  return;
							  }
						  }
					  }
					  else 
					  {
						  JOptionPane.showMessageDialog(null, "请输入合法数字");
						  return;
					  }
				  }
				  else  
				  {
					  if (num2[0].charAt(0)>47&&num2[0].charAt(0)<=57)
					  {
						  for(int i = 1;i<num2.length;i++)
						  {
							  if(num2[i].equalsIgnoreCase("."))
							  {
								  numberPoint2++;
							  }
							  else if (num2[i] == null) 
							  {
								  
							  }
							  else if(num2[i].charAt(0)>47&&num2[i].charAt(0)<=57)
							  {}
							  else
							  {
								  JOptionPane.showMessageDialog(null, "请输入合法数字");
								  return;
							  }					  
						  }
					  }
					  else
					  {
						  JOptionPane.showMessageDialog(null, "请输入合法数字");
						  return;
					  }
				  }
				  			  
				  if(numberPoint2>1)
				  {					  
					  JOptionPane.showMessageDialog(null, "请输入合法数字");
					  return;
				  }
				  
				  JOptionPane.showMessageDialog(null, "~~~~~~~~");
				   
				  Classify classify = new Classify();	
				  
				  numberPoint1 = 0;
				  numberPoint2 = 0;
				  
				  jTextField3.setText(classify.addClass(num1, num2, numberbuttun));

				  
			}
		});
		
		
		f.add(jPanel1,BorderLayout.NORTH);
		f.add(jPanel2,BorderLayout.CENTER);
		jPanel1.add(jButton1);
		jPanel1.add(jButton2);
		jPanel1.add(jButton3);
		jPanel1.add(jButton4);
		jPanel1.add(jButton5);
		jPanel2.add(jTextField1,BorderLayout.NORTH);
		jPanel2.add(jPanel3,BorderLayout.CENTER);
		jPanel3.add(jLabel1);
		jPanel3.add(jTextField2);
		jPanel2.add(jPanel4,BorderLayout.SOUTH);
		jPanel4.add(jLabel2);
		jPanel4.add(jTextField3);
		
		//jPanel1.setLayout(new FlowLayout(0));	
		
		f.setResizable(false);
		f.setBounds(200, 200, 800,200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		jButton1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jLabel1.setText("加");
				numberbuttun = 1;
			}
		});
		jButton2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jLabel1.setText("减");
				numberbuttun = 2;
			}
		});
		jButton3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jLabel1.setText("乘");
				numberbuttun = 3;
			}
		});
		jButton5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{				
				jTextField1.setText(null);
				jTextField2.setText(null);
				jTextField3.setText(null);	
				numberbuttun = 1;
				jLabel1.setText("加");
			}
		});
	}	
	
}	