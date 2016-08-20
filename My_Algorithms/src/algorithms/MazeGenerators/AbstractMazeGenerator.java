package algorithms.MazeGenerators;

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
