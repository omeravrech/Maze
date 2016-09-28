package MVP.view.Windows;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import MVP.view.UserInterface;

public abstract class BasicWindow extends UserInterface 
{
	protected Shell shell;
	protected Display display;
	private int height;
	private int width;
	private String title;
	
	public BasicWindow(String title, int height, int width)
	{
			this.title = title;
			this.height = height;
			this.width = width;
	}

	abstract void implementsWidgets();
	
	@Override
	public void run() 
	{
		try
		{
			display = new Display();
			shell = new Shell(display , SWT.TITLE | SWT.SYSTEM_MODAL | SWT.CLOSE | SWT.MAX | SWT.RESIZE);
			shell.setSize(height, width);
			shell.setText(title);
			
			implementsWidgets();
			
			shell.open();
			// main event loop
			while(!shell.isDisposed())
			{ // window isn't closed
				if(!display.readAndDispatch())
				{
					display.sleep();
				}
			}

			display.dispose();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			setChanged();
			notifyObservers("exit");
		}
	}
}
