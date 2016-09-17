package MVC.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


/**
* <h1>MyView</h1>
*<br> This class will display to the user result of the<br>
*commands and also receive the user's input and handle it
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   15/09/2016 
*/
public class MyView extends CommonView
{
	public MyView(BufferedReader in, PrintWriter out) {
		this.cli = new CLI(in, out, this);
	}
	/**
	 * This function calls cli's start function
	 * @see MVC.view.CLI
	 */
	@Override
	public void start() {
		cli.start();
	}

	@Override
	public void operationCommand(String command, String input) throws IOException
	{
		controller.operationCommand(command, input);
	}

	@Override
	public void setCommands() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notify(String message)
	{
		cli.print(message.toString());
	}

	
	public void exit()
	{
		cli.exit();
	}
	
}
