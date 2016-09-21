package MVP.commands;

import java.io.IOException;

import MVP.commands.CommonCommand;
import MVP.model.Model;
import MVP.view.View;

public class Display_Mazes_List extends CommonCommand
{

	public Display_Mazes_List(Model model, View view)
	{
		super(model, view);
	}

	@Override
	public void doCommand(String[] args) throws IOException
	{
		model.display_mazes_list();
	}

}
