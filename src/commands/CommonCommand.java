package commands;

import java.io.IOException;

import model.Model;
import view.View;

public abstract class CommonCommand implements ICommand 
{
	protected Model model;
	protected View view;

	public CommonCommand(View view, Model model)
	{
		this.model = model;
		this.view = view;
	}
	
	abstract public void doCommand(String[] args) throws IOException;
	
}
