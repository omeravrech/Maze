package MVC.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.Search.Searcher;
import Algorithms.Search.Solution;
import MVC.controller.Controller;


/**
* <h1>CommonModel abstract class</h1>
*<br> an abstract class that implements Model<br>
*This class will hold the abstract methods for the model to implement
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   15/09/2016 
*/
public abstract class CommonModel implements Model {

	protected Controller controller;
	protected HashMap<String, Maze3D> mazeMap;
	protected HashMap<String, Solution<Position>> solutionMap;
	protected List<Thread> threads;
	
	/**
	 * Setting the controller 
	 * @param controller
	 */
	public void setController (Controller controller)
	{
		this.controller = controller;
		this.mazeMap = new HashMap<String, Maze3D>();
		this.solutionMap = new HashMap<String, Solution<Position>>();
		this.threads = new ArrayList<Thread>();
	}

	public Controller getController() {
		return this.controller;
	}

	//Display methods
	abstract public Maze3D display(String name);
	abstract public int[][] display_cross_section(char asix, int line, String name);
	abstract public Solution<Position> display_solution(String name);
	abstract public void generate_maze(String name, int floors, int rows, int columns);
	abstract public File[] dir(String path);
	abstract public void save(String name, String path); // Using file class?
	abstract public void load(String name, String path);
	abstract public void solve(String name, Searcher<Position> algorithm) throws IOException; // Need to send params to Searcher <T>
	abstract public void exit(); //TODO: Close ALL FILES(!!) and KILL ALL THREADS(!!)
	//abstract public void returnedMessage(Object msg);
}
