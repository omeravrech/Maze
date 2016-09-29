package MVP.commands;

import java.io.IOException;

import Algorithms.MazeGenerator.Position;
import Algorithms.Search.BFS;
import Algorithms.Search.DFS;
import Algorithms.Search.Searcher;
import MVP.model.Model;
import MVP.view.View;

/**
* <h1>Solve By New PositionList Command Class</h1>
*<br> extends CommonCommand and execute the model's solve command.<br>
* This command is important because it needs to handle the situation that <br>
* user moved after generating the maze and the solution will need new current position<br>
* it implements ICommand's doCommand method <br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/
public class Solve_By_New_Poistion extends CommonCommand {

	public Solve_By_New_Poistion(Model model, View view) {
		super(model, view);
	}

	@Override
	public void doCommand(String[] args) throws IOException {
		String name = args[1];
		String algorithm = args[2];
		Searcher<Position> searcher;
		
		int floor = Integer.parseInt(args[4]);
		int row = Integer.parseInt(args[5]);
		int col = Integer.parseInt(args[6]);
		
		if ((floor <= 0) || (row <= 0) || (col <= 0))
		{
			throw new RuntimeException("Invalid data");
		}
		else
		{
			Position pos = new Position(floor, row, col);
		
			if (algorithm.equalsIgnoreCase("DFS"))
				searcher = new DFS<Position>();
			else if (algorithm.equalsIgnoreCase("BFS"))
				searcher = new BFS<Position>();
			else
				searcher = null;
			
			if (searcher != null)
				model.solve(name, searcher, pos);
			else
				view.result("Invalid algorithm");
		}
		
	}

}
