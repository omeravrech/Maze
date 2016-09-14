package model;

import java.io.File;
import java.io.IOException;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.Search.Searcher;
import Algorithms.Search.Solution;

public interface Model
{
	public int[][] display_cross_section(char asix, int line, String name);
	public Maze3D display(String name);
	public Solution<Position> display_solution(String name);
	
	//Created by Bar
	public File[] dir(String path);
	public void generate_maze(String name, int floors, int rows, int columns);
	public void save(String name, String path); // Using file class?
	public void load(String name, String path);
	public void solve(String name, Searcher<Position> algorithm) throws IOException; // Need to send params to Searcher <T>
	public void exit(); //TODO: Close ALL FILES(!!) and KILL ALL THREADS(!!)

}
