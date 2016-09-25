package MVP.view;

import java.util.Observable;
import java.util.Observer;

public abstract class CommonView extends Observable implements View, Observer
{
	protected UserInterface ui;
	protected String command;
	
	public CommonView (UserInterface ui)
	{
		this.ui = ui;
	}
	abstract public void Result(String result);
	abstract public void update(Observable o, Object args);
	public void start()
	{
		Thread thread = new Thread(ui);
		thread.setName("UserInterface");
		thread.start();
	}
}
