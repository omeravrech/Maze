package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;


/**
* <h1>Save Maze Command Class</h1>
*<br> extends CommonCommand and execute the model's save_maze command.<br>
* it implements ICommand's doCommand method <br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/
public class Save_maze extends CommonCommand {

	public Save_maze(Model model, View view) {
		super(model, view);
	}

	@Override
	public void doCommand(String[] args) throws IOException
	{
				model.save(args[2], args[3]);
	}

}
