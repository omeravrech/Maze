package commands;

import java.io.IOException;

import model.Model;
import view.View;

/**
 * Saves the maze to file
 */
public class Save_maze extends CommonCommand
{
	/**
	 * Constructor
	 * @param view
	 * @param model
	 */
	public Save_maze(View view, Model model) 
	{
		super(view, model);
	}
	
	@Override
	public void doCommand(String[] commands) throws IOException
	{
		String name = commands[0];
		String path = commands[1];
		if (name.equals("") || name.isEmpty() || path.equals("") || path.isEmpty())
			throw new IOException("save [name] [path]");
		else
			model.save(name, path);
	}

}
