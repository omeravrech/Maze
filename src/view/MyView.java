package view;

import controller.Controller;

public class MyView implements View 
{
	Controller controller;
	CLI cli;
	
	public MyView(Controller controller) {
		this.controller = controller;
	}


	@Override
	public void start()
	{
		cli.start();
	}
	
	
	
	
}
