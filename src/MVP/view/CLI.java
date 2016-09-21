package MVP.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Observable;

import MVP.presenter.CommandData;
/**
* <h1>CLI Class</h1>
*<br> This class handles the user's inputs.<br>
*it will read the input and throw errors if the command is not in the correct regex<br>
*and move forward the correct commands to the correct command 
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   15/09/2016 
*/
public class CLI extends Observable
{
	private BufferedReader in;
	private PrintWriter out;
	private HashMap<String,String> regexMap;
	/**
	 * Constructor
	 * @param in
	 * @param out
	 */
	public CLI(BufferedReader in, PrintWriter out)
	{
		this.in = in;
		this.out = out;
		
		this.regexMap = new HashMap<String,String>();
		regexMap.put("dir", "dir [^ \n]+");
		regexMap.put("generate", "generate 3d maze [A-Za-z0-9]+ [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}");
		regexMap.put("display maze", "display maze [^ \n]+");
		regexMap.put("display cross", "display cross section by [XYZxyz] [0-9]{1,2} for [A-Za-z0-9]+");
		regexMap.put("display solution", "display solution [A-Za-z0-9]+");
		regexMap.put("display mazes", "display mazes");
		regexMap.put("display solutions", "display solutions");
		regexMap.put("save", "save maze [A-Za-z0-9]+ [^ \n]+");
		regexMap.put("load", "load maze [^ \n]+ [A-Za-z0-9]+");
		regexMap.put("maze", "maze size [A-Za-z0-9]+");
		regexMap.put("file", "file size [A-Za-z0-9]+");
		regexMap.put("solve", "solve [A-Za-z0-9]+ [A-Za-z0-9]+");
		regexMap.put("help", "help");
		regexMap.put("exit", "exit");
	}
	/**
	*This method will be executed by new thread and handle<br>
	*the user's choice from the commands
	* @author  Omer Avrech & Bar Malka
	* @version 1.0
	* @since   15/09/2016 
	*/
	public void start() {

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try
				{
					String line = null;

					print("Enter your command: ");
					while (!(line = in.readLine()).equals("exit"))
					{
						boolean commandOk = false;
						String[] command = line.split(" ");
						String commandRegex = null;

						if (command[0].equals("display"))
							commandRegex = regexMap.get(command[0] + " " + command[1]);
						else
							commandRegex = regexMap.get(command[0]);

						commandOk = (commandRegex==null?false:line.matches(commandRegex));
						if (commandOk)
						{
							setChanged();
							notifyObservers(new CommandData(commandRegex, line.split(" ")));
						}

						else
							print("Invalid command: " + line + " " + "is undefined");
						print("Enter your command: ");
					}
					exit();
				}

				catch (Exception | Error e)
				{
					print(e.getMessage());
				}

			}
		});
		thread.setName("CLI-Thread");
		thread.start();
	}
	
	public void print(String string)
	{
		out.println(string);
		out.flush();
	}
	public void exit()
	{
		try
		{
			out.close();
			in.close();
			this.setChanged();
			this.notifyObservers("exit");
		}
		catch (IOException e)
		{
			print(e.getMessage());
		}
	}
}
