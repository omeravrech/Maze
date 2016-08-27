package Algorithms.Demo;

import Algorithms.MazeGenerator.GrowingTreeGenerator;
import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.MazeGenerator.RandomChoose;
import Algorithms.Search.BFS;
import Algorithms.Search.MazeAdapter;
import Algorithms.Search.Searchable;
import Algorithms.Search.Searcher;
import Algorithms.Search.Solution;

public class Demo {

	
	@SuppressWarnings("rawtypes")
	public static void run(Searcher algorithm, Searchable problem)
	{
		Solution<Position> sol = algorithm.search(problem);
		System.out.println(sol);
	}
	
	public static void main(String[] args)
	{
		Maze3D maze = new GrowingTreeGenerator(new RandomChoose()).generate(1, 5, 5);
		run(new BFS<Position>(), new MazeAdapter(maze));

	}

}
