package MVP.view.Windows;

import java.util.Observable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class DialogWindow extends Observable
{
	protected Shell shell;
	protected String returnedString;
	protected int width;
	protected int height;
	
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
