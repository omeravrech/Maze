package Algorithms.MazeGenerator;

import java.util.ArrayList;

public class Maze3D {
	
	private int[][][] maze;

	private Position startPosition;
	private Position goalPosition;
	
	public static final int PATH = 0;
	public static final int WALL = 1;
	public static final int START = 2;
	public static final int END = 3;
	
	public Maze3D(int floors, int rows,int columns)
	{
		this.maze = new int[2*floors+1][2*rows+1][2*columns+1];
	
		for (int i=0; i < maze.length; i++)
			for (int j=0; j < maze[i].length; j++)
				for (int k=0; k < maze[i][j].length; k++)
					maze[i][j][k] = WALL;
	}
	public void setStartPosition(Position startPosition) {
		/**
		 * @param startPosition the startPosition to set
		 */
		if (this.startPosition != null)
			maze[startPosition.floor()][startPosition.row()][startPosition.column()] = PATH;
		this.startPosition = startPosition;
		maze[startPosition.floor()][startPosition.row()][startPosition.column()] = START;
	}
	public void setGoalPosition(Position goalPosition) {
		/**
		 * @param goalPosition the goalPosition to set
		 */
		if (this.goalPosition != null)
			maze[goalPosition.floor()][goalPosition.row()][goalPosition.column()] = PATH;
		this.goalPosition = goalPosition;
		maze[goalPosition.floor()][goalPosition.row()][goalPosition.column()] = END;
	}
	public Position getStartPosition()
	/**
	 * @return the startPosition
	 */
	{
		return startPosition;
	}
	public Position getGoalPosition()
	/**
	 * @return the goalPosition
	 */
	{
		return goalPosition;
	}

	public int positionStatus(Position p)
	{
		return maze[p.floor()][p.row()][p.column()];
	}
	public void wreckingBall(Position now, Position next)
	/**
	 *  @breaking the wall between to positions.
	 */
	{
		maze[((now.floor()+next.floor())/2)][((now.row()+next.row())/2)][((now.column()+next.column())/2)] = PATH;
		if (maze[next.floor()][next.row()][next.column()] == WALL)
			maze[next.floor()][next.row()][next.column()] = PATH;
	}
	public ArrayList<Position> nextWall(Position p)
	/**
	 * @return an array list with all the possible moves for requested position.
	 * if there isn't any move, return empty array.
	 */
	{
		ArrayList<Position> loc = new ArrayList<Position>(0);
		
		if ((p.floor() < maze.length-2) && (maze[p.floor()+2][p.row()][p.column()] == WALL)) //up
			loc.add(new Position(p.floor()+2,p.row(),p.column()));
		if ((p.floor() > 1) && (maze[p.floor()-2][p.row()][p.column()] == WALL))	//down
			loc.add(new Position(p.floor()-2,p.row(),p.column()));
		
		if ((p.row() < (maze[p.floor()].length-2)) && (maze[p.floor()][p.row()+2][p.column()] == WALL)) //forward
			loc.add(new Position(p.floor(),p.row()+2,p.column()));
		if ((p.row() > 1) && (maze[p.floor()][p.row()-2][p.column()] == WALL)) //backward
			loc.add(new Position(p.floor(),p.row()-2,p.column()));

		if ((p.column() < (maze[p.floor()][p.row()].length -2)) && (maze[p.floor()][p.row()][p.column()+2] == WALL)) //right
			loc.add(new Position(p.floor(),p.row(),p.column()+2));
		if ((p.column() > 1) && (maze[p.floor()][p.row()][p.column()-2] == WALL)) //left
			loc.add(new Position(p.floor(),p.row(),p.column()-2));
				
		return loc;
	}
	public ArrayList<Position> getPossibleMoves(Position p)
	/**
	 * @return an array list with all the possible moves for requested position.
	 * if there isn't any move, return empty array.
	 */
	{
		ArrayList<Position> loc = new ArrayList<Position>(0);
		
		if ((p.floor() < maze.length-2) && (maze[p.floor()+1][p.row()][p.column()] != WALL)) //up
			loc.add(new Position(p.floor()+1,p.row(),p.column()));
		if ((p.floor() > 1) && (maze[p.floor()-1][p.row()][p.column()] != WALL))	//down
			loc.add(new Position(p.floor()-1,p.row(),p.column()));
		
		if ((p.row() < (maze[p.floor()].length-2)) && (maze[p.floor()][p.row()+1][p.column()] != WALL)) //forward
			loc.add(new Position(p.floor(),p.row()+1,p.column()));
		if ((p.row() > 1) && (maze[p.floor()][p.row()-1][p.column()] != WALL)) //backward
			loc.add(new Position(p.floor(),p.row()-1,p.column()));

		if ((p.column() < (maze[p.floor()][p.row()].length -2)) && (maze[p.floor()][p.row()][p.column()+1] != WALL)) //right
			loc.add(new Position(p.floor(),p.row(),p.column()+1));
		if ((p.column() > 1) && (maze[p.floor()][p.row()][p.column()-1] != WALL))  //left
			loc.add(new Position(p.floor(),p.row(),p.column()-1));
				
		return loc;
	}
	public int[][] getCrossSectionByX(int axis)
	{
		if ((axis < 0) || ((axis*2+1) > maze[0][0].length))
			throw new IndexOutOfBoundsException("Invalid input.");
		else
		{
			int[][] loc = new int[maze.length][maze[0].length];
				for (int i=0; i < maze.length; i++)
					for (int j=0; j < maze[i].length; j++)
						loc[i][j] = maze[i][j][2*axis+1];
			return loc;
		}
	}
	public int[][] getCrossSectionByY(int axis)
	{
		if ((axis < 0) || ((axis*2+1) > maze[0].length))
			throw new IndexOutOfBoundsException("Invalid input.");
		else
		{
		int[][] loc = new int[maze[0][2*axis].length][maze.length];
			for (int i=0; i < maze.length; i++)
				for (int j=0; j < maze[i][2*axis+1].length; j++)
					loc[j][i] = maze[i][2*axis+1][j];
			return loc;
		}
	}
	public int[][] getCrossSectionByZ(int axis)
	{
		if ((axis < 0) || ((axis*2+1) > maze.length))
			throw new IndexOutOfBoundsException("Invalid input.");
		return maze[2*axis+1].clone();
	}
	
	@Override
	public String toString()
	{
		String out = "";
		
		for (int i=0; i < maze.length; i++)
		{
			for (int j=0; j < maze[i].length; j++)
			{
				for (int k=0; k < maze[i][j].length; k++)
				{
					out += maze[i][j][k] + " ";
				}
				out += "\n";
			}
			out += "\n";
		}
		return out;
	}
}
