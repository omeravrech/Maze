package model;

import java.io.File;

import Algorithms.MazeGenerator.GrowingTreeGenerator;
import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.RandomChoose;
import Algorithms.Search.Searcher;

public class MyModel extends CommonModel
{
	public void generate_maze(String name, int floors, int rows, int columns)
	{
		this.threadList.add(new Thread(new Runnable() {
			
			@Override
			public void run()
			{
				Maze3D newMaze = new GrowingTreeGenerator(new RandomChoose()).generate(floors, rows, columns);
				mazeMap.put(name, newMaze);
				controller.returnedMessage("Maze " + name + " has been generated");
			}
		}));
		threadList.get(threadList.size()-1).start();
	}

	@Override
	public void display_cross_section(char asix, int line, String name)
	{
		this.threadList.add(new Thread(new Runnable() {
			
			@Override
			public void run()
			{
				Maze3D maze = mazeMap.get(name);
				if (maze != null)
				{
					switch (asix)
					{
					case 'x':
						controller.returnedMessage(maze.getCrossSectionByX(line));
						break;
					case 'y':
						controller.returnedMessage(maze.getCrossSectionByY(line));
						break;
					case 'z':
						controller.returnedMessage(maze.getCrossSectionByZ(line));
						break;
					}
				}
			}
		}));
		threadList.get(threadList.size()-1).start();
	}

	@Override
	public void dir(String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(String name, File fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(File fileName, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void solve(String name, Searcher algorithm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display_solution(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnedMessage(Object msg) {
		controller.returnedMessage(msg);
		
	}
	
}
