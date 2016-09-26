package MVP.view.Windows;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;

public class MainWindow extends BasicWindow
{
	private Button generateButton, loadButton, solveButton, hintButton, resetButton, exitButton;
	private Canvas canvas;
	
	public MainWindow(int hight, int width) {
		super("Poke'mon Maze Game", hight, width);
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
		
		canvas = new Canvas(shell, SWT.CENTER);
		canvas.setBackgroundImage(new Image(display, "Resources/Graphics/welcomeImage.jpg"));
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
	}
	
	public void generateSelectionListener(SelectionListener listener)
	{
		generateButton.addSelectionListener(listener);
	};
	public void solveSelectionListener(SelectionListener listener)
	{
		solveButton.addSelectionListener(listener);
	};
	
	public void loadSelectionListener(SelectionListener listener)
	{
		loadButton.addSelectionListener(listener);
	};
	public void hintSelectionListener(SelectionListener listener)
	{
		hintButton.addSelectionListener(listener);
	};
	
	public void resetSelectionListener(SelectionListener listener)
	{
		resetButton.addSelectionListener(listener);
	};
	public void exitSelectionListener(SelectionListener listener)
	{
		exitButton.addSelectionListener(listener);
	};
	
	@Override
	public void print(String result)
	{
		// TODO Auto-generated method stub
		
	}
}
