/**
 * 文件名：Mouse.java
 * 项目-包：打地鼠2 - Test
 * 作者：张文迪
 * 创建日期：2014-6-7
 */
package Test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author 张文迪
 * 类名：Mouse
 * 类说明：
 */
class Mouse extends JLabel
{    
	              
	private ImageIcon imgMouse;           //地鼠图片对象
	
	public Mouse()
	{
	   imgMouse=new ImageIcon("./图片/地鼠4.png");    //初始化地鼠图片对象
	   setSize(imgMouse.getIconWidth(),imgMouse.getIconHeight());//设置标签与地鼠图片相同大小
	
    }


}