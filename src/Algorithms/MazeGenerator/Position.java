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

	public Position(int floor, int rows, int columns) {
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
	@Override
	public String toString() {
		return "{" + floor + "," + rows + "," + columns + "}";
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Position))
			throw new IllegalArgumentException("Object must be position");
		Position other = (Position) obj;
		return ((floor == other.floor) && (rows == other.rows) && (columns == other.columns));
	}
	
}
