package algorithms.MazeGenerators;

public class Position{
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
