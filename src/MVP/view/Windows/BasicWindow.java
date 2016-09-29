package MVP.view.Windows;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import MVP.view.UserInterface;


/**
* <h1>Basic Window class</h1>
*<br> This is the baseclass for every window in the GUI part<br>
* it receives the wanted title for the window, its width and height <br>
* it extends from our UserInterface class that extends Observable and implements Runnable
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   28/09/2016 
*
*/
public abstract class BasicWindow extends UserInterface 
{
	protected Shell shell;
	protected Display display;
	private int height;
	private int width;
	private String title;
	
	/**
	 * Constructor for BasicWindow
	 * @param1 String title
	 * @param2 int height
	 * @param3 int width
	 */
	public BasicWindow(String title, int height, int width)
	{
			this.title = title;
			this.height = height;
			this.width = width;
	}
	
	
	abstract void implementsWidgets();
	
	/**
	 * This class implement runnable, therefore it has to implement <br>
	 * Run method, it will define the properties of the shell (window) <br>
	 * and wait until the shell is closed.
	 */
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
