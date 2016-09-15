package controller;

import java.io.IOException;
import java.util.HashMap;

import commands.Dir;
import commands.Display;
import commands.Display_cross_section;
import commands.Display_solution;
import commands.Exit;
import commands.Generate_3d_maze;
import commands.ICommand;
import commands.Load_maze;
import commands.Save_maze;
import commands.Solve;
import model.Model;
import view.View;

public class MyController extends CommonController
{
	
	public MyController(View view, Model model)
	{
		super(view, model);
		InitHashMap();
		
	}
	
	protected void InitHashMap()
	{
		/* Initializing the HashMap with the proper regex */
		commands = new HashMap<String,ICommand>();
		commands.put("dir [^ \n]+", new Dir(view,model));
		commands.put("generate [A-Za-z0-9]+ [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}", new Generate_3d_maze(view,model));
		commands.put("display [^ \n]+", new Display(view,model));
		commands.put("display_cross_section [XYZxyz] [0-9]{1,2} [A-Za-z0-9]+", new Display_cross_section(view,model));
		commands.put("save [A-Za-z0-9]+ [^ \n]+", new Save_maze(view,model));
		commands.put("load [^ \n]+.maz", new Load_maze(view,model));
		//commands.put("load [^ \n]+ [A-Za-z0-9]+", new Load_maze(view,model));
		commands.put("solve [A-Za-z0-9]+ [A-Za-z0-9]+", new Solve(view,model));
		commands.put("solution [A-Za-z0-9]+", new Display_solution(view,model));
		commands.put("exit", new Exit(view,model));
	}
	
	@Override
	public void operationCommand(String command, String input) throws IOException
	{
		String[] args = input.substring(input.indexOf(" ") + 1).split(" ");
		ICommand icommand = commands.get(command);
		icommand.doCommand(args);
	}

	@Override
	public void notify(String message)
	{
		view.notify(message);
	}	
}