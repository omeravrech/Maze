package Algorithms.MazeGenerator;

import java.util.ArrayList;

public class FirstNodeChoose extends AbstractNodeChoose<Position> {

	@Override
	public Position choose(ArrayList<Position> ar) {
		/**@return the first node from array list.
		 * if array is empty - return null.
		 */
		Position p = null;
		if (ar.size() > 0) { p = ar.get(0);	}
		return p;
	}
}
