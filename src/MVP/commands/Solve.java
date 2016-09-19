package MVP.commands;

import java.io.IOException;

import Algorithms.MazeGenerator.Position;
import Algorithms.Search.BFS;
import Algorithms.Search.DFS;
import Algorithms.Search.Searcher;
import MVP.model.Model;
import MVP.view.View;

public class Solve extends CommonCommand {

	public Solve(Model model, View view) {
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
			model.solve(name, searcher);
		else
			view.Result("Invalid algorithm");
		
	}

}
