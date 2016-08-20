package algorithms.search;

import java.util.HashSet;

import algorithms.MazeGenerators.GrowingTreeGenerator;
import algorithms.MazeGenerators.Maze3D;
import algorithms.MazeGenerators.RandomChoose;

public class Demo {

	public static void RunSearch(SearchAlgorithm algorithm, Searchable problem)
	{
		System.out.println("TEST");
		@SuppressWarnings("rawtypes")
		HashSet<State> result = algorithm.search(problem);
		System.out.println(result);
	}
	public static void main(String[] args) {
		Maze3D maze = new GrowingTreeGenerator(new RandomChoose()).generate(1, 10, 10);
		System.out.println(maze);
		RunSearch(new BFS(), new MazeSearchAdapter(maze));
	}

}
