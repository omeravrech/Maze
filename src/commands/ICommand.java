package commands;

import java.io.IOException;

public interface ICommand 
{
	public void doCommand(String[] args) throws IOException;
}
