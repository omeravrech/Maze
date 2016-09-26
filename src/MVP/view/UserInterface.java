package MVP.view;

import java.util.Observable;

import Algorithms.MazeGenerator.Maze3D;

public abstract class UserInterface extends Observable implements Runnable
{
	public abstract void run();
	public abstract void print(String result);
	public abstract void updateActiveMaze(Maze3D arg);
}
