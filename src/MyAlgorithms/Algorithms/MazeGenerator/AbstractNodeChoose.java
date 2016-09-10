package MyAlgorithms.Algorithms.MazeGenerator;

import java.util.ArrayList;

/**
* <h1>AbstractNodeChoose</h1>
* An abstract class that has an abstract method <i>choose</i>.
* 
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   27/08/2016
*
*/
public abstract class AbstractNodeChoose<T> {
	 public abstract T choose(ArrayList<T> ar); 
}
