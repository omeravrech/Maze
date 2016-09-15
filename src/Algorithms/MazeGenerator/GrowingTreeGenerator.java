package Algorithms.MazeGenerator;

import java.util.ArrayList;
import java.util.Random;


/**
* <h1>GrowingTreeGenerator</h1>
* An algorithm that create a new maze by following the "Growing Tree Algorithm"
* See: {@link http://weblog.jamisbuck.org/2011/1/27/maze-generation-growing-tree-algorithm}
* 
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   27/08/2016
*
*/
public class GrowingTreeGenerator extends AbstractMazeGenerator {

	private AbstractNodeChoose<Position> chooseMethod;
	private boolean status;
	
	public GrowingTreeGenerator(AbstractNodeChoose<Position> chooseMethod)
	{
		 this.chooseMethod = chooseMethod;
		 this.status = false;
	}
	
	@Override
	public Maze3D generate(int floors, int rows, int columns)
	{
		if ((floors <= 0) || (rows<=0) || ( columns<=0))
			throw new IndexOutOfBoundsException("The requested size " + floors + " x " + rows + " x " + columns + " is invalid ");
		if (chooseMethod == null)
			throw new IndexOutOfBoundsException("chooseMethod = " + this.chooseMethod);
		
		Maze3D maze = new Maze3D(floors, rows, columns);
		Random rand = new Random();
		Position pos = null;
		Position next = null;
		ArrayList<Position> visited = new ArrayList<Position>();
		status = true;

		maze.setStartPosition(new Position(1, 2*rand.nextInt(rows-1)+1, 2*rand.nextInt(columns-1)+1));
		
		visited.clear();
		visited.add(maze.getStartPosition());
		
		while (!visited.isEmpty() && (status))
		{
			do //choose new node by choose method
			{
				
				pos = this.chooseMethod.choose(visited);
				
			} while(maze.positionStatus(pos) == Maze3D.WALL);
			
			
			ArrayList<Position>directions = maze.nextWall(pos);
			
			if (directions.isEmpty())
			{
				visited.remove(pos);
				visited.trimToSize();
			}
			else
			{
				next = chooseMethod.choose(directions);
				
				for (Position p : directions) {
					if (!visited.contains(p))
						visited.add(p);
				}
				maze.wreckingBall(pos, next);
			}
		}
		
		maze.setGoalPosition(new Position(2*floors-1, 2*rand.nextInt(rows)+1, 2*rand.nextInt(columns)+1));
		status = false;
		return maze;
	}
	
	public void stop()
	{
		status = false;
	}
		
}
