package MVP.model;

import java.io.File;
import java.io.IOException;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.Search.Searcher;
import Algorithms.Search.Solution;

public class MyModel extends CommonModel
{

	public MyModel()
	{
		super();
	}

	@Override
	public void operate() {
		// TODO Auto-generated method stub

	}

	@Override
	public int[][] display_cross_section(char asix, int line, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maze3D display(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solution<Position> display_solution(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File[] dir(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generate_maze(String name, int floors, int rows, int columns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(String name, String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(String name, String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void solve(String name, Searcher<Position> algorithm) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}



}
