package MVC.commands;

import java.io.IOException;
/**
* <h1>ICommand interface</h1>
*<br> Make sure each command has the correct doCommand function<br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   15/09/2016 
*/
public interface ICommand 
{
	public void doCommand(String[] args) throws IOException;
}
