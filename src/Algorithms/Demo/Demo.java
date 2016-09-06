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
		/*/Maze3D maze = new GrowingTreeGenerator(new RandomChoose()).generate(1, 3, 3);
		System.out.println(maze);
		//run(new BFS<Position>(), new MazeAdapter(maze));
		//run(new DFS<Position>(), new MazeAdapter(maze));
		
		//*/
		
		 
		byte[] outArr = {1,3,3,1,5,5,1,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,0,1,1,1,1,0,1,0,1,1,0,0,2,0,0,1,1,0,1,0,1,0,1,1,0,1,0,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
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
		Maze3D maze = new Maze3D(inArr);
		System.out.println(maze);
	}

}
