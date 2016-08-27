package Algorithms.Search;

public interface Searcher<T>{
	public Solution<T> search(Searchable<T> s);
	public int getNumberOfNodesEvaluated();
}