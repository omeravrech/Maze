package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;


/**
* <h1>Display Command Class</h1>
*<br> extends CommonCommand and execute the model's display command.<br>
* it implements ICommand's doCommand method <br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/
public class Display extends CommonCommand {

	public Display(Model model, View view) {
		super(model, view);
	}

	@Override
	public void doCommand(String[] args) throws IOException
	{
		String name = args[2];
		model.getMaze(name);
	}

}
