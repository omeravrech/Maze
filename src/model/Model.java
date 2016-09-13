package model;

import java.io.File;

import Algorithms.Search.Searcher;

public interface Model
{
	public void generate_maze(String name, int floors, int rows, int columns);
	public void display_cross_section(char asix, int line, String name);
	
	//Created by Bar
	public void dir(String path);
	public void display(String name);
	public void save(String name, File fileName); // Using file class?
	public void load(File fileName, String name);
	public void solve(String name, Searcher algorithm); // Need to send params to Searcher <T>
	public void display_solution(String name);
	public void exit(); //TODO: Close ALL FILES(!!) and KILL ALL THREADS(!!)
	public void returnedMessage(Object msg);

}
