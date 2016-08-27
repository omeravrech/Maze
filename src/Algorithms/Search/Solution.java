package Algorithms.Search;

import java.util.Stack;

public class Solution<T> {
	Stack<T> result;
	
	public Solution()
	{
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
		StringBuilder string = new StringBuilder();
		for (T object : result)
		{
			string.append(object + "\n");			
		}
		return string.toString();
	}
}
