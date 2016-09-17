package MVP.presenter;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.PriorityQueue;

import MVC.commands.Generate_3d_maze;
import MVP.commands.ICommand;
import MVP.model.Model;
import MVP.view.View;

public class MyPresenter implements Observer, Presenter 
{
	protected Model model;
	protected View view;
	protected PriorityQueue<Request> operations;
	protected boolean runningStatus;
	Thread thread;
	
	public MyPresenter(Model model, View view)
	{
		this.model = model;
		this.view = view;
		this.operations = new PriorityQueue <Request>();
		runningStatus = true;
	}
	
	public void start()
	{
		thread = new Thread(new Runnable() {
			
			@Override
			public void run()
			{
				while(runningStatus)
				{
					if (operations.isEmpty())
						try {
							this.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					else
					{
						Request request = operations.remove();
						try {
							request.command.doCommand(request.getArgs());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
	}
	
	public void stop()
	{
		runningStatus = false;
	}
	@Override
	public void update(Observable o, Object arg)
	{
		Request request = (Request)arg;
		if (o == view)
			if ((request.command.getClass() == MVP.commands.Generate_3d_maze.class) ||
				(request.command.getClass() == MVP.commands.Solve.class) ||
				(request.command.getClass() == MVP.commands.Save_maze.class))
				request.setPriority(Priorities.HIGH);
			else
				request.setPriority(Priorities.LOW);
		else if (o == model)
			request.setPriority(Priorities.LOW);
		
		if(!thread.isAlive())
			thread.interrupt();
	}
}
