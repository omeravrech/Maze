package controller;

import java.io.IOException;

public interface ICommand 
{
	void doCommand(String[] commands) throws IOException;
	public void returnedMessage(Object msg);

}
