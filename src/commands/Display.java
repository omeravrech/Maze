package commands;

import java.io.IOException;

import Algorithms.MazeGenerator.Maze3D;
import model.Model;
import view.View;

public class Display extends CommonCommand
{
	
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
