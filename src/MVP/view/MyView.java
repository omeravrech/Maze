package MVP.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Observable;

public class MyView extends CommonView
{

	public MyView(BufferedReader in, PrintWriter out)
	{
		this.cli = new CLI(in, out);
		cli.addObserver(this);
	}

	@Override
	public void Result(String result)
	{
		cli.print(result);
	}

	@Override
	public void start()
	{
		cli.start();
	}

	@Override
	public void update(Observable o, Object args)
	{
		if (o == cli)
		{
			this.setChanged();
			this.notifyObservers(args);
		}
	}


}
