package MVP.model;

import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.Search.Solution;

public abstract class CommonModel extends Observable implements Model {

	protected HashMap<String, Maze3D> mazes;
	protected HashMap<String,Solution<Position>> solutions;
	protected ExecutorService pool;
	protected String commandOutput;
	protected boolean runningStatus;

	public CommonModel()
	{
		this.mazes = new HashMap<String,Maze3D>();
		this.solutions = new HashMap<String,Solution<Position>>();
		this.pool = Executors.newCachedThreadPool();
		this.commandOutput = null;
		this.runningStatus = true;
	}
	
	public String getCommandOutput()
	{
		if (this.commandOutput == null)
			return "";
		else
		{
			String local = this.commandOutput;
			this.commandOutput = "";
			return local;
		}
	}
}
