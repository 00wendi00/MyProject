/**
 * �ļ�����Test.java
 * ��Ŀ-�����������Ϸ�� - ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-23
 */
package ����;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * @author ���ĵ�
 * ������Test
 * ��˵����
 */
public class Test
{
    public static void main(String args[])
    {
    	new HeHe();
    }
}


class HeHe extends JFrame
{
	Panel panel2;

	public void draw(Graphics g)
  	{
		Image img = new ImageIcon("./ͼƬ/background1.jpg").getImage();
  		g.drawImage(img, 0,0, null);
  		
  		ImageIcon imageIcon = new ImageIcon(img);
  		
  		panel2.repaint();	
  		this.add(panel2);
  		this.setVisible(true);
  	}
	
}