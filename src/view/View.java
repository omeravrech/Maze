package view;

import java.io.IOException;
/**
* <h1>View interface</h1>
*<br> this interface contains every function that<br>
*MyView must have
*@see view.CommonView
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   15/09/2016 
*/
public interface View 
{
	
	public void start();
	public void operationCommand(String command, String input) throws IOException;
	public void setCommands();
	public void notify(String message);
	public void exit();
}
