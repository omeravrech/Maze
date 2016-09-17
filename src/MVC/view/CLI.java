package MVC.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import MVC.commands.ICommand;
/**
* <h1>CLI Class</h1>
*<br> This class handles the user's inputs.<br>
*it will read the input and throw errors if the command is not in the correct regex<br>
*and move forward the correct commands to the correct command 
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   15/09/2016 
*/
public class CLI extends Thread
{
	private BufferedReader in;
	private PrintWriter out;
	private HashMap<String,ICommand> commands;
	private View view;
	private boolean flag = true;
	/**
	 * Constructor
	 * @param in
	 * @param out
	 * @param view
	 */
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

	/**
	*This method will be executed by new thread and handle<br>
	*the user's choice from the commands
	* @author  Omer Avrech & Bar Malka
	* @version 1.0
	* @since   15/09/2016 
	*/
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
							try
							{
								view.operationCommand(commandRegex, input);
							}
							catch (IOException e)
							{
								out.println(e.getMessage());
							}
							catch (IndexOutOfBoundsException e)
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
	/**
	 * This method prints the menu of commands to the user
	 */
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
