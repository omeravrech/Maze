package model;

import controller.Controller;

public class MyModel implements Model
{
	Controller controller;
	protected HashMap<String, Maze3d> mazesMap;

	public MyModel(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void generateMaze(String name, int floors, int rows, int columns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMaze(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCrossSection(String name, char asix, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(String name, String filepath) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(String name, String filepath) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void solve(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}
}
