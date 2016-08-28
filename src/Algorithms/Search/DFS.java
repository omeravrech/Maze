package Algorithms.Search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DFS<T> extends CommonSearcher<T>
{
	private PriorityQueue<State<T>> close;
	
	public DFS()
	{
		super();
		open = new PriorityQueue<State<T>>(new Comparator<State<T>>() {
			@Override
			public int compare(State<T> left, State<T> right)
			{
				return (int)(right.getCost() - left.getCost());
			}
		});
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
			currentState = popOpenList();
			if (currentState.equals(problem.getGoalState()))
			{
				solution = backTrace(currentState);
				break;
			}
			else
			{
				successors = problem.getAllPossibleStates(currentState);
				for (State<T> successor : successors)
				{
					if (!open.contains(successor) && !close.contains(successor))
					{
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
