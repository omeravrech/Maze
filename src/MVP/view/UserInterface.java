package MVP.view;

import java.util.Observable;
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
	public abstract void run();
	public abstract void result(Object result);
	//public abstract void updateActiveMaze(Maze3D arg);
}
