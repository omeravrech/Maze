package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;


/**
* <h1>Generate 3D Maze Command Class</h1>
*<br> extends CommonCommand and execute the model's generate_3d_maze command.<br>
* it implements ICommand's doCommand method <br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/
public class Generate_3d_Maze extends CommonCommand {

	public Generate_3d_Maze(Model model, View view) 
	{
		super(model, view);
	}

	@Override
	public void doCommand(String[] commands) throws IOException
	{
		String name = commands[3];
		int floors = Integer.valueOf(commands[4]);
		int rows = Integer.valueOf(commands[5]);
		int columns =  Integer.valueOf(commands[6]);
		
		if ((floors*rows*columns <= 0) ||(floors > 99)|| (rows > 99) || (columns > 99))
			view.result("Invalid parameters");
		
		
			
		else
			model.generate_3d_maze(name, floors, rows, columns);
	}

}
