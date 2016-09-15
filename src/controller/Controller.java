package controller;

import java.io.IOException;
import java.util.HashMap;

import commands.ICommand;
/**
* <h1>Controller interface</h1>
*<br> this interface receive the command and its input (if exist)<br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   15/09/2016 
*/
public interface Controller
{
	HashMap<String, ICommand> getCommands();
	public void operationCommand(String command, String input) throws IOException;
	void notify(String message);
}
