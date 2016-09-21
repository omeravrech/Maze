package MVP.commands;

import java.io.IOException;

import MVP.commands.CommonCommand;
import MVP.model.Model;
import MVP.view.View;

public class Display_Solutions_List extends CommonCommand
{

	public Display_Solutions_List(Model model, View view)
	{
		super(model, view);
	}

	@Override
	public void doCommand(String[] args) throws IOException
	{
		model.display_solution_list();
	}

}
