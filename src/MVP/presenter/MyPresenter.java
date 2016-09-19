package MVP.presenter;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutionException;

import MVP.commands.Dir;
import MVP.commands.Display;
import MVP.commands.Display_cross_section;
import MVP.commands.Display_solution;
import MVP.commands.Generate_3d_Maze;
import MVP.commands.ICommand;
import MVP.commands.Load_maze;
import MVP.commands.Save_maze;
import MVP.commands.Solve;
import MVP.model.Model;
import MVP.view.View;

public class MyPresenter implements Observer, Presenter 
{
	protected Model model;
	protected View view;
	private LinkedList<CommandData> requestList;
	private HashMap<String, ICommand> commands;
	protected boolean runningStatus;
	Thread thread;
	
	public MyPresenter(Model model, View view)
	{
		this.model = model;
		this.view = view;
		this.requestList = new LinkedList<CommandData>();
		this.runningStatus = true;

		/* Initializing the HashMap with the proper regex */
		commands = new HashMap<String,ICommand>();
		commands.put("dir [^ \n]+", new Dir(model,view));
		commands.put("generate 3d maze [A-Za-z0-9]+ [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}", new Generate_3d_Maze(model,view));
		commands.put("display [^ \n]+", new Display(model,view));
		commands.put("display cross section by [XYZxyz] [0-9]{1,2} for [A-Za-z0-9]+", new Display_cross_section(model, view));
		commands.put("save maze [A-Za-z0-9]+ [^ \n]+", new Save_maze(model,view));
		commands.put("load maze [^ \n]+ [A-Za-z0-9]+", new Load_maze(model,view));
		commands.put("solve [A-Za-z0-9]+ [A-Za-z0-9]+", new Solve(model,view));
		commands.put("display solution [A-Za-z0-9]+", new Display_solution(model, view));
		//commands.put("help", new ICommand Help(model,view);
	}
	
	public void start()
	{	
		thread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				while(runningStatus)
				{
					CommandData request = requestList.poll();
					try
					{
						if (request == null)
						{
							thread.suspend();
						}
						else
						{
							commands.get(request.getRegex()).doCommand(request.getInput());
							
						}
					}
					catch (IOException | InterruptedException | ExecutionException e)
					{
						// TODO Auto-generated catch block
						System.out.println("throw from Presenter thread");
						e.printStackTrace();
					} 
				}
			}
		});
		thread.setName("Presenter-Thread");
		thread.start();
		view.start();
	}

	@Override	
	public void update(Observable o, Object arg)
	{
		if (o == view)
			if (arg != null)
			{
				if (arg.toString().equals("exit"))
				{
					runningStatus = false;
					model.exit();
				}
				else
					requestList.add((CommandData)arg);
				thread.resume();
			}
		
		if (o == model)
		{
			view.Result(arg.toString());
		}
	}
}
