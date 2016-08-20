package algorithms.search;

import java.util.ArrayList;

public interface Searchable {
	@SuppressWarnings("rawtypes")
	State getStartState();
	@SuppressWarnings("rawtypes")
	State getEndState();
	@SuppressWarnings("rawtypes")
	ArrayList<State> getAllPossibleStates(State s);
}
