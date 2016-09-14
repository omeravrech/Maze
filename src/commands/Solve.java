package commands;

import java.io.IOException;

import Algorithms.MazeGenerator.Position;
import Algorithms.Search.BFS;
import Algorithms.Search.DFS;
import Algorithms.Search.Searcher;
import model.Model;
import view.View;

public class Solve extends CommonCommand
{

	public Solve(View view, Model model) 
	{
		super(view, model);
	}
	
	@Override
	public void doCommand(String[] commands) throws IOException
	{
		
		String name = commands[0];
		String algorithm = commands[1];
		if (name.isEmpty() || name.equals("") || algorithm.isEmpty() || algorithm.equals(""))			throw new IOException ("solve [name] [algorithm]");
			
		else
		{
			Searcher<Position> searcher;
			if (algorithm.equals("BFS"))
				searcher = new BFS<Position>();
			else if (algorithm.equals("DFS"))
				searcher = new DFS<Position>();
			else
				throw new IOException ("Algorithm not found");
			
			model.solve(name, searcher);
		}
		
	}

}
