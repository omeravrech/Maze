package model;

import java.util.ArrayList;
import java.util.HashMap;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.Search.Solution;
import controller.Controller;

public abstract class CommonModel implements Model {

	protected Controller controller;
	protected HashMap<String, Maze3D> mazeMap;
	protected HashMap<String, Solution<Position>> solutionMap;
	protected ArrayList<Thread> threadList;
	
	public void setController (Controller controller)
	{
		this.controller = controller;
		this.mazeMap = new HashMap<String, Maze3D>();
		this.solutionMap = new HashMap<String, Solution<Position>>();
		this.threadList = new ArrayList<Thread>();
	}

	public Controller getController() {
		return this.controller;
	}
}
