package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;

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
