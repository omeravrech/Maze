package MVP.model;

import java.io.IOException;

import Algorithms.MazeGenerator.Position;
import Algorithms.Search.Searcher;

public interface Model
{
	public void exit();
	public void generate_3d_maze(String name, int floors, int rows, int columns) throws IOException;
	public void save(String name, String path);
	public void load(String name, String path);
	public void solve(String name, Searcher<Position> algorithm) throws IOException;
	public void display_cross_section(String asix, int line, String name);
	public void display(String name);
	public void display_solution(String name);	
	public void dir(String path);
	public String getCommandOutput();
}