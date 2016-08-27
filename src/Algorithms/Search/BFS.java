package Algorithms.Search;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BFS<T> extends CommonSearcher<T>
{

	PriorityQueue<State<T>> close;
	
	public BFS()
	{
		super();
		this.open = new PriorityQueue<State<T>>();
		this.close = new PriorityQueue<State<T>>();
		
	}

	@Override
	public Solution<T> search(Searchable<T> problem)
	{
		State<T> currentState = problem.getInitialState();
		ArrayList<State<T>> successors;
		Solution<T> solution = null;
		
		currentState.update(0,null);
		open.add(currentState);
		
		while (!open.isEmpty())
		{
			currentState = open.remove();
			if (currentState.equals(problem.getGoalState()))
				solution = backTrace(currentState);
			else
			{
				successors = problem.getAllPossibleStates(currentState);
				for (State<T> successor : successors)
				{
					if (!open.contains(successor) || !close.contains(successor))
					{
						numberOfNodesEvaluated++;
						successor.update(currentState.getCost()+1, currentState);
						open.add(successor);
					}
				}
				close.add(currentState);
			}
		}
		return solution;
	}
}
