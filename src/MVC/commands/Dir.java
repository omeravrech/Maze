package MVC.commands;

import java.io.IOException;

import MVC.controller.ICommand;

public class Dir implements ICommand
{
	private String path;
	
	
	public Dir(String path) 
	{
		//super(path);
		this.path = path;
		
	}


	@Override
	public void doCommand(String[] commands) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	
}
