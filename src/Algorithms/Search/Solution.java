package Algorithms.Search;

import java.util.ArrayList;

public class Solution<T> {
	ArrayList<State<T>> result;
	
	public Solution(State<T> start, State<T> close)
	{
		result.clear();
	}
	
	public void addNode(State<T> node)
	{
		result.add(node);
	}

	@Override
	public String toString()
	{
		StringBuilder string = new StringBuilder();
		for (State<T> state : result) {
			string.append(state + "\n");			
		}
		return string.toString();
	}
	
	
}
