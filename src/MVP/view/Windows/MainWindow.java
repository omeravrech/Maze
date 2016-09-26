package MVP.view.Windows;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import Algorithms.MazeGenerator.Maze3D;
import MVP.presenter.CommandData;

public class MainWindow extends BasicWindow
{
	private Button generateButton, loadButton, solveButton, hintButton, resetButton, exitButton;
	private CanvasMaze3D canvas;
	private String mazeName;
	
	public MainWindow(int hight, int width) {
		super("Poke'mon Maze Game", hight, width);
		mazeName = null;
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
		
		hintButton=(new Button(shell, SWT.PUSH));
		hintButton.setText("Hint");
		hintButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		resetButton=(new Button(shell, SWT.PUSH));
		resetButton.setText("Reset");
		resetButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		exitButton=(new Button(shell, SWT.PUSH));
		exitButton.setText("Exit");
		exitButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		generateButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
					showGenerateMazeMenu();
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
		
	}
	
	@Override
	public void print(String result)
	{
		// TODO Auto-generated method stub
		
	}
	
	public void showGenerateMazeMenu()
	{
		Shell localShell = new Shell(display , SWT.TITLE | SWT.SYSTEM_MODAL | SWT.CLOSE | SWT.MAX);
		localShell.setText("Generate New Maze");
		localShell.setSize(300, 300);
		
		GridLayout layout = new GridLayout(2, false);
		localShell.setLayout(layout);
		
		Label nameLabel = new Label(localShell, SWT.NONE);
		nameLabel.setText("Maze Name:");
		Text textName = new Text (localShell, SWT.BORDER);
		
		Label floorsLabel = new Label(localShell, SWT.NONE);
		floorsLabel.setText("Floors:");
		Text textFloors = new Text (localShell, SWT.BORDER);
			
		Label RowsLabel = new Label(localShell, SWT.NONE);
		RowsLabel.setText("Rows:");
		Text textRows = new Text (localShell, SWT.BORDER);
		
			
		Label columnLabel = new Label(localShell, SWT.NONE);
		columnLabel.setText("Columns:");
		Text textColumn = new Text (localShell, SWT.BORDER);
		
		Button generateBtn = new Button (localShell, SWT.PUSH);
		generateBtn.setText("Generate");
		generateBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				mazeName = textName.getText();
				String str = "generate 3d maze " + mazeName + " " + textFloors.getText() + " " + textRows.getText() + " " + textColumn.getText();
				setChanged();
				notifyObservers(new CommandData("generate 3d maze [A-Za-z0-9]+ [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}",str.split(" ")));
				localShell.close();
				
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		localShell.open();
	}
	@Override
	public void updateActiveMaze(Maze3D maze)
	{
		canvas.updateActiveMaze(maze);
	}
}
