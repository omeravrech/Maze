package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;


/**
* <h1>Display Cross Section Command Class</h1>
*<br> extends CommonCommand and execute the model's display_cross_section command.<br>
* it implements ICommand's doCommand method <br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/
public class Display_cross_section extends CommonCommand {

	public Display_cross_section(Model model, View view) {
		super(model, view);
	}

	@Override
	public void doCommand(String[] args) throws IOException 
	{	
		String asix = args[4];
		int line = Integer.parseInt(args[5]);
		String name = args[7];
		
		model.display_cross_section(asix, line, name);
	}

}
