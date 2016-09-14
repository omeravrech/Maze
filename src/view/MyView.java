package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MyView extends CommonView
{
	public MyView(BufferedReader in, PrintWriter out) {
		this.cli = new CLI(in, out, this);
	}
	
	@Override
	public void start() {
		cli.start();
	}

	@Override
	public void operationCommand(String command, String input) throws IOException
	{
		controller.operationCommand(command, input);
	}

	@Override
	public void setCommands() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notify(String message)
	{
		cli.print(message.toString());
	}

	
	public void exit()
	{
		cli.exit();
	}
	
}
