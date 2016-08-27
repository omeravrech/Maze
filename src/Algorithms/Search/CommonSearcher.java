package Algorithms.Search;

import java.util.PriorityQueue;

public abstract class CommonSearcher<T> implements Searcher<T>
{
	protected PriorityQueue<State<T>> open;
	protected int numberOfNodesEvaluated;
	
	public CommonSearcher ()
	{
		numberOfNodesEvaluated = 0;
	}
	
	@Override
	public abstract Solution<T> search(Searchable<T> s);

	@Override
	public int getNumberOfNodesEvaluated() {
		return numberOfNodesEvaluated;
	}
	
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
