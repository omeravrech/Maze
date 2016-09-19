package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;

public class Dir extends CommonCommand
{

	public Dir(Model model, View view) 
	{
		super(model, view);
	}

	@Override
	public void doCommand(String[] args) throws IOException 
	{
		String path = args[1];
		model.dir(path);
		
	}

}
