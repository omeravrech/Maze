package MVP.view.Windows;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.Search.Solution;
import MVP.presenter.CommandData;
import MVP.presenter.Properties;


/**
* <h1>MainWindow class</h1>
*<br>extends BasicWindow and implements Observer<br>
*This window holds all the menu, display the different options for the user
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   28/09/2016 
*
*/
public class MainWindow extends BasicWindow implements Observer
{
	private Button generateButton, loadButton, solveButton, hintButton, exitButton,propertiesButton;
	private MazeDisplay canvas;
	private String mazeName;
	public static String SOLUTION_ALGORITHM;
	private DialogWindow dw;
	private boolean isHint;
	
	/**
	 * Constructor
	 * @param hight int
	 * @param width int
	 * @param prop Properties
	 */
	public MainWindow(int hight, int width, Properties prop) {
		super("Poke'mon Maze Game", hight, width);
		mazeName = null;
		SOLUTION_ALGORITHM = prop.getSolveMazeAlgorithm();
	}
	
	/**
	 * Initializing the widgets
	 */
	@Override	
	void implementsWidgets()
	{		
		GridLayout gridLayout = new GridLayout(2,false);
		gridLayout.marginHeight = 5;
		shell.setLayout(gridLayout);
		
		generateButton = new Button(shell, SWT.PUSH);
		generateButton.setText("Generate");
		generateButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		//Canvas(shell, SWT.CENTER)
		canvas = new CanvasMaze3D(shell, SWT.CENTER);
		canvas.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,6));
		canvas.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e)
			{
				switch (e.keyCode)
				{
					case SWT.ARROW_UP:
						canvas.moveForward();
						break;
					case SWT.ARROW_DOWN:
						canvas.moveBackward();
						break;
					case SWT.ARROW_LEFT:
						canvas.moveLeft();
						break;
					case SWT.ARROW_RIGHT:
						canvas.moveRight();
						break;
					case SWT.PAGE_UP:
						canvas.moveUp();
						break;
					case SWT.PAGE_DOWN:
						canvas.moveDown();
						break;
					default:
						break;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		

		
		loadButton = new Button(shell, SWT.PUSH);
		loadButton.setText("Load");
		loadButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		solveButton = new Button(shell, SWT.PUSH);
		solveButton.setText("Solve");
		solveButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		solveButton.setEnabled(false);
		
		hintButton=new Button(shell, SWT.PUSH);
		hintButton.setText("Hint");
		hintButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		hintButton.setEnabled(false);
		hintButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				Position pos = canvas.character;
				String str = "solve " + mazeName + " " + SOLUTION_ALGORITHM + " by " + pos.floor() + " " + pos.row() + " " + pos.column();
				setChanged();
				notifyObservers(new CommandData("solve [A-Za-z0-9]+ [A-Za-z0-9]+ by [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}",str.split(" ")));
				isHint = true;
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		propertiesButton = new Button(shell, SWT.PUSH);
		propertiesButton.setText("Properties");
		propertiesButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		exitButton = new Button(shell, SWT.PUSH);
		exitButton.setText("Exit");
		exitButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		
		
		propertiesButton.addSelectionListener(new SelectionListener()
		{
			
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				properties = null;
				setChanged();
				notifyObservers("getPropertiesFromXml");

				while (properties == null);
				dw = new PropertiesDialog(properties);
				dw.addObserver(getObserver());
				dw.start(display);
								
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		generateButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				dw = new GenerateMazeDialog();
				dw.start(display);
				dw.addObserver(getObserver());
				solveButton.setEnabled(true);
				hintButton.setEnabled(true);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		loadButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				dw = new LoadDialog(200,500);
				dw.start(display);
				dw.addObserver(getObserver());
				solveButton.setEnabled(true);
				hintButton.setEnabled(true);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		exitButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				shell.close();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		solveButton.addSelectionListener(new SelectionListener() {
	
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				Position pos = canvas.character;
				String str = "solve " + mazeName + " " + SOLUTION_ALGORITHM + " by " + pos.floor() + " " + pos.row() + " " + pos.column();
				setChanged();
				notifyObservers(new CommandData("solve [A-Za-z0-9]+ [A-Za-z0-9]+ by [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}",str.split(" ")));
				isHint = false;
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void solve (Solution<Position> solution)
	{

		Stack<Position> pathToGoal = solution.getResult();
		if (isHint)
		{
			canvas.getDisplay().syncExec(new Runnable() {

				@Override
				public void run() {
					Position pos = pathToGoal.pop();
					pos = pathToGoal.pop();
					if (canvas.character.floor() != pos.floor())
						pos = pathToGoal.pop();
					canvas.setCharacterPosition(pos.floor(), pos.row(), pos.column());
				}
			});
		}
		else
		{
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				
				@Override
				public void run() {
					canvas.getDisplay().syncExec(new Runnable() {
						
						@Override
						public void run() {
							if (pathToGoal.isEmpty())
								timer.cancel();
							else
							{
								Position pos = pathToGoal.pop();
								if (canvas.character.floor() != pos.floor())
									pos = pathToGoal.pop();
								canvas.setCharacterPosition(pos.floor(), pos.row(), pos.column());
								//canvas.redraw();
							}
						}
					});
					
				}
			};
			timer.scheduleAtFixedRate(task, 0, 500);
		}
	}
	
	/**
	 * Implementing result function (abstract)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void result(Object result)
	{
		if (result != null)
		{
			String objectClass = result.getClass().toString().toLowerCase();
			if (objectClass.contains("maze3d"))
			{
				canvas.setMazeData((Maze3D)result);
			}
			else if (objectClass.contains("solution"))
			{
				solve((Solution<Position>)result);
			}
		}
	}
	
	/** Getter */
	private Observer getObserver() { return this; }
	
	
	
	
	/**
	 * updates the maze name if the user generated a maze from the dialog
	 */
	@Override
	public void update(Observable o, Object result)
	{
		if ((o.getClass() == GenerateMazeDialog.class) || (o.getClass() == LoadDialog.class))
			mazeName = ((CommandData)result).input[3];
		
		setChanged();
		notifyObservers(result);
	}
}
