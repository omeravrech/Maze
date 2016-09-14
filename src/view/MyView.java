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
	public void operation(String regex) throws IOException
	{
		controller.operationCommand(regex);
	}

	@Override
	public void setCommands() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnedMessage(Object msg)
	{
		cli.print(msg.toString());
	}
	
	
	
	
}
