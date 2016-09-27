package MVP.view.Windows;

import Algorithms.MazeGenerator.Position;

public class CurrentPosition 
{
	private Position position;
	public CurrentPosition(Position p) 
	{
		this.position = new Position(p.floor(), p.row(), p.column());
	}
	public int floor()	{ return position.floor(); }
	public int row()	{ return position.row(); }	
	public int column()	{ return position.column(); }
	
	public void moveUp()		{ position.move(2,0,0); }
	public void moveDown()		{ position.move(-2,0,0); }
	public void moveForward()	{ position.move(0,-1,0); }
	public void moveBackward()	{ position.move(0,1,0); }
	public void moveLeft()		{ position.move(0,0,-1); }
	public void moveRight()		{ position.move(0,0,1); }
	public void changeLocation (int floor, int row, int col)
	{
		position.move(floor, row, col);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj.getClass() != this.getClass())
			return false;
		
		CurrentPosition other = (CurrentPosition) obj;
		return position.equals(other.position);
	}
	public Position getPosition()
	{
		return this.position;
	}
}
