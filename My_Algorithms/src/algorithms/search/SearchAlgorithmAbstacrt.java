package algorithms.search;

import java.util.HashSet;
import java.util.PriorityQueue;

public abstract class SearchAlgorithmAbstacrt implements SearchAlgorithm {

	protected PriorityQueue<State> open;
	private int evaluatedNodes;
	
	public SearchAlgorithmAbstacrt()
	{
		open = new PriorityQueue<State>();
		evaluatedNodes = 0;
	}
	public State popOpen()
	{
		evaluatedNodes++;
		return open.poll();
	}
		@Override
	public int getNumberOfNodesEvaluated() {
		return evaluatedNodes;
	}
	@Override
	public abstract HashSet<State> search (Searchable s);
}
