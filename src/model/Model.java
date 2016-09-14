package model;

import java.io.File;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.Search.Searcher;
import Algorithms.Search.Solution;

public interface Model
{
	public void generate_maze(String name, int floors, int rows, int columns);
	public int[][] display_cross_section(char asix, int line, String name);
	
	//Created by Bar
	public File[] dir(String path);
	public Maze3D display(String name);
	public void save(String name, File fileName); // Using file class?
	public void load(File fileName, String name);
	public void solve(String name, Searcher<Position> algorithm); // Need to send params to Searcher <T>
	public Solution<Position> display_solution(String name);
	public void exit(); //TODO: Close ALL FILES(!!) and KILL ALL THREADS(!!)
	//public void returnedMessage(Object msg);

}
