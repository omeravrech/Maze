package MVC.commands;

import java.io.IOException;

import Algorithms.MazeGenerator.Maze3D;
import MVC.model.Model;
import MVC.view.View;

/**
 * receives the name of the maze and return the 3d maze (toString method) so the <br>
 * view can print it to the user
 */
public class Display extends CommonCommand
{
	/**
	 * Constructor
	 * @param view
	 * @param model
	 */
	public Display(View view, Model model) {
		super(view,model);
	}


	@Override
	public void doCommand(String[] args) throws IOException
	{
		if (args[0] == null || args[0].isEmpty())
			throw new IOException("display [name]");
		else
		{
			Maze3D maze = model.display(args[0]);
			if (maze == null)
				throw new IOException("Maze does not exist");
			else
				view.notify(maze.toString());
		}
	}

}
