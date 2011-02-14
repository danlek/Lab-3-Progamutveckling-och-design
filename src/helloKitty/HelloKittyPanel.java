package helloKitty;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class HelloKittyPanel extends JPanel
{
	private JButton[] numericalButtons;
	private JButton[] operatorButtons;
	private JLabel outPut;
	private JLabel helloKittyLabel;
	private ImageIcon helloKittyIcon;
	private HelloKittyListener HKL;
	private HelloKittyLogic HKLogic;
	private JPanel north, south, east, west, center, numeric, operators, dummyPanelLeft, dummyPanelRight;
	Font phont = new Font("Arial", Font.BOLD, 36);
	public HelloKittyPanel()
	{
		super(new BorderLayout());
		
		HKLogic = new HelloKittyLogic(this);
		HKL = new HelloKittyListener(HKLogic);
		outPut = new JLabel("Lol noob!");
		outPut.setFont(phont);
		north = new JPanel(new GridLayout(0,2));
		south = new JPanel();
		east = new JPanel();
		west = new JPanel();
		center = new JPanel();
		numeric = new JPanel(new GridLayout(0, 3, 3, 3));
		operators = new JPanel(new GridLayout(5, 1, 2, 2));
		dummyPanelLeft = new JPanel();
		dummyPanelRight = new JPanel();
		helloKittyIcon = new ImageIcon("C:\\temp\\Lab3\\Lab 3 Hello Kitty Miniräknare\\src\\Hello.png");
		helloKittyLabel = new JLabel(helloKittyIcon);

		this.add(north, BorderLayout.NORTH);
		this.add(west, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
		this.add(east, BorderLayout.EAST);
		this.add(south, BorderLayout.SOUTH);
		center.add(numeric);
		numeric.setBackground(java.awt.Color.PINK);
		center.add(operators);
		operators.setBackground(java.awt.Color.PINK);
		north.add(helloKittyLabel);
		north.add(outPut);
		north.setBackground(java.awt.Color.PINK);
		south.setBackground(java.awt.Color.PINK);
		east.setBackground(java.awt.Color.PINK);
		west.setBackground(java.awt.Color.PINK);
		center.setBackground(java.awt.Color.PINK);
		dummyPanelLeft.setBackground(java.awt.Color.PINK);
		dummyPanelRight.setBackground(java.awt.Color.PINK);
		numericalButtons = new JButton[12];
		createNumericButtons();
		operatorButtons = new JButton[5];
		createOperatorButtons();
		
	}
	public void createNumericButtons()
	{
		for(int i = 1; i < 12; i++)
		{
			
			if(i == 10)
			{
				numeric.add(dummyPanelLeft);
			}
			else if(i == 11)
			{
				//nollan
				numericalButtons[i] = new JButton("0");
				numericalButtons[i].addActionListener(HKL);
				numeric.add(numericalButtons[i]);
			}
			else
			{
				//alla vanliga knappar från 1 till 9
				numericalButtons[i] = new JButton(String.valueOf(i));
				numericalButtons[i].addActionListener(HKL);
				numeric.add(numericalButtons[i]);
			}
		}
		numeric.add(dummyPanelRight);
	}
	public void activateNumericButtons()
	{
		for(int i = 1; i < 10; i++)
		{
				numericalButtons[i].setEnabled(true);
		}
		numericalButtons[11].setEnabled(true);
	}
	public void inActivateNumericButtons()
	{
		for(int i = 1; i < 10; i++)
		{
				numericalButtons[i].setEnabled(false);
		}
		numericalButtons[11].setEnabled(false);
	}
	public void createOperatorButtons()
	{
		for(int i = 0; i < 5; i++)
		{
			operatorButtons[i] = new JButton();
			operatorButtons[i].addActionListener(HKL);
			operators.add(operatorButtons[i]);
			operatorButtons[i].setEnabled(false);
		}
		operatorButtons[0].setText("<-");
		operatorButtons[1].setText("+");
		operatorButtons[2].setText("-");
		operatorButtons[3].setText("*");
		operatorButtons[4].setText("=");
	}
	public void activateOperatorButtons()
	{
		for(int i = 1; i < 5; i++)
		{
			operatorButtons[i].setEnabled(true);
		}
	}
	public void activateLikaMedButton()
	{
		operatorButtons[4].setEnabled(true);
	}
	public void activateDeleteButton()
	{
		operatorButtons[0].setEnabled(true);
	}
	public void deActivateDeleteButton()
	{
		operatorButtons[0].setEnabled(false);
	}
	public void inActivateOperatorButtons()
	{
		for(int i = 1; i < 5; i++)
		{
			operatorButtons[i].setEnabled(false);
		}
	}
	public void setOutPutText(String s)
	{
		outPut.setText(s);
	}
	public String getOutPutText()
	{
		return outPut.getText();
	}
	
}
