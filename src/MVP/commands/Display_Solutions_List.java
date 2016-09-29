package MVP.commands;

import java.io.IOException;

import MVP.commands.CommonCommand;
import MVP.model.Model;
import MVP.view.View;


/**
* <h1>Display Solution List Command Class</h1>
*<br> extends CommonCommand and execute the model's display_solution_list command.<br>
* it implements ICommand's doCommand method <br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/
public class Display_Solutions_List extends CommonCommand
{

	public Display_Solutions_List(Model model, View view)
	{
		super(model, view);
	}

	@Override
	public void doCommand(String[] args) throws IOException
	{
		model.display_solution_list();
	}

}
