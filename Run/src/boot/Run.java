package boot;


import java.util.ArrayList;

import algorithms.MazeGenerators.GrowingTreeGenerator;
import algorithms.MazeGenerators.Maze3D;
import algorithms.MazeGenerators.Maze3dGenerator;
import algorithms.MazeGenerators.Position;
import algorithms.MazeGenerators.RandomChoose;
import algorithms.MazeGenerators.SimpleMaze3dGenerator;

public class Run {
	private static void testMazeGenerator(Maze3dGenerator mg){
		
		int[] size = {1,17,17};
		
		System.out.println("The Algorithn running for:" + mg.getClass().getName());
		//prints the time it takes the algorithm to run
		System.out.println("Running time: " + mg.measureAlgorithmTime(size[0],size[1],size[2]) + " ms.");
		// generate another 3d maze
		Maze3D maze=mg.generate(size[0],size[1],size[2]);
		System.out.println(maze);
		
		Position p=maze.getStartPosition();
		// print the position
		System.out.println("Starting Poistion: "+p); // format "{x,y,z}"
		// get all the possible moves from a position
		ArrayList<Position> moves = maze.getPossibleMoves(p);
		// print the moves
		System.out.println("Possible Moves from point "+p+" are:");
		for(Position move : moves)
			System.out.println(move);
		// prints the maze exit position
		System.out.println("Goal Position: " + maze.getGoalPosition());
		
		try{
			// get 2d cross sections of the 3d maze
			System.out.println("Axis X:\n" + printMat(maze.getCrossSectionByX(2)));
			System.out.println("Axis Y:\n" + printMat(maze.getCrossSectionByY(5)));
			System.out.println("Axis Z:\n" + printMat(maze.getCrossSectionByZ(0)));
			// TODO add code to print the array
			// this should throw an exception!
			maze.getCrossSectionByX(-1);
			} catch (IndexOutOfBoundsException e){
			System.out.println("good!");
			}
		
	}
	
	public static void main(String[] args) {
			testMazeGenerator(new SimpleMaze3dGenerator());
			testMazeGenerator(new GrowingTreeGenerator(new RandomChoose()));
			
	}
	
	public static String printMat(int[][] mat)
	{
			String out = "";
			
			for (int i=0; i < mat.length; i++)
			{
				for (int j=0; j < mat[i].length; j++)
				{
					out += mat[i][j] + " ";
				}
				out += "\n";
			}
			return out;
	}
	
}
	
