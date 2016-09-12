package controller;

import java.io.IOException;
import java.util.HashMap;

public interface Controller
{
	HashMap<String, ICommand> getCommands();
	public void operationCommand(String command) throws IOException;
	public void sendMessage(String msg);
}
