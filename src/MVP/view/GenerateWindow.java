package MVP.view;

import java.awt.GridLayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
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
		generateShell.setLayout(new org.eclipse.swt.layout.GridLayout(2, false));
		generateShell.setSize(500, 200);
	}

}
