package Algorithms.Search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
* <h1>BFS Algorithm!</h1>
* BFS (Best-First-Search) algorithm suppose to find and search
* the best <i><u>state</u></i> to the solution
*
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   27/08/2016 
* @param1 PriorityQueue close
*/
public class BFS<T> extends CommonSearcher<T>
{

	PriorityQueue<State<T>> close;
	/**
	* <h1>BFS - constructor / initializer</h1>
	* 1. Uses the <u><i>CommonSearcher</i></u> constructor<br>
	* 2. Uses default initializer for Open and Close properties using Priority queue
	*
	* @author  Omer Avrech & Bar Malka
	* @version 1.0
	* @since   27/08/2016 
	*/
	public BFS()
	{
		super();
		this.open = new PriorityQueue<State<T>>(new Comparator<State<T>>() {
			@Override
			public int compare(State<T> left, State<T> right)
			{
				return (int)(left.getCost() - right.getCost());
			}
		});
		this.close = new PriorityQueue<State<T>>();
		
	}
	/**
	* <h1>BFS - Search overridden function</h1>
	* Search function will perform the search according to the BFS
	* algorithm and will return a <u><i>Solution</u></i>.
	* @see Solution
	* @author  Omer Avrech & Bar Malka
	* @version 1.0
	* @since   27/08/2016
	* @return Solution
	* @param1 Searchable
	*/
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
