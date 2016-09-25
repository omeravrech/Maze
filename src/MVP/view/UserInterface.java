package MVP.view;

import java.util.Observable;

public abstract class UserInterface extends Observable implements Runnable
{
	public abstract void run();
	public abstract void print(String result);
}
