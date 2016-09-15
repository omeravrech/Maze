package commands;

import java.io.File;
import java.io.IOException;

import model.Model;
import view.View;

public class Load_maze extends CommonCommand
{

	public Load_maze(View view, Model model) 
	{
		super(view, model);
	}
	
	@Override
	public void doCommand(String[] commands) throws IOException
	{
		String path = commands[0].substring(0, commands[0].lastIndexOf("\\"));
		String name = commands[0].substring(commands[0].lastIndexOf("\\")+1);
		name = name.substring(0,name.lastIndexOf("."));
		File file = new File(path,name + ".maz");
		if (!file.exists())
			view.notify("File does not exist");
		else
			model.load(name, path);
	}

}
