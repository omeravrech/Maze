package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;


/**
* <h1>CommonCommand Class</h1>
*<br> An abstract class that holds the Model and View.<br>
* it implements ICommand interface and holds and abstract method doCommand<br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/
public abstract class CommonCommand implements ICommand
{
	protected Model model;
	protected View view;
	
	/**
	 * Constructor
	 * @param model
	 * @param view
	 */
	public CommonCommand(Model model, View view) 
	{
		this.model = model;
		this.view = view;
	}


	@Override
	abstract public void doCommand(String[] args) throws IOException;

}
