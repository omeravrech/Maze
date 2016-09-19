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
		regexMap.put("display", "display [^ \n]+");
		regexMap.put("display cross", "display cross section by [XYZxyz] [0-9]{1,2} for [A-Za-z0-9]+");
		regexMap.put("save", "save maze [A-Za-z0-9]+ [^ \n]+");
		regexMap.put("load", "load maze [^ \n]+ [A-Za-z0-9]+");
		regexMap.put("maze", "maze size [A-Za-z0-9]+");
		regexMap.put("file", "file size [A-Za-z0-9]+");
		regexMap.put("solve", "solve [A-Za-z0-9]+ [A-Za-z0-9]+");
		regexMap.put("display solution", "display solution [A-Za-z0-9]+");
		regexMap.put("help", "help");
	}
	/**
	*This method will be executed by new thread and handle<br>
	*the user's choice from the commands
	* @author  Omer Avrech & Bar Malka
	* @version 1.0
	* @since   15/09/2016 
	*/
	public void start() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				print("Enter your command: ");
				try {
					String line = null;

					while (!(line = in.readLine()).equals("exit"))
					{
						boolean commandOk = false;
						String[] command = line.split(" ");
						String commandRegex = null;
						
						if (command[0].equals("display") && (command.length > 1))
						{
							try
							{
								if(command[1].equals("cross") || command[1].equals("solution")){
									commandRegex = regexMap.get(command[0] + " " + command[1]);
									commandOk = line.matches(commandRegex);
								}
								else{
									commandRegex = regexMap.get(command[0]);
									commandOk = line.matches(commandRegex);	
								}
							}
							catch(Error e)
							{
								print(e.getMessage());
							}
						}
						else{
							commandRegex = regexMap.get(command[0]);
							commandOk = (commandRegex==null?false:line.matches(commandRegex));
							
						}

						if (commandOk)
						{
							setChanged();
							notifyObservers(new CommandData(commandRegex, line.split(" ")));
						}

						else
							print("sorry your command: " + line + " " + "undefined");
						print("Enter your command: ");
					}
					exit();
				}

				catch (IOException | Error e)
				{
					print(e.getMessage());
				}

			}
		}).start();
	}
	
	public void print(String string)
	{
		out.println(string);
		out.flush();
	}
	public void exit()
	{
		print("Good bye!!!");
		try
		{
			out.close();
			in.close();
		}
		catch (IOException e)
		{
			print(e.getMessage());
		}
	}
}
