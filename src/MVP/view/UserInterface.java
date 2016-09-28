package MVP.view;

import java.util.Observable;

public abstract class UserInterface extends Observable implements Runnable
{
	public abstract void run();
	public abstract void result(Object result);
	//public abstract void updateActiveMaze(Maze3D arg);
}
