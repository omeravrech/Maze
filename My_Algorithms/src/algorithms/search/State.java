package algorithms.search;


public class State<T> {
	private T state;
	private int cost;
	private State<T> parent;
	
	public State(T state) {
		this.state = state;
		cost = 0;
		parent = null;
	}

	/**
	 * @return the state
	 */
	public T getState() {
		return state;
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @return the parent
	 */
	public State<T> getParent() {
		return parent;
	}

	/**
	 * @param state the state to set
	 */

	public void update(int cost, State<T> parent)
	{
		this.cost = cost;
		this.parent = parent;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof State))
			return false;
		@SuppressWarnings("unchecked")
		State<T> other = (State<T>) obj;
		 return this.state.equals(other.state);
	}
	
	
}
