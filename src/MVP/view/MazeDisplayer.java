package MVP.view;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.Search.State;

public abstract class MazeDisplayer extends Canvas
{
	
	int floors,rows,columns;
	protected Position startPosition;
	protected Position goalPosition;
	protected Position curentPosition;
	protected Maze3D maze;
	protected Position checker;
	protected ArrayList<State<Position>> solutions;
	protected boolean close = false;
	
	
	public MazeDisplayer(Composite parent, int style) 
	{
		super(parent, style);
		new Maze3D(1, 5, 5);
		solutions =new ArrayList<>();
	}
	
	public void setCanvas(Object o)
	{
		System.out.println("fff");
		if(maze.getClass() == Maze3D.class)
		{
		this.maze = (Maze3D)o;
		this.floors = maze.getFloors();
		this.rows = maze.getRows();
		this.columns = maze.getColumns();
		startPosition = maze.getStartPosition();
		goalPosition = maze.getGoalPosition();
		curentPosition = maze.getStartPosition();
		
		}
		if(o.getClass() == State.class){
			System.out.println("state");
			@SuppressWarnings("unchecked")
			State<Position> state = (State<Position>)o;
			curentPosition = state.getValue();
			
			System.out.println(maze.toString());

		}
		
		
		}
}
