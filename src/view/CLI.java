package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import commands.ICommand;

public class CLI extends Thread
{
	private BufferedReader in;
	private PrintWriter out;
	private HashMap<String,ICommand> commands;
	private View view;
	
	public CLI(BufferedReader in, PrintWriter out, View view)
	{
		this.in = in;
		this.out = out;
		this.view = view;
	}
	
	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}

	public HashMap<String, ICommand> getCommands() {
		return commands;
	}

	public void setCommands(HashMap<String, ICommand> commands) {
		this.commands = commands;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public void start()
	{
		new Thread(new Runnable()
		{
			public void run()
			{
				String input;
				boolean commandFlag = false;
				String commandRegex = null;
				
				try
				{

					
					out.println("Enter your command:");
					while (!(input = in.readLine()).equals("exit"))
					{
						Iterator<String> regexIT = commands.keySet().iterator();
						while ((regexIT.hasNext()) && (!commandFlag))
						{
							commandRegex = regexIT.next();
							commandFlag = input.matches(commandRegex);
						}
						if (commandFlag)
						{
							out.println("Start to calculation your request...");
							view.operation(commandRegex);
						}
						else
						{
							out.println("'" + input.split(" ")[0] + "' is not recognized as an internal or external command.");
						}
						out.println("Enter your command:");
					}
					//TODO: EXIT
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}	
			}
		}).start();
	}
	
	public String displayMenu()
	{
		StringBuilder menu = new StringBuilder();
		int count = 1;
		
		for(String cmd: commands.keySet())
		{
			menu.append(count + ". " + cmd);
			count++;
		}
		return menu.toString();
	}

	public void print(String string)
	{
		System.out.println(string);
	}
}
