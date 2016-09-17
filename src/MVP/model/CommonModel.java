package MVP.model;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.Search.Searcher;
import Algorithms.Search.Solution;
import MVC.commands.ICommand;
import MVP.presenter.Presenter;

public abstract class CommonModel extends Observable implements Model {

	protected Presenter presenter;
	protected HashMap<String,Maze3D> mazeMap;
	protected HashMap<String,Solution<Position>> solutionMap;
	protected ExecutorService pool;
	protected Queue<ICommand> commandsQueue;
	
	
	

	public CommonModel()
	{
		this.mazeMap = new HashMap<String,Maze3D>();
		this.solutionMap = new HashMap<String,Solution<Position>>();
		this.pool = Executors.newCachedThreadPool();
		this.commandsQueue = new PriorityQueue<ICommand>();
		
	}

	@Override
	abstract public void operate();

	abstract public int[][] display_cross_section(char asix, int line, String name);
	abstract public Maze3D display(String name);
	abstract public Solution<Position> display_solution(String name);	
	abstract public File[] dir(String path);
	abstract public void generate_maze(String name, int floors, int rows, int columns);
	abstract public void save(String name, String path);
	abstract public void load(String name, String path);
	abstract public void solve(String name, Searcher<Position> algorithm) throws IOException;
	abstract public void exit();


}
