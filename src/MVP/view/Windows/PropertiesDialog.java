package MVP.view.Windows;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import MVP.presenter.Properties;

public class PropertiesDialog extends DialogWindow 
{

	Properties prop;
	
	
	
	public PropertiesDialog(Properties properties)
	{
		super(500, 160);
		this.prop = properties;
	}

	@Override
	protected void initWidgets()
	{
		Button[] algorithmRadio, mazeAlgorithmRadio;
		GridLayout layout = new GridLayout(3, true);
		this.shell.setLayout(layout);
		
		Label numOfThreadsLabel = new Label(this.shell, SWT.NONE);
		numOfThreadsLabel.setText("Number of threads:");
		Text textNumOfThreads = new Text (this.shell, SWT.BORDER);
		textNumOfThreads.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		StringBuilder sb = new StringBuilder();
		sb.append(prop.getNumOfThreads());
		textNumOfThreads.setText(sb.toString());
		
		Label mazePathLabel = new Label(this.shell, SWT.NONE);
		mazePathLabel.setText("Maze map path:");
		Text mazePath = new Text (this.shell, SWT.BORDER);
		mazePath.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		mazePath.setText(prop.getMazesMapPath());
		
		Label algorithmLabel = new Label(this.shell, SWT.NONE);
		algorithmLabel.setText("Solve algorithm:");
		algorithmRadio = new Button [2];
		
		algorithmRadio[0] = new Button (this.shell, SWT.RADIO);
		algorithmRadio[0].setText("BFS");
		if (prop.getSolveMazeAlgorithm().equalsIgnoreCase("BFS"))
			algorithmRadio[0].setSelection(true);
		algorithmRadio[1] = new Button (this.shell, SWT.RADIO);
		algorithmRadio[1].setText("DFS");
		if (prop.getSolveMazeAlgorithm().equalsIgnoreCase("DFS"))
			algorithmRadio[1].setSelection(true);
		
		algorithmRadio[0].setBounds(10, 75, 100, 30);
		algorithmRadio[1].setBounds(10, 75, 130, 30);
		
		
		Label mazeAlgorithmLabel = new Label(this.shell, SWT.NONE);
		mazeAlgorithmLabel.setText("Solve algorithm:");
		mazeAlgorithmRadio = new Button [2];
		
		mazeAlgorithmRadio[0] = new Button (this.shell, SWT.RADIO);
		mazeAlgorithmRadio[0].setText("Growing Tree");
		if (prop.getGenerateMazeAlgorithm().equalsIgnoreCase("Growing Tree"))
			mazeAlgorithmRadio[0].setSelection(true);
		mazeAlgorithmRadio[1] = new Button (this.shell, SWT.RADIO);
		mazeAlgorithmRadio[1].setText("Simple");
		if (prop.getGenerateMazeAlgorithm().equalsIgnoreCase("Simple"))
			mazeAlgorithmRadio[1].setSelection(true);
		
		mazeAlgorithmRadio[0].setBounds(10, 100, 100, 30);
		mazeAlgorithmRadio[1].setBounds(10, 100, 130, 30);
		
		Button button = new Button(this.shell, SWT.PUSH);
		button.setText("Save Properties");
		button.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,3,1));
		
		
		button.addSelectionListener(new SelectionListener()
		{
			
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				String str = null;
				for (Button b : algorithmRadio)
				{
					if (b.getSelection())
						str = b.getText();
				}
				if (str != null)
					prop.setSolveMazeAlgorithm(str);
				
				str=null;
				for (Button b : mazeAlgorithmRadio)
				{
					if (b.getSelection())
						str = b.getText();
				}
				if (str != null)
					prop.setGenerateMazeAlgorithm(str);
				int numOfThreads = Integer.parseInt(textNumOfThreads.getText());
				if (numOfThreads > 0)
					prop.setNumOfThreads(numOfThreads);
				String mazeMapPath = mazePath.getText();
				if (mazePath != null)
					prop.setMazesMapPath(mazeMapPath);
				
				setChanged();
				notifyObservers("setPropertiesFromXml");
				shell.close();
				
				
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});


	}

}
