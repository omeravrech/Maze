package Algorithms.Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import io.MyDecompressorInputStream;

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
		byte[] inArr = null;
		//*/
		try
		{
			OutputStream out=new MyCompressorOutputStream(new FileOutputStream("d:\\maze.dat"));
			System.out.println(outArr.length);
			out.write(outArr.length/127);
			out.write(outArr.length%127);
			out.write(outArr);
			out.flush();
			out.close();
			InputStream in=new MyDecompressorInputStream(new FileInputStream("d:\\maze.dat"));
			inArr = new byte[in.read() * 127 + in.read()];
			System.out.println(inArr.length);
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
