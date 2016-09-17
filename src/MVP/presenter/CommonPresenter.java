package MVP.presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import MVP.commands.ICommand;
import MVP.model.Model;
import MVP.view.View;

public abstract class CommonPresenter implements Observer, Presenter 
{
	protected Model model;
	protected View view;
	protected HashMap<Observable,ICommand> operations;
	protected ExecutorService threadPool;
	
	public CommonPresenter(Model model, View view)
	{
		this.model = model;
		this.view = view;
		this.threadPool = Executors.newCachedThreadPool();
		this.operations = new HashMap <Observable,ICommand>();
	}




	@Override
	abstract public void update(Observable o, Object arg);
	
	

}
