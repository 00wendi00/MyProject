/**
 * 文件名：TrackEvent.java
 * 项目-包：JAVA编程思想 - 第二十二章图形化用户界面
 * 作者：张文迪
 * 创建日期：2014-11-8
 */
package 第二十二章图形化用户界面;

/**
 * @author 张文迪
 * 类名：TrackEvent
 * 类说明：
 */
//: gui/TrackEvent.java
//Show events as they happen.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import static net.mindview.util.SwingConsole.*;

public class TrackEvent extends JFrame {
private HashMap<String,JTextField> h =
 new HashMap<String,JTextField>();
private String[] event = {
 "focusGained", "focusLost", "keyPressed",
 "keyReleased", "keyTyped", "mouseClicked",
 "mouseEntered", "mouseExited", "mousePressed",
 "mouseReleased", "mouseDragged", "mouseMoved"
};
private MyButton
 b1 = new MyButton(Color.BLUE, "test1"),
 b2 = new MyButton(Color.RED, "test2");
class MyButton extends JButton {
 void report(String field, String msg) {
   h.get(field).setText(msg);
 }
 FocusListener fl = new FocusListener() {
   public void focusGained(FocusEvent e) {
     report("focusGained", e.paramString());
   }
   public void focusLost(FocusEvent e) {
     report("focusLost", e.paramString());
   }
 };
 KeyListener kl = new KeyListener() {
   public void keyPressed(KeyEvent e) {
     report("keyPressed", e.paramString());
   }
   public void keyReleased(KeyEvent e) {
     report("keyReleased", e.paramString());
   }
   public void keyTyped(KeyEvent e) {
     report("keyTyped", e.paramString());
   }
 };
 MouseListener ml = new MouseListener() {
   public void mouseClicked(MouseEvent e) {
     report("mouseClicked", e.paramString());
   }
   public void mouseEntered(MouseEvent e) {
     report("mouseEntered", e.paramString());
   }
   public void mouseExited(MouseEvent e) {
     report("mouseExited", e.paramString());
   }
   public void mousePressed(MouseEvent e) {
     report("mousePressed", e.paramString());
   }
   public void mouseReleased(MouseEvent e) {
     report("mouseReleased", e.paramString());
   }
 };
 MouseMotionListener mml = new MouseMotionListener() {
   public void mouseDragged(MouseEvent e) {
     report("mouseDragged", e.paramString());
   }
   public void mouseMoved(MouseEvent e) {
     report("mouseMoved", e.paramString());
   }
 };
 public MyButton(Color color, String label) {
   super(label);
   setBackground(color);
   addFocusListener(fl);
   addKeyListener(kl);
   addMouseListener(ml);
   addMouseMotionListener(mml);
 }
}
public TrackEvent() {
 setLayout(new GridLayout(event.length + 1, 2));
 for(String evt : event) {
   JTextField t = new JTextField();
   t.setEditable(false);
   add(new JLabel(evt, JLabel.RIGHT));
   add(t);
   h.put(evt, t);
 }
 add(b1);
 add(b2);
}
public static void main(String[] args) {
 run(new TrackEvent(), 700, 500);
}
} ///:~
