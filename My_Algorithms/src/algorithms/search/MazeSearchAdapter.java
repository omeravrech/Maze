package algorithms.search;

import java.util.ArrayList;

import algorithms.MazeGenerators.Maze3D;
import algorithms.MazeGenerators.Position;

public class MazeSearchAdapter implements Searchable
{
	Maze3D maze;
	
	public MazeSearchAdapter(Maze3D maze) {
		this.maze = maze;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public State getStartState() {
		return new State<Position>(maze.getStartPosition());
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public State getEndState() {
		return new State<Position>(maze.getGoalPosition());
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public ArrayList<State> getAllPossibleStates(State s) {
		Position p = (Position) s.getState();
		ArrayList<Position> loc = maze.getPossibleMoves(p);
		ArrayList<State> ALStates = new ArrayList<State>(0);
		@SuppressWarnings("unused")
		State<Position> state;
		for (Position pos : loc) {
			s = new State<Position>(pos);
			ALStates.add(s);
		}
		return ALStates;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return maze.toString();
	}
	
}
