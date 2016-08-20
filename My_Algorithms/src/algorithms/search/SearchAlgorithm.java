package algorithms.search;

import java.util.HashSet;

public interface SearchAlgorithm {
	public HashSet<State> search (Searchable s);
	public int getNumberOfNodesEvaluated();
}
