package MVP.view;

import java.util.Observable;
import java.util.Observer;

public abstract class CommonView extends Observable implements View, Observer
{
	protected CLI cli;
	protected String command;
	protected MazeDisplayAdapter mazePainterAdapter;
	protected MazeWindow mazeWindow;
	
	public void setBasicWindow(MazeWindow mazeWindow) 
	{
		this.mazeWindow = mazeWindow;
	}
	public void setMazeDisplayAdapter(MazeDisplayAdapter mazePainterAdapter) 
	{
		this.mazePainterAdapter = mazePainterAdapter;
	}
	
	abstract public void start();
	abstract public void Result(String result);
	abstract public void update(Observable o, Object args);
	
	public void setCli(CLI cli)
	{
		this.cli = cli;
	}
}
