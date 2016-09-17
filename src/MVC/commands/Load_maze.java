package MVC.commands;

import java.io.File;
import java.io.IOException;

import MVC.model.Model;
import MVC.view.View;


/**
 * Loads the maze from a file (binary to 3d maze)
 */
public class Load_maze extends CommonCommand
{
	/**
	 * Constructor
	 * @param view
	 * @param model
	 */
	public Load_maze(View view, Model model) 
	{
		super(view, model);
	}
	
	@Override
	public void doCommand(String[] commands) throws IOException
	{
		String path = commands[0].substring(0, commands[0].lastIndexOf("\\"));
		String name = commands[0].substring(commands[0].lastIndexOf("\\")+1);
		name = name.substring(0,name.lastIndexOf("."));
		File file = new File(path,name + ".maz");
		if (!file.exists())
			view.notify("File does not exist");
		else
			model.load(name, path);
	}

}
