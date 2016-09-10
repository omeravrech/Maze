package MyAlgorithms.Algorithms.MazeGenerator;

import java.util.ArrayList;


/**
* <h1>RandomChoose</h1>
* 
* This class will return a random node from the maze.
*
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   27/08/2016
*  
*/
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
