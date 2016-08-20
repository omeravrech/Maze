package algorithms.MazeGenerators;

public interface Maze3dGenerator {
	public Maze3D generate(int floors, int height, int width);
	public String measureAlgorithmTime(int floors, int height, int width);
}
