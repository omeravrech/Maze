package MyAlgorithms.Algorithms.MazeGenerator;


/**
* <h1>AbstractMazeGenerator</h1>
* An abstract class that implements Maze3dGenerator, used by maze generator algorithms.
* 
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   27/08/2016
*
*/
public abstract class AbstractMazeGenerator implements Maze3dGenerator {
	

	public abstract Maze3D generate(int floors, int rows, int columns);
	public String measureAlgorithmTime(int floors, int height, int width)
	{
		long duration = System.currentTimeMillis();
		this.generate(floors,height,width);
		duration = System.currentTimeMillis() - duration;
		return String.valueOf(duration);
	}
}
