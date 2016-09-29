package MVP.view.Windows;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;

import MVP.presenter.CommandData;


/**
* <h1>Load Dialog class</h1>
*<br>Load dialog will present a small window with radio button<br>
* The buttons will display the saved mazes so the user can load them.
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   28/09/2016 
*
*/
public class LoadDialog extends DialogWindow {
	
	/**
	 * Constructor
	 * @param width int
	 * @param height int
	 */
	public LoadDialog(int width, int height) {
		super(width, height);
	}
	
	
	/**
	 * Initializing the widgets of the window
	 */
	@Override
	protected void initWidgets()
	{
		Button radio[];
		GridLayout layout = new GridLayout(1, false);
		this.shell.setLayout(layout);
		String[] files = new File("Resources/Mazes").list();
		radio = new Button[files.length];
		int i = 10;
		for (String string : files)
		{
			radio[i/25] = new Button(shell, SWT.RADIO);
			radio[i/25].setSelection(false);
			radio[i/25].setText(string.substring(0, string.indexOf(".")));
			radio[i/25].setBounds(10, i, 100, 30);
			i+=25;
		}
		Button button = new Button(shell, SWT.PUSH);
		button.setText("Load");
		button.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				String str = "";
				for (Button b : radio)
				{
					if (b.getSelection())
						str = "generate 3d maze " + b.getText() + " 1 1 1";
				}
					setChanged();
					notifyObservers(new CommandData("generate 3d maze [A-Za-z0-9]+ [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}",str.split(" ")));
					shell.close();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
