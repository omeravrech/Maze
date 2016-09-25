package MVP.view.Windows;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;

public class MainWindow extends BasicWindow
{
	public MainWindow(int hight, int width) {
		super("Pokemon Maze Game", hight, width);
	}
	@Override
	void implementsWidgets()
	{
		
		Button generateButton, loadButton, solveButton;
		//GridLayout grid;
		//int buttonX = 200 , buttonY = 20;
		//Image welcomeImg;		
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		gridLayout.verticalSpacing = 5;
		gridLayout.horizontalSpacing = 5;
		shell.setLayout(gridLayout);
		

		generateButton = new Button(shell, SWT.PUSH);
		generateButton.setText("Create New");
		generateButton.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		loadButton = new Button(shell, SWT.PUSH);
		loadButton.setText("Load");
		loadButton.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_BEGINNING));

		solveButton = new Button(shell, SWT.PUSH);
		solveButton.setText("solve");
		solveButton.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_BEGINNING));
		
		/*Group dialogRight = new Group(shell, SWT.SHADOW_ETCHED_IN);
		dialogRight.setText("Game");
		dialogRight.setLayout(new GridLayout(2, false));
		dialogRight.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));*/
	}
	
	
	@Override
	public void print(String result)
	{
		// TODO Auto-generated method stub
		
	}
}
