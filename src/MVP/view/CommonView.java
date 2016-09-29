package MVP.view;

import java.util.Observable;
import java.util.Observer;

import MVP.presenter.Properties;


/**
* <h1>CommonView abstract Class</h1>
*<br>extends Observable and implements View and Observer<br>
* Holds an abstract methods (view's) and start new thread in Start method
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/
public abstract class CommonView extends Observable implements View, Observer
{
	protected UserInterface ui;
	protected String command;
	
	public CommonView (UserInterface ui)
	{
		this.ui = ui;
	}
	public void start()
	{
		Thread thread = new Thread(ui);
		thread.setName("UserInterface");
		thread.start();
	}
	
	public void setProperties (Properties p)
	{
		ui.setProperties(p);
	}
	
	public Properties getPropertiesFromXml()
	{
		return ui.getProperties();
	}

	abstract public void result(Object result);
	abstract public void update(Observable o, Object args);
}
