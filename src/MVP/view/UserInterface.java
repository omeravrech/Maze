package MVP.view;

import java.util.Observable;

import MVP.presenter.Properties;
/**
* <h1>UserInterface class</h1>
*<br> This is a helping class that extends observable<br>
* and implements runnable, it also holds a generic abstract method that passes objects <br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   28/09/2016 
*
*/
public abstract class UserInterface extends Observable implements Runnable
{
	protected Properties properties;
	
	public abstract void run();
	public abstract void result(Object result);
	//public abstract void updateActiveMaze(Maze3D arg);
	
	public void setProperties(Properties p)
	{
		this.properties = p;
		
	}
	public Properties getProperties() 
	{
		return this.properties;
	}
}
