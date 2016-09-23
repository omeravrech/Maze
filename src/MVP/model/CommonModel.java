package MVP.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

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
		
		try
		{
			this.mazeToSolution = loadSolutionMap();
			
		}
		catch (Exception e)
		{
			this.mazeToSolution = new HashMap<Maze3D, Solution<Position>>();
		}
		
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
	
	/**
	 * This method will load the solution map
	 * @param String 
	 */
	@SuppressWarnings("unchecked")
	public HashMap<Maze3D,Solution<Position>> loadSolutionMap() throws Exception
	{	
		ObjectInputStream in = null;
	
		in = new ObjectInputStream(new GZIPInputStream(new FileInputStream(properties.getSolutionMapPath())));
		HashMap<Maze3D,Solution<Position>> solutionMapping = (HashMap<Maze3D,Solution<Position>>)in.readObject();
		commandOutput += "Solution file loaded successfully";
		this.setChanged();
		this.notifyObservers();
		
		in.close();
		
		return solutionMapping;
	}
		
	public void saveSolutionMap (HashMap<Maze3D,Solution<Position>> solutions) throws Exception
	{
		ObjectOutputStream out = null;
		
		out = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(properties.getSolutionMapPath())));
		out.writeObject(mazeToSolution);
		out.close();

		commandOutput += "Solution file was saved successfully in: " + properties.getSolutionMapPath();
		this.setChanged();
		this.notifyObservers();
	}
}



