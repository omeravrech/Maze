package MyAlgorithms.Algorithms.Search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
* <h1>DFS Algorithm!</h1>
* <br>
* DFS Algorithm will search deeply in every branch by popping from the queue the<br>
* state with highest cost.
*
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   27/08/2016 
* @param1 PriorityQueue close
*/

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
	
	
	/**
	* <h1>DFS - Search overridden function</h1>
	* Search function will perform the search according to the DFS
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
