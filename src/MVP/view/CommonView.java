package MVP.view;

import java.util.Observable;
import java.util.Observer;

public abstract class CommonView extends Observable implements View, Observer
{
	protected CLI cli;
	protected String command;
	
	abstract public void start();
	abstract public void Result(String result);
	abstract public void update(Observable o, Object args);
}
