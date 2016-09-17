package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;

public class Generate_3d_maze extends CommonCommand {

	public Generate_3d_maze(Model model, View view) 
	{
		super(model, view);
	}

	@Override
	public void doCommand(String[] commands) throws IOException
	{
		String name = commands[0];
		int floors = Integer.valueOf(commands[1]);
		int rows = Integer.valueOf(commands[2]);
		int columns =  Integer.valueOf(commands[3]);
		
		if ((floors > 0) && (rows > 0) && (columns > 0) && (name != null))
			model.generate_3d_maze(name, floors, rows, columns);
		
		else
			view.notify("generate_3d_maze <maze name> <floors> <rows> <columns>");
	}

}
