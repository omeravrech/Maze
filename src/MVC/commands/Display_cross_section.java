package MVC.commands;

import java.io.IOException;

import MVC.model.Model;
import MVC.view.View;
/**
 * Receives the inputs and go to the maze's "displayCrossSectionBy" function <br>
 * and return a 2d array to the user in the view
 */
public class Display_cross_section extends CommonCommand
{
	/**
	 * Constructor
	 * @param view
	 * @param model
	 */
	public Display_cross_section(View view, Model model) 
	{
		super(view, model);
	}

	@Override
	public void doCommand(String[] commands) throws IOException
	{
		char asix = commands[0].charAt(0);
		
		if (asix >=97)
			asix-= 32;
		int checkAxisValue = Integer.valueOf(commands[1]);
		if ((checkAxisValue < 1) || (checkAxisValue > 255))
			throw new IOException("display_cross_section [asix] [number] [name]");
		else
			{
				 int[][] maze2d = model.display_cross_section(asix,checkAxisValue,commands[2]);
				 if (maze2d == null)
					 throw new IOException ("Maze does not exist");
				 else
				 {
					 StringBuilder string = new StringBuilder();
					 for (int[] is : maze2d)
					 {
						 for (int i : is)
							 string.append(i + " ");
						 string.append("\n");
					 }
					 view.notify(string.toString());
				 }
			}
	}	
}
