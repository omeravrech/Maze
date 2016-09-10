package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Controller;
import controller.ICommand;

public class MyView implements View 
{
	Controller controller;
	CLI cli;
	
	public MyView (BufferedReader in,PrintWriter out)
	{
		cli = new CLI(in,out);
	}
	
	public void setController(Controller controller)
	{
		this.controller = controller;
	}
	public Controller getController()
	{
		return this.controller;
	}
	
	@Override
	public void start()
	{
		cli.start();
	}


	@Override
	public void setCommands(HashMap<String, ICommand> commands)
	{
		cli.setCommands(commands);
	}


	@Override
	public HashMap<String, ICommand> getCommands()
	{
		return cli.getCommands();
	}

	@Override
	public void operation(String regex)
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
