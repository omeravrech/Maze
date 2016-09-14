package controller;

import java.io.IOException;
import java.util.HashMap;

import commands.ICommand;

public interface Controller
{
	HashMap<String, ICommand> getCommands();
	public void operationCommand(String command, String input) throws IOException;
	void notify(String message);
}
