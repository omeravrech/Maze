package MVP.model;

import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.Search.Solution;

public abstract class CommonModel extends Observable implements Model {

	protected HashMap<String, Maze3D> mazes;
	protected HashMap<String,Solution<Position>> solutions;
	protected ExecutorService pool;

	public CommonModel()
	{
		this.mazes = new HashMap<String,Maze3D>();
		this.solutions = new HashMap<String,Solution<Position>>();
		this.pool = Executors.newCachedThreadPool();
	}
	
}
