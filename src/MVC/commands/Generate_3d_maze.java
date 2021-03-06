package MVC.commands;

import java.io.IOException;

import MVC.model.Model;
import MVC.view.View;

/**
 * Generates a 3d maze (with GrowingTree algorithm) from the user's parameters
 */
public class Generate_3d_maze extends CommonCommand
{
	/**
	 * Constructor
	 * @param view
	 * @param model
	 */
	public Generate_3d_maze(View view, Model model) 
	{
		super(view, model);
	}
	
	@Override
	public void doCommand(String[] commands) throws IOException
	{
		String name = commands[0];
		int floors = Integer.valueOf(commands[1]);
		int rows = Integer.valueOf(commands[2]);
		int columns =  Integer.valueOf(commands[3]);
		
		if ((floors > 0) && (rows > 0) && (columns > 0) && (name != null))
		{
			view.notify("Start to calculation your request...");
			model.generate_3d_maze(name, floors, rows, columns);
		}
		else
			view.notify("generate_3d_maze <maze name> <floors> <rows> <columns>");
	}

}
