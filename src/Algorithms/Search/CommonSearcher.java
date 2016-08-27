package Algorithms.Search;

import java.util.PriorityQueue;
/**
* <h1>Common Searcher</h1>
* 
* An abstract class with common properties for
* all search algorithms
*
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   27/08/2016
* @param1 PriorityQueue open
* @param2 int numberOfNodesEvalulated
*  
*/
public abstract class CommonSearcher<T> implements Searcher<T>
{
	protected PriorityQueue<State<T>> open;
	protected int numberOfNodesEvaluated;
	/**
	* <h1> CmmonSearcher constructor function</h1>
	* initializes numberOfNodesEvaluated to 0.
	*
	* @author  Omer Avrech & Bar Malka
	* @version 1.0
	* @since   27/08/2016 
	*/
	public CommonSearcher ()
	{
		numberOfNodesEvaluated = 0;
	}
	
	/* An abstract method that will be overridden by different algorithms */
	@Override
	public abstract Solution<T> search(Searchable<T> s);
	
	/**
	* <h1>getNumberOfNodesEvaluated</h1>
	*
	* @author  Omer Avrech & Bar Malka
	* @version 1.0
	* @since   27/08/2016 
	* @return int numberOfNodesEvaluated
	*/
	@Override
	public int getNumberOfNodesEvaluated() {
		return numberOfNodesEvaluated;
	}
	
	/**
	* <h1> backTrace function</h1>
	* backTrade function receives the goal state, and runs from the goal
	* state all the way to the starting state.
	* returns the "array" of the position - which is the solution.
	*
	* @author  Omer Avrech & Bar Malka
	* @version 1.0
	* @since   27/08/2016
	* @param1 State goalState
	* @return Solution 
	*/
	protected Solution<T> backTrace(State<T> goalState) {
		Solution<T> solution = new Solution<T>();
		State<T> currentState = goalState;
		while (currentState!=null) {
			solution.addNode(currentState.getValue());
			currentState = currentState.getParent();
		}
		return solution;
	}
}
