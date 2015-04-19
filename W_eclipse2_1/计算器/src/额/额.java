/**
 * 文件名：额.java
 * 项目-包：计算器 - 额
 * 作者：张文迪
 * 创建日期：2014-5-8
 */
package 额;

/**
 * @author 张文迪
 * 类名：额
 * 类说明：
 */
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
public class 额 extends JFrame implements ActionListener 
{ 
private boolean dotExist, operated, equaled; // 帮助运算的布尔变量 
private double storedNumber; // 目前的结果 
private char lastOperator; // 表示上一运算符 
private JTextField operation; // 结果栏 
private JButton dot, plus, minus, multi, div, sqrt, equal, changePN, clear; // 运算符 
private JButton[] numbers; // 数字 
// 构造者 
public 额() 
{ 
setTitle("Calculator"); 
// 初始化变量 
dotExist = false; // 表示当前的数是否有小数点 
operated = false; // 表示任意运算符是否被按下 
equaled = false; // 表示等号是否被按下 
storedNumber = 0; 
lastOperator = '?'; 
// 初始化窗口变量 
operation = new JTextField("0"); 
operation.setEditable(false); 
numbers = new JButton[10]; 
for (int i = 0; i < 10; i++) 
numbers[i] = new JButton("" + i); 
dot = new JButton("."); 
plus = new JButton("+"); 
minus = new JButton("-"); 
multi = new JButton("*"); 
div = new JButton("/"); 
sqrt = new JButton("√"); 
equal = new JButton("="); 
changePN = new JButton("±"); 
clear = new JButton("AC"); 
// 将窗口物体放入窗口 
GridBagLayout layout = new GridBagLayout(); 
getContentPane().setLayout(layout); 
addComponent(layout, operation, 0, 0, 4, 1); 
addComponent(layout, numbers[1], 1, 0, 1, 1); 
addComponent(layout, numbers[2], 1, 1, 1, 1); 
addComponent(layout, numbers[3], 1, 2, 1, 1); 
addComponent(layout, numbers[4], 2, 0, 1, 1); 
addComponent(layout, numbers[5], 2, 1, 1, 1); 
addComponent(layout, numbers[6], 2, 2, 1, 1); 
addComponent(layout, numbers[7], 3, 0, 1, 1); 
addComponent(layout, numbers[8], 3, 1, 1, 1); 
addComponent(layout, numbers[9], 3, 2, 1, 1); 
addComponent(layout, dot, 4, 0, 1, 1); 
addComponent(layout, numbers[0], 4, 1, 1, 1); 
addComponent(layout, sqrt, 4, 2, 1, 1); 
addComponent(layout, plus, 1, 3, 1, 1); 
addComponent(layout, minus, 2, 3, 1, 1); 
addComponent(layout, multi, 3, 3, 1, 1); 
addComponent(layout, div, 4, 3, 1, 1); 
addComponent(layout, equal, 5, 0, 2, 1); 
addComponent(layout, changePN, 5, 2, 1, 1); 
addComponent(layout, clear, 5, 3, 1, 1); 
this.addWindowListener(new WindowAdapter()
{

	/* (non-Javadoc)
	 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	
});
} 
// 对按钮进行反应的方法 
public void actionPerformed(ActionEvent e) 
{ 
JButton btn = (JButton)e.getSource(); 
if (btn == clear) 
{ 
operation.setText("0"); 
dotExist = false; 
storedNumber = 0; 
lastOperator = '?'; 
} 
else if (btn == equal) 
{ 
operate('='); 
equaled = true; 
} 
else if (btn == plus) 
{ 
operate('+'); 
equaled = false; 
} 
else if (btn == minus) 
{ 
operate('-'); 
equaled = false; 
} 
else if (btn == multi) 
{ 
operate('*'); 
equaled = false; 
} 
else if (btn == div) 
{ 
operate('/'); 
equaled = false; 
} 
else if (btn == changePN) 
{ 
operate('p'); 
operate('='); 
equaled = true; 
} 
else if (btn == sqrt) 
{ 
operate('s'); 
operate('='); 
equaled = true; 
} 
else 
{ 
if (equaled) 
storedNumber = 0; 
for (int i = 0; i < 10; i++) 
if (btn == numbers[i]) 
{ 
if (operation.getText().equals("0")) 
operation.setText("" + i); 
else if(! operated) 
operation.setText(operation.getText() + i); 
else 
{ 
operation.setText("" + i); 
operated = false; 
} 
} 
if (btn == dot && ! dotExist) 
{ 
operation.setText(operation.getText() + "."); 
dotExist = true; 
} 
} 
} 
// 进行运算的方法 
private void operate(char operator) 
{ 
double currentNumber = Double.valueOf(operation.getText()).doubleValue(); 
if (lastOperator == '?') 
storedNumber = currentNumber; 
else if (lastOperator == '+') 
storedNumber += currentNumber; 
else if (lastOperator == '-') 
storedNumber -= currentNumber; 
else if (lastOperator == '*') 
storedNumber *= currentNumber; 
else if (lastOperator == '/') 
storedNumber /= currentNumber; 
else if (lastOperator == 'p') 
storedNumber *= -1; 
else if (lastOperator == 's') 
storedNumber = Math.sqrt(currentNumber); 
else if (lastOperator == '=' && equaled) 
storedNumber = currentNumber; 
operation.setText("" + storedNumber); 
operated = true; 
lastOperator = operator; 
} 
// 快捷使用GridBagLayout的方法 
private void addComponent(GridBagLayout layout, Component component, int row, int col, int width, int height) 
{ 
GridBagConstraints constraints = new GridBagConstraints(); 
constraints.fill = GridBagConstraints.BOTH; 
constraints.insets = new Insets(10, 2, 10, 2); 
constraints.weightx = 100; 
constraints.weighty = 100; 
constraints.gridx = col; 
constraints.gridy = row; 
constraints.gridwidth = width; 
constraints.gridheight = height; 
layout.setConstraints(component, constraints); 
if (component instanceof JButton) 
((JButton)component).addActionListener(this); 
getContentPane().add(component); 
} 
// 主方法初始化并显示窗口 
public static void main(String[] args) 
{ 
额 calc = new 额(); 
calc.setSize(290, 400); 
calc.setVisible(true); 
} 
} 