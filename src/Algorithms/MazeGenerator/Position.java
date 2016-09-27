package Algorithms.MazeGenerator;

import java.io.Serializable;

/**
* <h1>Position</h1>
* 
* This class holds the coordinates of a position.
*
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   27/08/2016
* @param1 int floor
* @param2 int rows
* @param3 int columns
*  
*/
public class Position implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int floor;
	private int rows;
	private int columns;



	/*public static final Position UP = new Position(2, 0, 0);
	public static final Position DOWN = new Position(-2, 0, 0);
	public static final Position RIGHT = new Position(0, 0, 1);
	public static final Position LEFT = new Position(0, 0, -1);
	public static final Position FORWARD = new Position(0, 1, 0);
	public static final Position BACKWARD = new Position(0, -1, 0);*/
	
	
	public Position(int floor, int rows, int columns) 
	{
		this.floor = floor;
		this.rows = rows;
		this.columns = columns;
	}
	
	public int floor() {
		return floor;
	}
	public int row() {
		return rows;
	}
	public int column() {
		return columns;
	}
	
	/*public void setFloor(int floor) {
		this.floor = floor;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}*/
	@Override
	public String toString() {
		return "{" + floor + "," + rows + "," + columns + "}";
	}

	public boolean equals(Object obj) 
	{
		if (!(obj instanceof Position))
			throw new IllegalArgumentException("Object must be position");
		Position other = (Position) obj;
		return ((floor == other.floor) && (rows == other.rows) && (columns == other.columns));
	}

	public void move(int floor, int row, int col)
	{
		System.err.print(	"Change position: " + toString());
		this.floor += floor;
		this.rows += row;
		this.columns += col;
		System.err.println(	"to position:     " + toString());
	}
}
