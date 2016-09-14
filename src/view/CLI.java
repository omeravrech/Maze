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
	private boolean flag = true;
	
	public CLI(BufferedReader in, PrintWriter out, View view)
	{
		this.in = in;
		this.out = out;
		this.view = view;
	}

	public HashMap<String, ICommand> getCommands() {
		return commands;
	}

	public void setCommands(HashMap<String, ICommand> commands) {
		this.commands = commands;
	}
	public void start()
	{
		new Thread(new Runnable()
		{
			public void run()
			{
				String input;
				boolean commandFlag;
				String commandRegex;
				
				try
				{		
					while (flag)
					{
						input = null;
						commandFlag = false;
						commandRegex = null;
						out.println(displayMenu());
						out.println("Enter your command: ");
						out.flush();
						input = in.readLine();
						
						Iterator<String> regexIT = commands.keySet().iterator();
						while ((regexIT.hasNext()) && (!commandFlag))
						{
							commandRegex = regexIT.next();
							commandFlag = input.matches(commandRegex);
						}
						if (commandFlag)
						{
							out.println("Start to calculation your request...");
							try
							{
								view.operationCommand(commandRegex, input);
							}
							catch (IOException e)
							{
								out.println(e.getMessage());
							}
						}
						else
						{
							out.println("'" + input.split(" ")[0] + "' is not recognized as an internal or external command.");
						}
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
			cmd = cmd.split(" ")[0];
			menu.append(count + ". " + cmd + "\n");
			count++;
		}
		return menu.toString();
	}

	public void print(String string)
	{
		System.out.println(string);
	}
	
	public void exit()
	{
		flag = false;
		out.println("Good bye!!!");
		out.flush();
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}
}
