/**
 * 文件名：Ex12.java
 * 项目-包：JAVA编程思想 - 第二十二章图形化用户界面
 * 作者：张文迪
 * 创建日期：2014-11-8
 */
package 第二十二章图形化用户界面;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author 张文迪
 * 类名：Ex12
 * 类说明：第12题~~~
 */
class TrackEvent extends JFrame {
	private HashMap<String,JTextField> h =
	new HashMap<String,JTextField>();
	private String[] event = {
	"actionPerformed", "stateChanged",
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
	ActionListener al = new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	report("actionPerformed", e.paramString());
	

	}
	};
	ChangeListener cl = new ChangeListener() {
	public void stateChanged(ChangeEvent e) {
	report("stateChanged", e.toString());
	}
	};
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
	addActionListener(al);
	addChangeListener(cl);
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
	}
public class Ex12{
	public static void main(String[] args) {
	SwingConsole.run(new TrackEvent(), 700, 500);
	}
	} 
