package commands;

import java.io.IOException;

public interface ICommand 
{
	public void doCommand(String[] commands) throws IOException;
}
