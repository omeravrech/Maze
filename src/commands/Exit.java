package commands;

import java.io.IOException;

import model.Model;
import view.View;

public class Exit extends CommonCommand
{

	public Exit(View view, Model model) 
	{
		super(view, model);
	}
	
	@Override
	public void doCommand(String[] commands) throws IOException
	{
		model.exit();
	}

}
