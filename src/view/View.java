package view;

import java.io.IOException;

public interface View 
{
	public void start();
	public void operationCommand(String command, String input) throws IOException;
	public void setCommands();
	public void notify(String message);
}
