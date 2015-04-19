/**
 * 文件名：Buttons.java
 * 项目-包：第6章 GUI - 呵呵
 * 作者：张文迪
 * 创建日期：2014-4-25
 */
package 呵呵;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author 胡祝华
 * 类名：Buttons
 * 类说明：
 */
public class Buttons 
{
    public static void main(String args[])
    {
    	JFrame jFrame = new JFrame();
    	JPanel jPanel1 = new JPanel();
    	JPanel jPanel2 = new JPanel();
    	JPanel jPanel3 = new JPanel();
    	JPanel jPanel4 = new JPanel();
    	JPanel jPanel5 = new JPanel();
    	JPanel jPanel6 = new JPanel();    	
    	JButton button = new JButton("button");
    	
    	jPanel1.add(button);

    	
    	
    	
        jFrame.setLayout(new GridLayout(2,1));
        jFrame.add(jPanel1);
        jFrame.add(jPanel2);
        jFrame.add(jPanel3);
        jFrame.add(jPanel4);
        jFrame.add(jPanel5);
        jFrame.add(jPanel6);
        jFrame.setBounds(200, 200, 400, 200);
        jFrame.setVisible(true);
    	jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
    	
    }
}
