package Algorithms.Demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import Algorithms.MazeGenerator.GrowingTreeGenerator;
import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.MazeGenerator.RandomChoose;
import Algorithms.Search.BFS;
import Algorithms.Search.DFS;
import Algorithms.Search.MazeAdapter;
import Algorithms.Search.Searchable;
import Algorithms.Search.Searcher;
import Algorithms.Search.Solution;
import io.MyCompressorOutputStream;

public class Demo {


	public static void run(Searcher<Position> algorithm, Searchable<Position> problem)
	{
		System.out.println("\n\nAlgorithm:" + algorithm.getClass());
		Solution<Position> sol = algorithm.search(problem);
		System.out.println(sol);
		System.out.println("Number Of Nodes: " + algorithm.getNumberOfNodesEvaluated());
	}
	
	public static void main(String[] args)
	{		Maze3D maze = new GrowingTreeGenerator(new RandomChoose()).generate(1, 25, 25);
		System.out.println(maze);
		run(new BFS<Position>(), new MazeAdapter(maze));
		run(new DFS<Position>(), new MazeAdapter(maze));
		
		try
		{
			OutputStream out=new MyCompressorOutputStream(new FileOutputStream("maze.dat"));
			out.write(maze.toByteArray());
			out.flush();
			out.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
