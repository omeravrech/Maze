package Algorithms.Search;

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
	public Solution<T> search(Searchable<T> s) {
		// TODO Auto-generated method stub
		return null;
	}

}
