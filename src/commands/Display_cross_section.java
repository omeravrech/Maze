package commands;

import java.io.IOException;

import model.Model;
import view.View;

public class Display_cross_section extends CommonCommand
{
	public Display_cross_section(View view, Model model) 
	{
		super(view, model);
	}

	@Override
	public void doCommand(String[] commands) throws IOException
	{
		char asix = commands[1].charAt(0);
		
		if (asix >=97) asix-= 32;
		if ((asix > 'z') || (asix < 'x'))
			model.display_cross_section(asix,Integer.valueOf(commands[2]),commands[3]);
		else
			throw new IOException("Wrong values.");
		
	}	
}
