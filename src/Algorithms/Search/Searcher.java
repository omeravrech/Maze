package Algorithms.Search;

public interface Searcher<T>
{
	public Solution<T> search(Searchable s);
	public int getNumberOfNodesEvaluated();
}