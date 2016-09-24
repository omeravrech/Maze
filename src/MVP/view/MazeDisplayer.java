package MVP.view;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.Search.Solution;

public abstract class MazeDisplayer extends Canvas
{
	
	int floors,rows,columns;
	protected CurrentPosition startPosition;
	protected CurrentPosition goalPosition;
	protected CurrentPosition currentPosition;
	protected Maze3D maze;
	protected CurrentPosition checker;
	protected Solution<Position> solutions;
	protected boolean close = false;
	
	
	public MazeDisplayer(Composite parent, int style) 
	{
		super(parent, style);
		new Maze3D(1, 5, 5);
		solutions = new Solution<Position>();
	}
	
	
	public abstract  void setCharacterPosition(Maze3D maze);

	public abstract void moveCharacterUp();

	public abstract  void moveCharacterDown();

	public abstract  void moveCharacterLeft();

	public  abstract void moveCharacterRight();

	public abstract void moveCharacterForward();

	public abstract void moveCharacterBackward();
	
	
	public void setCanvas(Object o)
	{
		if(maze.getClass() == Maze3D.class)
		{
		this.maze = (Maze3D)o;
		this.floors = maze.getFloors();
		this.rows = maze.getRows();
		this.columns = maze.getColumns();
		startPosition = new CurrentPosition(maze.getStartPosition());
		goalPosition = new CurrentPosition(maze.getGoalPosition());
		currentPosition = new CurrentPosition(maze.getStartPosition());
		
		}
		if(o.getClass() == Position.class){
			System.out.println("position");
			Position position = (Position)o;
			currentPosition.changeLocation(position.floor() - currentPosition.floor(),
					position.row() - currentPosition.row(),
					position.column() - currentPosition.column());
			
			System.out.println(maze.toString());

		}
		
		
		}
}
