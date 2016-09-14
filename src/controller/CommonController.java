package controller;

import java.io.IOException;
import java.util.HashMap;

import commands.ICommand;
import model.Model;
import view.View;

public abstract class CommonController implements Controller {

	protected Model model;
	protected View view;
	protected HashMap<String,ICommand> commands;
	
	public CommonController(View view, Model model)
	{
		this.view = view;
		this.model = model;
	}

	public void setCommands(HashMap<String, ICommand> commands) { this.commands = commands; }
	public HashMap<String, ICommand> getCommands() { return this.commands; }
	
	abstract protected void InitHashMap();
	abstract public void operationCommand(String command) throws IOException;
	abstract public void notify(Object msg);
}
