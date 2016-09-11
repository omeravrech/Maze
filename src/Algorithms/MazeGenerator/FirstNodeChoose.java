package Algorithms.MazeGenerator;

import java.util.ArrayList;

/**
* <h1>FirstNodeChoose</h1>
* This class implement AbstractNodeChoose's abstract function <i>choose</i>
* returns the first node in the ArrayList of positions.
* 
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   27/08/2016
*
*/
public class FirstNodeChoose extends AbstractNodeChoose<Position> {
	
	/**
	* <h1>choose</h1>
	* returns the first node from array list.
	* if array is empty - return null.
	* @author  Omer Avrech & Bar Malka
	* @version 1.0
	* @since   27/08/2016
	* @return Position
	*/
	@Override
	public Position choose(ArrayList<Position> ar) {

		Position p = null;
		if (ar.size() > 0) { p = ar.get(0);	}
		return p;
	}
}
