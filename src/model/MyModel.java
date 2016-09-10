package model;

import controller.Controller;

public class MyModel implements Model
{
	private Controller controller;
	
	public void setController (Controller controller)
	{
		this.controller = controller;
	}

	@Override
	public Controller setController() {
		return this.controller;
	}
}
