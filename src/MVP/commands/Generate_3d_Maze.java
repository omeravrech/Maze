package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;

public class Generate_3d_Maze extends CommonCommand {

	public Generate_3d_Maze(Model model, View view) 
	{
		super(model, view);
	}

	@Override
	public void doCommand(String[] commands) throws IOException
	{
		String name = commands[3];
		int floors = Integer.valueOf(commands[4]);
		int rows = Integer.valueOf(commands[5]);
		int columns =  Integer.valueOf(commands[6]);
		model.generate_3d_maze(name, floors, rows, columns);
	}

}
