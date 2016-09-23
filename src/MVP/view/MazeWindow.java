package MVP.view;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class MazeWindow extends BasicWindow 
{
	protected KeyListener keyListener;
	protected MazeDisplayAdapter mazePainterAdapter;
	protected MazeDisplayer mazePainter;
	protected GenerateWindow generatewindow;
	//protected MouseWheelListener mouseZoomlListener;
	protected MenuItem exit;
	protected String mazeName;
	protected Timer timer;
	protected TimerTask task;
	
	public MazeWindow(String title, int hight, int width) 
	{
		super(title, hight, width);
	}
	
	public MazeDisplayer getMaze()
	{
		return mazePainter;
	}

	@Override
	void initWidgets() 
	{
		this.shell.setLayout(new GridLayout(2, false));
		this.shell.setText("Game Window");

		// Bar menu
		Menu menuButton = new Menu(shell, SWT.BAR);
		this.shell.setMenuBar(menuButton);

		// File button in the bar
		MenuItem fileItem = new MenuItem(menuButton, SWT.CASCADE);
		fileItem.setText("&File");

		// Drop down functions for file button
		Menu subMenu = new Menu(shell, SWT.DROP_DOWN);
		fileItem.setMenu(subMenu);

		MenuItem properties = new MenuItem(subMenu, SWT.PUSH);
		properties.setText("Open Properties"); // Listener for load maze
		properties.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				FileDialog fd = new FileDialog(shell, SWT.OPEN);
				fd.setText("Open Properties");
				fd.setFilterPath("");
				String[] filterExt = { "*.txt", "*.java", "*.xml", "*.maze", "*.zip", "*.*" };
				fd.setFilterExtensions(filterExt);
				String selected = fd.open();
				//Testing the selected
				int counter = 0;
				char[] chen = selected.toCharArray();
				for (int i = 0; i < chen.length; i++) {
					if ("c".equals(chen[i])) {
						counter++;
					}
					System.out.println();
				}

				System.out.println(counter);

				String[] regexLine = { "load maze [^ \n]+ [A-Za-z0-9]+" };
				commands.add(regexLine); 
				setChanged();
				notifyObservers();
				commands.clear();

			}
		});

	}

}
