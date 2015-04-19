/**
 * 文件名：test.java
 * 项目-包：打地鼠2 - 测试
 * 作者：张文迪
 * 创建日期：2014-6-7
 */
package 测试;

/**
 * @author 张文迪
 * 类名：test
 * 类说明：
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageTest {

  public static void main(String[] args) {
    ImagePanel panel = new ImagePanel(new ImageIcon("./图片/background1.jpg").getImage());

    JFrame frame = new JFrame();
    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
  }
}

class ImagePanel extends JPanel {

  private Image img;

  public ImagePanel(String img) {
    this(new ImageIcon(img).getImage());
  }

  public ImagePanel(Image img) {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }
}