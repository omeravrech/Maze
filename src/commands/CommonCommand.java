package commands;

import java.io.IOException;

import model.Model;
import view.View;

/**
* <h1>CommonCommand abstract class</h1>
*<br> an abstract class that contain the data members<br>
*of each command (will receive them by inheritance) <br>
*and contain an abstract method doCommand that will be implemented <br>
*by each command class
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   15/09/2016 
*/
public abstract class CommonCommand implements ICommand 
{
	protected Model model;
	protected View view;

	/**
	 * Constructor
	 * @param view
	 * @param model
	 */
	public CommonCommand(View view, Model model)
	{
		this.model = model;
		this.view = view;
	}
	
	abstract public void doCommand(String[] args) throws IOException;
	
}
