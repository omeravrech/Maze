package Algorithms.Search;

public class State<T> implements Comparable<State<T>> {

	T value;
	double cost;
	State<T> parent;
	
	
	public State(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public double getCost() {
		return cost;
	}

	public State<T> getParent() {
		return parent;
	}

	public void update(double cost, State<T> parent)
	{
		if (cost > 0) this.cost = cost;
		if (parent != null) this.parent = parent;
	}

	@Override
	public int compareTo(State<T> other) {
		return (int)(this.cost - other.cost);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass()) || (this.value == null))
			return false;
		
		State other = (State) obj;
		
		if (other.value == null)
				return false;
		else 
			return this.value.equals(other.value);
	}
	
}
