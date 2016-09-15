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

					if(fileList == null)
						display.append("File Not Found");
					else
					{
						display.append(path + "\n");
						for (File file : fileList)
						{
							if(file.isDirectory()==true)
								display.append("\t|- DIR");
								else
									display.append("\t|- ---");
							display.append("\t" + file.toString().substring(file.toString().lastIndexOf("\\") +1));
							display.append("\n");
						}
					}
				}
				catch (Exception e)
				{
					display.append(e.getMessage() + "\n");
				}
				display.append("\n");
			}
		}
		view.notify(display.toString());
	}	
}
