package controller;

import java.io.IOException;
import java.util.HashMap;

import commands.Dir;
import commands.Display;
import commands.Display_cross_section;
import commands.Display_solution;
import commands.Generate_3d_maze;
import commands.Load_maze;
import commands.Save_maze;
import commands.Solve;
import model.Model;
import view.View;

public class MyController implements Controller 
{
	private Model model;
	private View view;
	private HashMap<String,ICommand> commands;
	
	public MyController(View view, Model model)
	{
		this.view = view;
		this.model = model;
		this.setHashMap();

	}

	private void setHashMap()
	{
		/* Initializing the HashMap with the proper regex */
		commands = new HashMap<String,ICommand>();
		commands.put("dir [^ \n]+", new Dir(view,model));
		commands.put("generate_3d_maze [A-Za-z0-9]+ [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}", new Generate_3d_maze(view,model));
		commands.put("display [^ \n]+", new Display(view,model));
		commands.put("display_cross_section [XYZxyz] [0-9]{1,2} for [A-Za-z0-9]+", new Display_cross_section(view,model));
		commands.put("save [A-Za-z0-9]+ [^ \n]+", new Save_maze(view,model));
		commands.put("load [^ \n]+ [A-Za-z0-9]+", new Load_maze(view,model));
		commands.put("solve [A-Za-z0-9]+ [A-Za-z0-9]+", new Solve(view,model));
		commands.put("solution [A-Za-z0-9]+", new Display_solution(view,model));
	}
	
	public HashMap<String,ICommand> getCommands()
	{
		return this.commands;
	}

	@Override
	public void operationCommand(String command) throws IOException
	{
		String[] args = command.split(" ");
		commands.get(args[0]).doCommand(args);
	}

	@Override
	public void returnedMessage(Object msg) {
		view.returnedMessage(Object msg)
		
	}	
}