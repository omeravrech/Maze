package MVP.commands;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface ICommand 
{
	public void doCommand(String[] args) throws IOException, InterruptedException, ExecutionException;
}
