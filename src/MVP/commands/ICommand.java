package MVP.commands;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
* <h1>ICommand interface</h1>
*<br> Has doCommand function<br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/

public interface ICommand 
{
	public void doCommand(String[] args) throws IOException, InterruptedException, ExecutionException;
}
