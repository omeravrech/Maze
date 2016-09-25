package MVP.view;

import java.util.HashMap;
import java.util.Observable;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import MVP.commands.ICommand;

public abstract class BasicWindow extends Observable implements Runnable
{
	protected Shell shell;
	protected Display display;
	protected HashMap<String,ICommand> commands;
	public BasicWindow(String title, int hight, int width)
	{
		display = new Display();
		shell = new Shell(display);
		shell.setSize(hight, width);
		shell.setText(title);
	}

	public Shell getShell()
	{
		return shell;
	}

	@Override
	public void run() 
	{
		initWidgets();
		shell.open();

		 while(!shell.isDisposed())
		 { 

		    
		    if(!display.readAndDispatch())
		    {
		       display.sleep(); 
		    }

		 } 

		 display.dispose();

	}
	
	abstract void initWidgets();


}
