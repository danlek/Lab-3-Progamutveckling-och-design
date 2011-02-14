package helloKitty;
import javax.swing.*;
public class HelloKittyFrame extends JFrame
{
	private HelloKittyPanel HKP;
	public HelloKittyFrame()
	{
		super("Hello Kitty Miniräknare!");
		this.setSize(350, 275);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		HKP = new HelloKittyPanel();
		this.add(HKP);
	}
	public static void main(String[] args) 
	{
		HelloKittyFrame HK = new HelloKittyFrame();

	}

}
