package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;


/**
* <h1>Dir Command Class</h1>
*<br> extends CommonCommand and execute the model's dir command.<br>
* it implements ICommand's method doCommand<br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/
public class Dir extends CommonCommand
{

	public Dir(Model model, View view) 
	{
		super(model, view);
	}

	@Override
	public void doCommand(String[] args) throws IOException 
	{
		String path = args[1];
		model.dir(path);
		
	}

}
