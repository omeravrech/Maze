package MVP.commands;

import java.io.IOException;

import MVP.commands.CommonCommand;
import MVP.model.Model;
import MVP.view.View;

public class Help extends CommonCommand
{

	public Help(View view, Model model)
	{
		super(model, view);
	}

	@Override
	public void doCommand(String[] args) throws IOException
	{
		String s = new String();
		s += "dir <path>" + "\n";
		s += "generate 3d maze <name> <int> <int> <int>" + "\n";
		s += "display <name>" + "\n";
		s += "display  cross section by {X,Y,Z} <int> for <name>" + "\n";
		s += "save maze <name> <file name>" + "\n";
		s += "load maze <file name> <name>" + "\n";
		s += "maze size <name>" + "\n";
		s += "file size <name>" + "\n";
		s += "solve <name> {Air,Manhattan,Bfs}" + "\n";
		s += "display solution <name>" + "\n";
		s += "exit";
		view.Result(s);	

	}

}
