package MVP.view;

import java.util.Observable;
import Algorithms.MazeGenerator.Maze3D;

public class MyView extends CommonView
{
	
	public MyView(UserInterface ui)
	{
		super(ui);
		ui.addObserver(this);
	}

	@Override
	public void Result(String result)
	{
		ui.print(result);
	}

	@Override
	public void update(Observable o, Object args)
	{
		this.setChanged();
		this.notifyObservers(args);
	}
	@Override
	public void updateActiveMaze(Maze3D maze)
	{
		ui.updateActiveMaze(maze);
	}
}
