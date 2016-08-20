package algorithms.MazeGenerators;

import java.util.ArrayList;

public class RandomChoose  extends AbstractNodeChoose<Position> {

	@Override
	public Position choose(ArrayList<Position> ar) {
		/**@return random node from array list.
		 * if array is empty - return null.
		 */
		Position p = null;
		if (ar.size() > 0)
		{
			if (ar.size() == 1)
				p = ar.get(0);
			else
			{
				java.util.Random rand = new java.util.Random();
				p = ar.get(rand.nextInt(ar.size()-1));
			}
		}
		return p;
	}
}
