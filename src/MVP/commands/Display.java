package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;

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
