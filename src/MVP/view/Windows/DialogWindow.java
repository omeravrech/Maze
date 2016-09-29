package MVP.view.Windows;

import java.util.Observable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


/**
* <h1>CurrentPosition class</h1>
*<br>An abstract class that extends Observable, in charge of small dialogs<br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   28/09/2016 
*
*/
public abstract class DialogWindow extends Observable
{
	protected Shell shell;
	protected String returnedString;
	protected int width;
	protected int height;
	
	/**
	 * Constructor
	 * @param width int
	 * @param height int
	 */
	public DialogWindow(int width, int height)
	{ 
		returnedString = "";
		this.width = width;
		this.height = height;
	}
	
	protected abstract void initWidgets();
	
	public String start(Display display)
	{		
		shell = new Shell(display, SWT.TITLE | SWT.SYSTEM_MODAL | SWT.CLOSE | SWT.MAX);
		shell.setSize(width, height);
		
		initWidgets();
		shell.open();	
		return returnedString;
	}
}
