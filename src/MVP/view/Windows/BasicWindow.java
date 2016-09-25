package MVP.view.Windows;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import MVP.view.UserInterface;

public abstract class BasicWindow extends UserInterface 
{
	protected Shell shell;
	protected Display display;
	
	public BasicWindow(String title, int hight, int width)
	{
		//this.display = new Display();
		//this.shell = new Shell(this.display);//, SWT.TITLE | SWT.SYSTEM_MODAL | SWT.CLOSE | SWT.MAX);
		//this.shell.setSize(hight, width);
		//this.shell.setText(title);
	}

	abstract void implementsWidgets();
	
	@Override
	public void run() 
	{
		display = new Display();
		shell = new Shell(display);
		implementsWidgets();	
		shell.open();	
		
		// main event loop
		while(!shell.isDisposed()){ // window isn't closed
			if(!display.readAndDispatch())
			{
				display.sleep();
			}
		}
		display.dispose();
	}
}
