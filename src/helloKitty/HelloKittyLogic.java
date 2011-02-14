package helloKitty;

public class HelloKittyLogic 
{
	private boolean redo = false;
	private HelloKittyPanel HKP;
	private int phase = 1;
	private String outPut = "";
	private int tal1, tal2;
	public HelloKittyLogic(HelloKittyPanel HKP)
	{
		this.HKP = HKP;
	}
	public void phases(String Knapp)
	{
		outPut += Knapp;
		redo = false;
		whichPhase();	
	}
	public void whichPhase()
	{
		if(phase == 1)
		{
			phase1(redo);
		}
		else if(phase == 2)
		{
			phase2(redo);
		}
		else if(phase == 3)
		{
			phase3(redo);
		}
		else if(phase == 4)
		{
			phase4();
		}
	}
	public void backa()
	{
		int lastPosition;
		String temp = "";
		lastPosition = outPut.length();
		
		for(int i = 0; i < lastPosition - 1; i++)
		{
			temp += outPut.charAt(i);
		}
		outPut = temp;
		HKP.setOutPutText(outPut);
		temp = "";
		phase--;
		redo = true;
		whichPhase();
	}
	public void phase1(boolean redo)
	{
		if(redo == false)
		{
			HKP.setOutPutText(outPut);
			HKP.inActivateNumericButtons();
			HKP.activateOperatorButtons();
			phase = 2;
			HKP.activateDeleteButton();
		}
		else if(redo == true)
		{
			HKP.activateNumericButtons();
			HKP.inActivateOperatorButtons();
		}
	}
	public void phase2(boolean redo)
	{
		if(redo == false)
		{
			HKP.setOutPutText(outPut);
			HKP.activateNumericButtons();
			HKP.inActivateOperatorButtons();
			HKP.activateLikaMedButton();
			phase = 3;
		}
		else if(redo == true)
		{
			HKP.inActivateNumericButtons();
			HKP.activateOperatorButtons();
		}
	}
	public void phase3(boolean redo)
	{
		if(redo == false)
		{
			HKP.setOutPutText(outPut);
			HKP.inActivateNumericButtons();
			HKP.inActivateOperatorButtons();
			HKP.activateLikaMedButton();
			phase = 4;
		}
		else if(redo == true)
		{
			HKP.activateNumericButtons();
			HKP.inActivateOperatorButtons();
		}
	}
	public void phase4()
	{
		if(outPut.charAt(1) == '+')
		{
			tal1 = Character.getNumericValue(outPut.charAt(0));
			tal2 = Character.getNumericValue(outPut.charAt(2));
			outPut += (tal1 + tal2);
			HKP.setOutPutText(outPut);
			phase = 1;
			outPut = "";
			HKP.activateNumericButtons();
			HKP.inActivateOperatorButtons();
			
		}
		else if(outPut.charAt(1) == '-')
		{
			tal1 = Character.getNumericValue(outPut.charAt(0));
			tal2 = Character.getNumericValue(outPut.charAt(2));
			outPut += (tal1 - tal2);
			HKP.setOutPutText(outPut);
			phase = 1;
			outPut = "";
			HKP.activateNumericButtons();
			HKP.inActivateOperatorButtons();
			
		}
		else if(outPut.charAt(1) == '*')
		{
			tal1 = Character.getNumericValue(outPut.charAt(0));
			tal2 = Character.getNumericValue(outPut.charAt(2));
			outPut += (tal1 * tal2);
			HKP.setOutPutText(outPut);
			phase = 1;
			outPut = "";
			HKP.activateNumericButtons();
			HKP.inActivateOperatorButtons();
			
		}
		HKP.deActivateDeleteButton();
	}
}
