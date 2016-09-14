package commands;

import java.io.File;
import java.io.IOException;

import model.Model;
import view.View;

public class Dir extends CommonCommand
{
	public Dir(View view, Model model) 
	{
		super(view, model);
	}

	@Override
	public void doCommand(String[] args) throws IOException
	{
		StringBuilder display = new StringBuilder();

		for (String path : args)
		{
			if ((path.isEmpty()) || (path.equals("")) || (args == null))
				continue;
			else
			{
				try
				{
					File[] fileList = model.dir(path);
					display.append("Directory of" + path + "\n");
					for (File file : fileList)
						display.append("\t" + file + "\n");
				}
				catch (Exception e)
				{
					display.append(e.getMessage() + "\n");
				}
				display.append("\n\n\n");
			}
		}
		view.notify(display.toString());
	}	
}
