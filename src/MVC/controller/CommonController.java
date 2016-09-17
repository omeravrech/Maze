package MVC.controller;

import java.io.IOException;
import java.util.HashMap;

import MVC.commands.ICommand;
import MVC.model.Model;
import MVC.view.View;
/**
* <h1>CommonController abstract class</h1>
*<br> This class implements the controller interface,<br>
*holds the data members and sign abstract functions
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   15/09/2016 
*/
public abstract class CommonController implements Controller {

	protected Model model;
	protected View view;
	protected HashMap<String,ICommand> commands;
	
	/**
	 * Constructor
	 * @param view
	 * @param model
	 */
	public CommonController(View view, Model model)
	{
		this.view = view;
		this.model = model;
	}

	public void setCommands(HashMap<String, ICommand> commands) { this.commands = commands; }
	public HashMap<String, ICommand> getCommands() { return this.commands; }
	abstract protected void InitHashMap();
	abstract public void operationCommand(String command, String input) throws IOException;
	abstract public void notify(String message);
}
