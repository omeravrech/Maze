package MVP.view.Windows;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;

public abstract class MazeDisplay extends Canvas
{
	protected Maze3D maze;
	protected Position character;
	
	public MazeDisplay(Composite parent, int style)
	{
		super(parent, style);
	}
	
	public void setMazeData (Maze3D maze)
	{
		this.maze = maze;
		this.character = maze.getStartPosition();
		
		getDisplay().syncExec(new Runnable() {
			
			@Override
			public void run() {
				setEnabled(true);
				redraw();
			}
		});
		
	}
	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void moveForward();
	public abstract void moveBackward();
	public abstract void moveLeft();
	public abstract void moveRight();
	
	public abstract void setCharacterPosition(int floor, int row, int column);
}
