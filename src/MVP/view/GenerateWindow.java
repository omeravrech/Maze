package MVP.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class GenerateWindow 
{
	private Button generateButton;
	Shell generateShell;
	Text nameText,heightText,rowText,columnText;
	
	
	public GenerateWindow(Shell shell) 
	{
		generateShell = new Shell(shell, SWT.TITLE | SWT.SYSTEM_MODAL | SWT.CLOSE | SWT.MAX);
		generateShell.setLayout(new GridLayout(2, false));
		generateShell.setSize(500, 200);
		
		generateShell.setText("Generate New Maze");
		generateShell.setLayout(new GridLayout(2, false));
		
		Group dialogs = new Group(generateShell, SWT.SHADOW_ETCHED_IN);
		dialogs.setText("Maze Generate Window" + " Properties");
		dialogs.setLayout(new GridLayout(2, true));
		dialogs.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		Label nameLabel = new Label(dialogs, SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1));
		nameLabel.setText("Maze Name: ");
		nameText = new Text(dialogs, SWT.None);
		nameText.setLayoutData(new GridData(SWT.NONE, SWT.TOP, false, true, 1, 1));

		Label floorLabel = new Label(dialogs, SWT.NONE);
		floorLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1));
		floorLabel.setText("Floors: ");
		heightText = new Text(dialogs, SWT.None);
		heightText.setLayoutData(new GridData(SWT.NONE, SWT.TOP, false, true, 1, 1));

		Label rowLabel = new Label(dialogs, SWT.NONE);
		rowLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1));
		rowLabel.setText("Rows: ");
		rowText = new Text(dialogs, SWT.None);
		rowText.setLayoutData(new GridData(SWT.NONE, SWT.TOP, false, true, 1, 1));

		Label columnLabel = new Label(dialogs, SWT.NONE);
		columnLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1));
		columnLabel.setText("Columns: ");
		columnText = new Text(dialogs, SWT.None);
		columnText.setLayoutData(new GridData(SWT.NONE, SWT.TOP, false, true, 1, 1));

		generateButton = new Button(dialogs, SWT.PUSH);
		generateButton.setText("Generate");
		generateButton.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, true, 1, 1));
		generateShell.setSize (300, 200);
		generateShell.open ();
	}
	
	public void setTriggerOk(SelectionListener listener)
	{
		generateButton.addSelectionListener(listener);
		
	}

}
