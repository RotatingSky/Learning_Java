/**
 *	FileName:		
 *		Calculator.java
 *	Instructions:
 *		1. This program doesn't support edit text.
 *		2. This Calculator supports input from keyboard.
 *		3. All icons of Calculator at "./Icons"
 *	@auther			Sny
 *	@date			2018-03-28
 *	@version		1.00
 *	@see			ActionListener, KeyListener
 *	@description	Realize a calculator functions.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *	Enumeration Class which contains 4 states.
 *	@description	The program use these states to control input.
 */
enum State {
	INPUT_OPERAND_1,
	INPUT_OPERAND_2,
	INPUT_OPERATOR,
	GET_RESULT
}

public class Calculator extends JFrame implements ActionListener, KeyListener {
	// Private global variables.
	private String[] btnStr = {"0","1","2","3","4","5","6","7","8","9","+","-","*","/","=","C"};
	private JButton[] btns;
	private JLabel num1Label;
	private JLabel num2Label;
	private JLabel resultLabel;
	private JTextField number1;
	private JTextField number2;
	private JTextField result;
	private JPanel textP1;
	private JPanel textP2;
	private JPanel textP3;
	private JPanel numP;
	private ImageIcon icon;
	private String operator = "";
	private State flag = State.INPUT_OPERAND_1;
	private boolean shiftFlag = false;

	/**
	 *	This constructor create a operational panel for Calculator.
	 *	It contains 3 label-text rows and 16 buttons.
	 *	And I add action listener and key listener methods to buttons.
	 */
	public Calculator() {
		// Create a button array and 3 label-text rows
		btns = new JButton[btnStr.length];
		num1Label = new JLabel("Operand I");
		num2Label = new JLabel("Operand II");
		resultLabel = new JLabel("Result");
		num1Label.setPreferredSize(new Dimension(80, 30));
		num2Label.setPreferredSize(new Dimension(80, 30));
		resultLabel.setPreferredSize(new Dimension(80, 30));
		number1 = new JTextField();
		number2 = new JTextField();
		result = new JTextField();
		// Set text display on the right side.
		number1.setHorizontalAlignment(JTextField.RIGHT);
		number2.setHorizontalAlignment(JTextField.RIGHT);
		result.setHorizontalAlignment(JTextField.RIGHT);
		// set textField cannot be edited.
		number1.setEditable(false);
		number2.setEditable(false);
		result.setEditable(false);
		number1.addKeyListener(this);
		number2.addKeyListener(this);
		result.addKeyListener(this);

		// Make panel look better.
		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		textP1 = new JPanel();
		textP2 = new JPanel();
		textP3 = new JPanel();
		textP1.setLayout(new BoxLayout(textP1, BoxLayout.X_AXIS));
		textP2.setLayout(new BoxLayout(textP2, BoxLayout.X_AXIS));
		textP3.setLayout(new BoxLayout(textP3, BoxLayout.X_AXIS));
		textP1.add(num1Label);textP1.add(number1);
		textP2.add(num2Label);textP2.add(number2);
		textP3.add(resultLabel);textP3.add(result);
		container.add(textP1);
		container.add(textP2);
		container.add(textP3);

		numP = new JPanel(new GridLayout(4, 4, 2, 2));
		for(int i = 0; i < btnStr.length; i++) {
			btns[i] = new JButton();
			// Set icon for a button.
			icon = new ImageIcon("./Icons/" + Integer.toString(i) + ".png");
			// Resize the icon.
			icon.setImage(icon.getImage().getScaledInstance(50, 50, Image.SCALE_FAST));
			btns[i].setIcon(icon);
			btns[i].addActionListener(this);
			btns[i].addKeyListener(this);
		}
		numP.add(btns[7]);numP.add(btns[8]);numP.add(btns[9]);numP.add(btns[15]);
		numP.add(btns[4]);numP.add(btns[5]);numP.add(btns[6]);numP.add(btns[12]);
		numP.add(btns[1]);numP.add(btns[2]);numP.add(btns[3]);numP.add(btns[13]);
		numP.add(btns[10]);numP.add(btns[0]);numP.add(btns[11]);numP.add(btns[14]);
		container.add(numP);
	}

	/**
	 *	This method return the result of compute.
	 *	@param	operator	The operator to compute.
	 *	@return	Result of compute which converts to String type.
	 */
	public String compute (String operator) {
		double operand1 = Double.valueOf(number1.getText()).doubleValue();
		double operand2 = Double.valueOf(number2.getText()).doubleValue();
		double answer = 0;
		if(operator.equals("+")) {
			answer = operand1 + operand2;
		}
		else if(operator.equals("-")) {
			answer = operand1 - operand2;
		}
		else if(operator.equals("*")) {
			answer = operand1 * operand2;
		}
		else if(operator.equals("/")) {
			if(operand2 == 0)
			{
				return "Math Error!";
			}
			answer = operand1 / operand2;
		}
		return Double.toString(answer);
	}

	/**
	 *	This method handle button clicked events.
	 *	@param	index	Button index.
	 *	@return	Nothing.
	 */
	public void buttonHandler(int index) {
		/*
		 *	Index of buttons:
		 *	0~9:	numbers
		 *	10~13:	operators
		 *	14:	equals
		 *	15:	backspace
		 */
		if(flag == State.INPUT_OPERAND_1) {
			if(index < 10) {
				number1.setText(number1.getText() + Integer.toString(index));
				result.setText(number1.getText());
			}
			else if(index < 14) {
				if(number1.getText().equals("")) {
					if(result.getText().equals("")) {
						result.setText("Input Operand I");
					}
					else {
						number1.setText(result.getText());
						flag = State.INPUT_OPERATOR;
					}
				}
				else {
					flag = State.INPUT_OPERATOR;
				}
			}
			else if(index == 14) {
				flag = State.GET_RESULT;
			}
			else if(index == 15) {
				String curStr = number1.getText();
				if(curStr.length() > 0) {
					number1.setText(curStr.substring(0, curStr.length() - 1));
					result.setText(number1.getText());
				}
			}
		}
		if(flag == State.INPUT_OPERATOR) {
			if(index < 10) {
				flag = State.INPUT_OPERAND_2;
			}
			else if(index < 14) {
				operator = btnStr[index];
				result.setText(number1.getText() + operator + number2.getText());
			}
			else if(index == 14) {
				flag = State.GET_RESULT;
			}
			else if(index == 15) {
				result.setText(number1.getText());
				flag = State.INPUT_OPERAND_1;
			}
		}
		if(flag == State.INPUT_OPERAND_2) {
			if(index < 10) {
				number2.setText(number2.getText() + Integer.toString(index));
				result.setText(number1.getText() + operator + number2.getText());
			}
			else if(index < 14) {
				if(number1.getText().equals("")) {
					result.setText("Input Operand I");
					flag = State.INPUT_OPERAND_1;
				}
				else if(number2.getText().equals("")) {
					result.setText("Input Operand II");
					flag = State.INPUT_OPERAND_2;
				}
				else {
					number1.setText(compute(operator));
					number2.setText("");
					operator = btnStr[index];
					result.setText(number1.getText() + operator);
					flag = State.INPUT_OPERATOR;
				}
			}
			else if(index == 14) {
				flag = State.GET_RESULT;
			}
			else if(index == 15) {
				String curStr = number2.getText();
				if(curStr.length() > 0) {
					number2.setText(curStr.substring(0, curStr.length() - 1));
					result.setText(number1.getText() + operator + number2.getText());
				}
			}
		}
		if(flag == State.GET_RESULT) {
			if(number1.getText().equals("")) {
				result.setText("Input Operand I");
				flag = State.INPUT_OPERAND_1;
			}
			else if(operator.equals("")){
				result.setText("Select Operator");
				flag = State.INPUT_OPERATOR;
			}
			else if(number2.getText().equals("")) {
				result.setText("Input Operand II");
				flag = State.INPUT_OPERAND_2;
			}
			else {
				result.setText(compute(operator));
				number1.setText("");
				number2.setText("");
				operator = "";
				flag = State.INPUT_OPERAND_1;
			}
		}
	}

	/**
	 *	This is an override method according to ActionListener.
	 *	@param	e		ActionEvent of button.
	 *	@return	Nothing.
	 */
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < btnStr.length; i++) {
			if(e.getSource() == btns[i]) {
				buttonHandler(i);
				break;
			}
		}
	}

	/**
	 *	This is an override method according to KeyListener.
	 *	@param	e		KeyEvent of button
	 *	@return	Nothing.
	 */
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 *	This is an override method according to KeyListener.
	 *	It checks when key pressed.
	 *	@param	e		KeyEvent of button
	 *	@return	Nothing.
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
			shiftFlag = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_0) {
			buttonHandler(0);
		}
		else if(e.getKeyCode() == KeyEvent.VK_1) {
			buttonHandler(1);
		}
		else if(e.getKeyCode() == KeyEvent.VK_2) {
			buttonHandler(2);
		}
		else if(e.getKeyCode() == KeyEvent.VK_3) {
			buttonHandler(3);
		}
		else if(e.getKeyCode() == KeyEvent.VK_4) {
			buttonHandler(4);
		}
		else if(e.getKeyCode() == KeyEvent.VK_5) {
			buttonHandler(5);
		}
		else if(e.getKeyCode() == KeyEvent.VK_6) {
			buttonHandler(6);
		}
		else if(e.getKeyCode() == KeyEvent.VK_7) {
			buttonHandler(7);
		}
		else if(e.getKeyCode() == KeyEvent.VK_8 && !shiftFlag) {
			buttonHandler(8);
		}
		else if(e.getKeyCode() == KeyEvent.VK_9) {
			buttonHandler(9);
		}
		else if(e.getKeyCode() == KeyEvent.VK_EQUALS && shiftFlag) {
			buttonHandler(10);
		}
		else if(e.getKeyCode() == KeyEvent.VK_MINUS) {
			buttonHandler(11);
		}
		else if(e.getKeyCode() == KeyEvent.VK_8 && shiftFlag) {
			buttonHandler(12);
		}
		else if(e.getKeyCode() == KeyEvent.VK_SLASH) {
			buttonHandler(13);
		}
		else if(e.getKeyCode() == KeyEvent.VK_EQUALS) {
			buttonHandler(14);
		}
		else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			buttonHandler(15);
		}
	}

	/**
	 *	This is an override method according to KeyListener.
	 *	It checks when key released.
	 *	@param	e		KeyEvent of button
	 *	@return	Nothing.
	 */
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
			shiftFlag = false;
		}
	}

	/**
	 *	This main method instantiation a Calculator class.
	 *	And build a JFrame window to display.
	 *	@param	args	User parameters.
	 *	@return Nothing.
	 */
	public static void main(String[] args) {

		Calculator simpleCal = new Calculator();
		simpleCal.setTitle("Calculator");
		simpleCal.setSize(300, 360);
		simpleCal.setLocationRelativeTo(null);
		simpleCal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		simpleCal.setVisible(true);
	}
}