package commands;

import java.io.IOException;

import Algorithms.MazeGenerator.Position;
import Algorithms.Search.Solution;
import model.Model;
import view.View;

/**
 * This command will go to the HashMap of the solutions and send to the view <br>
 * the wanted solution
 */
public class Display_solution extends CommonCommand
{
		
	/**
	 * Constructor
	 * @param view
	 * @param model
	 */
	public Display_solution(View view, Model model) {
		super(view, model);
	}

	@Override
	public void doCommand(String[] args) throws IOException
	{
		if (args[0] == null || args[0].isEmpty())
			view.notify("display_solution [name]");
		else
		{
			Solution<Position> solution = model.display_solution(args[0]);
			if (solution == null)
				view.notify("Maze does not exist");
			else
				view.notify(solution.toString());
		}
	}
	
	
	
	/*public void doCommand(String[] commands) throws IOException
	{
		String name = commands[1];
		if ((name != null) || (name != "") || (name != " "))
			model.display_solution(name);
		else
			throw new IOException("display_solution <maze name>");
	}*/

}
