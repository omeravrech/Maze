package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;

public abstract class CommonCommand implements ICommand
{
	protected Model model;
	protected View view;
	
	/**
	 * Constructor
	 * @param model
	 * @param view
	 */
	public CommonCommand(Model model, View view) 
	{
		this.model = model;
		this.view = view;
	}


	@Override
	abstract public void doCommand(String[] args) throws IOException;

}
