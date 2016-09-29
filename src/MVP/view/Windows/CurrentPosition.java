package MVP.view.Windows;

import Algorithms.MazeGenerator.Position;


/**
* <h1>CurrentPosition class</h1>
*<br> This is a helpful class that holds a position for us<br>
* and basically represents the current position and holds methods for the user to move around the maze <br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   28/09/2016 
*
*/
public class CurrentPosition 
{
	private Position position;
	
	/**
	 * Constructor
	 * @param Position
	 */

	public CurrentPosition(Position p) 
	{
		this.position = new Position(p.floor(), p.row(), p.column());
	}
	
	/** Getter */
	public int floor()	{ return position.floor(); }
	/** Getter */
	public int row()	{ return position.row(); }	
	/** Getter */
	public int column()	{ return position.column(); }
	
	
	/** Moving the user one floor up */
	public void moveUp()		{ position.move(2,0,0);  }
	
	/** Moving the user one floor down */
	public void moveDown()		{ position.move(-2,0,0); }
	
	/** Moving the user one step forward */
	public void moveForward()	{ position.move(0,-1,0); }
	
	/** Moving the user one step backwards */
	public void moveBackward()	{ position.move(0,1,0);	 }
	
	/** Moving the user one step to the left */
	public void moveLeft()		{ position.move(0,0,-1); }
	
	
	/** Moving the user one step to the right */
	public void moveRight()		{ position.move(0,0,1);	 }
	
	/**
	 * This method receives the floor, row and column and change the location to this position <br>
	 * using Position's move function
	 * @see Position
	 * @param floor int
	 * @param row int
	 * @param col int
	 */
	public void changeLocation (int floor, int row, int col)
	{
		position.move(floor, row, col);
	}
	
	
	/**
	 * Overriding equals to know if the comparable object is a currentPosition<br>
	 * so we can compare its position
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj.getClass() != this.getClass())
			return false;
		
		CurrentPosition other = (CurrentPosition) obj;
		return position.equals(other.position);
	}
	/** Getter */
	public Position getPosition()
	{
		return this.position;
	}
	
	/** Setter */
	public void setPoistion(Position position)
	{
		this.position = position;
	}
}
