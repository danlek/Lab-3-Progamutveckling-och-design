package helloKitty;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class HelloKittyListener implements java.awt.event.ActionListener
{
	private HelloKittyLogic HKL;
	private JButton randomKnappTryck;
	public HelloKittyListener(HelloKittyLogic HKL)
	{
		this.HKL = HKL;
		randomKnappTryck = new JButton();
	}
	public void actionPerformed(ActionEvent e)
	{
		randomKnappTryck = (JButton) e.getSource();

		if(randomKnappTryck.getText() == "\u2190")
		{
			HKL.backa();
		}
		else
		{
			HKL.phases(randomKnappTryck.getText());
		}
	}
}
