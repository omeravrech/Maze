package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;

public class BFS extends SearchAlgorithmAbstacrt
{
	private Searchable searchAble; 
	private HashSet<State> close;
	
	@Override
	public HashSet<State> search(Searchable s)
	{
		open.add(s.getStartState());
		close = new HashSet<State>();
		while (open.size() > 0)
		{
			State n = popOpen();
			close.add(n);
			if(n.equals(s.getEndState()))
				return backTrace(s.getStartState(),s.getEndState());
			
			ArrayList<State> successors = s.getAllPossibleStates(n);
			for (State state : successors) {
				if (!close.contains(state) && !open.contains(state))
				{
					state.update(n.getCost()+1, n);
					open.add(state);
				}
				else if (!state)
				{
						if(!open.contains(state))
							open.add(state);
				}
			}
		}
		return null;
	}
	private HashSet<State> backTrace(State start, State goal)
	{
		return null;
	}
	
}
