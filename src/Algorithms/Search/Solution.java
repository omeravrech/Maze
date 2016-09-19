package Algorithms.Search;

import java.util.Stack;

/**
* <h1>Solution</h1>
* This class will hold the final "Solution" - a path from start state to goal state
*
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   27/08/2016
* @param1 Stack result
*  
*/
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
		
		
		for (int i = result.size()-1; i >= 0 ;i--)
		{
			string += result.get(i) + " -> ";
		}
		string += "END!";
		return string;
	}
}
