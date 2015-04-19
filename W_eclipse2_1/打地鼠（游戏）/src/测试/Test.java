/**
 * 文件名：Test.java
 * 项目-包：打地鼠（游戏） - 测试
 * 作者：张文迪
 * 创建日期：2014-5-23
 */
package 测试;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * @author 张文迪
 * 类名：Test
 * 类说明：
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
		Image img = new ImageIcon("./图片/background1.jpg").getImage();
  		g.drawImage(img, 0,0, null);
  		
  		ImageIcon imageIcon = new ImageIcon(img);
  		
  		panel2.repaint();	
  		this.add(panel2);
  		this.setVisible(true);
  	}
	
}