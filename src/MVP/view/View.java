package MVP.view;

import Algorithms.MazeGenerator.Maze3D;

public interface View
{
	public void start();
	 public void Result(String result);
	public void updateActiveMaze(Maze3D arg);
}
