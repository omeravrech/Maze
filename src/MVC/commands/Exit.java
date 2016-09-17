package MVC.commands;

import java.io.IOException;

import MVC.model.Model;
import MVC.view.View;

/**
 * Will kill all the threads of the model and view so the program will stop
 */
public class Exit extends CommonCommand
{
	/**
	 * Constructor
	 * @param view
	 * @param model
	 */
	public Exit(View view, Model model) 
	{
		super(view, model);
	}
	
	@Override
	public void doCommand(String[] commands) throws IOException
	{
		model.exit();
		view.exit();
	}

}
