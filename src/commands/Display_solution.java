package commands;

import java.io.IOException;

import model.Model;
import view.View;

public class Display_solution extends CommonCommand
{
		
	
	public Display_solution(View view, Model model) {
		super(view, model);
	}

	@Override
	public void doCommand(String[] commands) throws IOException
	{
		String name = commands[1];
		if ((name != null) || (name != "") || (name != " "))
			model.display_solution(name);
		else
			throw new IOException("display_solution <maze name>");
	}

}
