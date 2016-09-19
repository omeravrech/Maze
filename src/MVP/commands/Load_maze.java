package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;

public class Load_maze extends CommonCommand {

	public Load_maze(Model model, View view) {
		super(model, view);
	}

	@Override
	public void doCommand(String[] args) throws IOException
	{
		model.load(args[2], args[3]);
	}

}
