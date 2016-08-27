package Algorithms.Search;

import java.util.Stack;

public class Solution<T> {
	Stack<T> result;
	
	public Solution()
	{
		result = new Stack<T>();
		result.clear();
	}
	
	public void addNode(T node)
	{
		result.push(node);
	}
	public Stack<T> getResult()
	{
		return result;
	}
	@Override
	public String toString()
	{
		String string = "START -> ";
		for (T object : result)
		{
			string += object + " -> ";			
		}

		string += "END!";
		return string;
	}
}
