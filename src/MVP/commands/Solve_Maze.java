package MVP.commands;

import java.io.IOException;

import Algorithms.MazeGenerator.Position;
import Algorithms.Search.BFS;
import Algorithms.Search.DFS;
import Algorithms.Search.Searcher;
import MVP.model.Model;
import MVP.view.View;

/**
* <h1>Solve Command Class</h1>
*<br> extends CommonCommand and execute the model's solve command.<br>
* it implements ICommand's doCommand method <br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/
public class Solve_Maze extends CommonCommand {

	public Solve_Maze(Model model, View view) {
		super(model, view);
	}

	@Override
	public void doCommand(String[] args) throws IOException {
		String name = args[1];
		String algorithm = args[2];
		Searcher<Position> searcher;
		
		
		if (algorithm.equalsIgnoreCase("DFS"))
			searcher = new DFS<Position>();
		else if (algorithm.equalsIgnoreCase("BFS"))
			searcher = new BFS<Position>();
		else
			searcher = null;
		
		if (searcher != null)
			model.solve(name, searcher, null);
		else
			view.result("Invalid algorithm");
	}

}
