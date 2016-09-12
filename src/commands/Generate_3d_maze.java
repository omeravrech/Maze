package commands;

import java.io.IOException;

import model.Model;
import view.View;

public class Generate_3d_maze extends CommonCommand
{

	public Generate_3d_maze(View view, Model model) 
	{
		super(view, model);
	}
	
	@Override
	public void doCommand(String[] commands) throws IOException
	{
		String name = commands[1];
		int floors = Integer.valueOf(commands[2]);
		int rows = Integer.valueOf(commands[3]);
		int columns =  Integer.valueOf(commands[4]);
		
		if ((floors > 0) && (rows > 0) && (columns > 0) && (name != null))
			model.generate_maze(name, floors, rows, columns);
		else
			throw new IOException("Bad values.");
	}

}
