package MVC.model;

import java.io.File;
import java.io.IOException;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.Search.Searcher;
import Algorithms.Search.Solution;

/**
* <h1>Model interface</h1>
*<br> This interface has the proper commands' signature<br>
*and making sure each command has the correct parameters
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   15/09/2016 
*/
public interface Model
{
	public int[][] display_cross_section(char asix, int line, String name);
	public Maze3D display(String name);
	public Solution<Position> display_solution(String name);	
	public File[] dir(String path);
	public void generate_3d_maze(String name, int floors, int rows, int columns);
	public void save(String name, String path);
	public void load(String name, String path);
	public void solve(String name, Searcher<Position> algorithm) throws IOException;
	public void exit();

}
