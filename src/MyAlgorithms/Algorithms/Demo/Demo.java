package MyAlgorithms.Algorithms.Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import MyAlgorithms.Algorithms.MazeGenerator.GrowingTreeGenerator;
import MyAlgorithms.Algorithms.MazeGenerator.Maze3D;
import MyAlgorithms.Algorithms.MazeGenerator.Position;
import MyAlgorithms.Algorithms.MazeGenerator.RandomChoose;
import MyAlgorithms.Algorithms.Search.BFS;
import MyAlgorithms.Algorithms.Search.DFS;
import MyAlgorithms.Algorithms.Search.MazeAdapter;
import MyAlgorithms.Algorithms.Search.Searchable;
import MyAlgorithms.Algorithms.Search.Searcher;
import MyAlgorithms.Algorithms.Search.Solution;
import MyAlgorithms.io.MyCompressorOutputStream;
import MyAlgorithms.io.MyDecompressorInputStream;

public class Demo {


	public static void run(Searcher<Position> algorithm, Searchable<Position> problem)
	{
		System.out.println("\n\nAlgorithm:" + algorithm.getClass());
		Solution<Position> sol = algorithm.search(problem);
		System.out.println(sol);
		System.out.println("Number Of Nodes: " + algorithm.getNumberOfNodesEvaluated());
	}
	
	public static void main(String[] args)
	{		
		Maze3D maze = new GrowingTreeGenerator(new RandomChoose()).generate(1, 13, 13);
		System.out.println(maze);
		run(new BFS<Position>(), new MazeAdapter(maze));
		run(new DFS<Position>(), new MazeAdapter(maze));

		byte[] outArr = maze.toByteArray();
		byte[] inArr = new byte[outArr.length];
		//*/
		try
		{
			OutputStream out=new MyCompressorOutputStream(new FileOutputStream("d:\\maze.dat"));
			out.write(outArr);
			out.flush();
			out.close();
			InputStream in=new MyDecompressorInputStream(new FileInputStream("d:\\maze.dat"));
			in.read(inArr);
			in.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Maze3D maze2 = new Maze3D(inArr);
		System.out.println(maze2);
	}

}
