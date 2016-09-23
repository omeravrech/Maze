package MVP.model;

import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.Search.Solution;
import MVP.presenter.Properties;

public abstract class CommonModel extends Observable implements Model {

	protected HashMap<String, Maze3D> mazes;
	protected HashMap<Maze3D, Solution<Position>> mazeToSolution;
	protected ExecutorService pool;
	protected String commandOutput;
	protected boolean runningStatus;
	protected Properties properties;

	public CommonModel(Properties properties)
	{
		this.properties = properties;
		this.mazes = new HashMap<String,Maze3D>();
		this.mazeToSolution = new HashMap<Maze3D, Solution<Position>>();
		this.pool = Executors.newWorkStealingPool(this.properties.getNumOfThreads());
		this.commandOutput = "";
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
