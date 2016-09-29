package Algorithms.Search;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import Algorithms.MazeGenerator.GrowingTreeGenerator;
import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Maze3dGenerator;
import Algorithms.MazeGenerator.Position;
import Algorithms.MazeGenerator.RandomChoose;

public class BfsTest 
{

	@Test
	public void test() 
	{
	
			
			BFS<Position> searcher = new BFS<Position>(); //// create BFS searcher
			Maze3dGenerator generator = new GrowingTreeGenerator(new RandomChoose());
			Solution<Position> solution;
			MazeAdapter ma;
			
			// First test: Maze in large scales
			Maze3D maze1 = generator.generate(20, 20, 20);
			ma = new MazeAdapter(maze1);
			solution = searcher.search(ma);
			assertNotNull(solution);
			
			// Test 3 - very small maze
//			Maze3D maze2 = generator.generate(1,5,5);
//			ma = new MazeAdapter(maze2);
//			solution = searcher.search(ma);
//			 assertNotNull(solution);
		}
	
}
