package commands;

import java.io.IOException;

import model.Model;
import view.View;

public class Display extends CommonCommand
{
	
	public Display(View view, Model model) {
		super(view,model);
	}


	@Override
	public void doCommand(String[] commands) throws IOException
	{
		String name = commands[1];
		if ((name != null) || (name != "") || (name != " "))
			model.display(name);
		else
			throw new IOException("display <maze name>");
	}

}
