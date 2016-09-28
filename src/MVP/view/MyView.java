package MVP.view;

import java.util.Observable;

public class MyView extends CommonView
{
	
	public MyView(UserInterface ui)
	{
		super(ui);
		ui.addObserver(this);
	}

	@Override
	public void result(Object result)
	{
		ui.result(result);
	}

	@Override
	public void update(Observable o, Object args)
	{
		this.setChanged();
		this.notifyObservers(args);
	}
}
