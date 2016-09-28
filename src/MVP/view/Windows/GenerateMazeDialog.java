package MVP.view.Windows;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import MVP.presenter.CommandData;

public class GenerateMazeDialog extends DialogWindow {

	public GenerateMazeDialog()
	{
		super(300, 200);
	}

	@Override
	protected void initWidgets()
	{
		GridLayout layout = new GridLayout(2, false);
		this.shell.setLayout(layout);
		
		Label nameLabel = new Label(this.shell, SWT.NONE);
		nameLabel.setText("Maze Name:");
		Text textName = new Text (this.shell, SWT.BORDER);
		
		Label floorsLabel = new Label(this.shell, SWT.NONE);
		floorsLabel.setText("Floors:");
		Text textFloors = new Text (this.shell, SWT.BORDER);
			
		Label RowsLabel = new Label(this.shell, SWT.NONE);
		RowsLabel.setText("Rows:");
		Text textRows = new Text (this.shell, SWT.BORDER);
			
		Label columnLabel = new Label(this.shell, SWT.NONE);
		columnLabel.setText("Columns:");
		Text textColumn = new Text (this.shell, SWT.BORDER);
		
		Button generateBtn = new Button (this.shell, SWT.PUSH);
		generateBtn.setText("Generate");
		generateBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				String str = "generate 3d maze " + textName.getText() + " " + textFloors.getText() + " " + textRows.getText() + " " + textColumn.getText();
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
