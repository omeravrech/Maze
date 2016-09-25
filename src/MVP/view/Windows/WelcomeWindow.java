package MVP.view.Windows;

public class WelcomeWindow extends BasicWindow
{
	public WelcomeWindow(int hight, int width) {
		super("Welcome Window", hight, width);
	}
	@Override
	void implementsWidgets()
	{
		shell.setText("TEST");
	}
	
	
	@Override
	public void print(String result)
	{
		// TODO Auto-generated method stub
		
	}
}
