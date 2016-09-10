package Algorithms.Search;

import java.util.ArrayList;
import Algorithms.MazeGenerator.*;

/**
* <h1>MazeAdapter</h1>
* 
* This class is used as an adapter
* Receives a property of Maze3D and translate it into an ArrayList of states.
*
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   27/08/2016
* @param1 Maze3D problem
*  
*/
public class MazeAdapter implements Searchable<Position>
{
	private Maze3D problem;
	
	public MazeAdapter(Maze3D problem)
	{
		this.problem = problem;
	}
	@Override
	public State<Position> getInitialState() {
		return new State<Position>(problem.getStartPosition());
	}
	@Override
	public State<Position> getGoalState() {
		return new State<Position>(problem.getGoalPosition());
	}
	@Override
	public ArrayList<State<Position>> getAllPossibleStates(State<Position> s)
	{
		ArrayList<Position> loc = problem.getPossibleMoves((Position)s.getValue());
		ArrayList<State<Position>> result = new ArrayList<State<Position>>();
		result.clear();
		
		for (Position position : loc) {
			State<Position> localState = new State<Position>(position);
			result.add(localState);
		}
		return result;
	}
}
