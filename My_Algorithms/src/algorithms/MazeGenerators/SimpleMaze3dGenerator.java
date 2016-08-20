package algorithms.MazeGenerators;

import java.util.Random;

public class SimpleMaze3dGenerator extends AbstractMazeGenerator
{
	public Maze3D generate(int floors, int row, int column)
	{
		if ((floors <= 0) || (row<=0) || ( column<=0))
			throw new IndexOutOfBoundsException("The requested size " + floors + " x " + row + " x " + column + " is invalid ");
		
		Maze3D maze = new Maze3D(floors,row,column);
		Position end = null ;
		Random rand = new Random();
		maze.setStartPosition(new Position(1, 2*rand.nextInt(row-1)+1, 2*rand.nextInt(column-1)+1));
		
		do
		{
			end = new Position(2*floors-1, 2*rand.nextInt(row)+1, 2*rand.nextInt(column)+1);
		} while (end.equals(maze.getStartPosition()));
	maze.setGoalPosition(end);
		Position pos = maze.getStartPosition();
	
		for (Position next = maze.getStartPosition(); !pos.equals(maze.getGoalPosition()); pos = next)
		{
			if (pos.column() > end.column())
				next = new Position(pos.floor(),pos.row(),pos.column()-2);
			else if (pos.column() < end.column())
				next = new Position(pos.floor(),pos.row(),pos.column()+2);
			else
				if (pos.row() > end.row())
					next = new Position(pos.floor(),pos.row()-2,pos.column());
				else if (pos.row() < end.row())
						next = new Position(pos.floor(),pos.row()+2,pos.column());
				else
					next = new Position(pos.floor()+2,pos.row(),pos.column());

			maze.wreckingBall(pos, next);
		}
		return maze;
	}
}
