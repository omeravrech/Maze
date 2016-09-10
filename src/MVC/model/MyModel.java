package MVC.model;

import MVC.controller.Controller;

public class MyModel implements Model
{
	Controller controller;

	public MyModel(Controller controller) {
		this.controller = controller;
	}
	
	
}
