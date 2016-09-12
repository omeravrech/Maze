package model;

import Algorithms.MazeGenerator.GrowingTreeGenerator;
import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.RandomChoose;

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
				controller.sendMessage("Maze " + name + " has been generated");
			}
		}));
		threadList.get(threadList.size()-1).start();
	}
	
}
