package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;


/**
* <h1>Display Solution Command Class</h1>
*<br> extends CommonCommand and execute the model's display_solution command.<br>
* it implements ICommand's doCommand method <br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/
public class Display_solution extends CommonCommand {

	public Display_solution(Model model, View view) {
		super(model, view);
	}

	@Override
	public void doCommand(String[] args) throws IOException {
		String name = args[2];
		if (name == "" || name == " " || name == null)
			view.result("Invalid name");
		else
			model.display_solution(name);

	}

}
