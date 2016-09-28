package MVP.view.Windows;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
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

public class MainWindow extends BasicWindow implements Observer
{
	private Button generateButton, loadButton, solveButton, hintButton, exitButton;
	private CanvasMaze3D canvas;
	private String mazeName;
	public static String SOLUTION_ALGORITHM;
	private DialogWindow dw;
	
	public MainWindow(int hight, int width, Properties prop) {
		super("Poke'mon Maze Game", hight, width);
		mazeName = null;
		SOLUTION_ALGORITHM = prop.getSolveMazeAlgorithm();
	}
	
	
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
		
		exitButton = new Button(shell, SWT.PUSH);
		exitButton.setText("Exit");
		exitButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		generateButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				dw = new GenerateMazeDialog();
				dw.start(display);
				dw.addObserver(getObserver());
				solveButton.setEnabled(true);
				//hintButton.setEnabled(true);
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
				Position pos = canvas.getCurrentPosition().getPosition();
				String str = "solve " + mazeName + " " + SOLUTION_ALGORITHM + " by " + pos.floor() + " " + pos.row() + " " + pos.column();
				setChanged();
				notifyObservers(new CommandData("solve [A-Za-z0-9]+ [A-Za-z0-9]+ by [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}",str.split(" ")));
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void result(Object result)
	{
		if (result != null)
		{
			String objectClass = result.getClass().toString().toLowerCase();
			if (objectClass.contains("maze3d"))
			{
				canvas.updateActiveMaze((Maze3D)result);
			}
			else if (objectClass.contains("solution"))
			{
				canvas.updateSolution((Solution<Position>)result);
			}
		}
	}
	
	private Observer getObserver() { return this; }
	@Override
	public void update(Observable o, Object result)
	{
		if (o.getClass().toString().equals(GenerateMazeDialog.class.toString()))
			mazeName = ((CommandData)result).input[3];
		
		setChanged();
		notifyObservers(result);
	}
}
