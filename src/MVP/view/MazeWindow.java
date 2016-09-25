/*package MVP.view;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import MVP.presenter.CommandData;
import MVP.view.Windows.BasicWindow;
import MVP.view.Windows.GenerateMazeWindow;

public class MazeWindow extends BasicWindow 
{
	protected KeyListener keyListener;
	protected MazeDisplayAdapter mazePainterAdapter;
	protected MazeDisplayer mazePainter;
	protected GenerateMazeWindow generateWindow;
	protected MouseWheelListener mouseZoomlListener;
	protected MenuItem exit;
	protected String mazeName;
	protected Timer timer;
	protected Clip music;
	protected Clip sound;
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
		properties.addListener(SWT.Selection, new Listener() 
		{

			@Override
			public void handleEvent(Event arg0)
			{
				FileDialog fd = new FileDialog(shell, SWT.OPEN);
				fd.setText("Open Properties");
				fd.setFilterPath("");
				String[] filterExt = { "*.java", "*.txt", "*.maze", "*.xml", "*.zip", "*.*" };
				fd.setFilterExtensions(filterExt);
				String selected = fd.open();
				//Testing the selected
				int counter = 0;
				char[] chen = selected.toCharArray();
				for (int i = 0; i < chen.length; i++) 
				{
					if ("c".equals(chen[i])) 
					{
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
		// load maze button in the sub menu
				MenuItem LoadMaze = new MenuItem(subMenu, SWT.PUSH);
				LoadMaze.setText("LoadMaze\tCtrl+L");
				// Listener for load maze
				LoadMaze.addListener(SWT.Selection, new Listener() {

					@Override
					public void handleEvent(Event arg0) {
						System.out.println("Select All");

					}
				});
				// Save maze button in the sub menu
				MenuItem SaveMaze = new MenuItem(subMenu, SWT.PUSH);
				SaveMaze.setText("SaveMaze\tCtrl+S");
				// Listener for save maze
				SaveMaze.addListener(SWT.Selection, new Listener() {

					@Override
					public void handleEvent(Event arg0) {
						System.out.println("Select All");

					}
				});

				// exit maze button in the sub menu
				exit = new MenuItem(subMenu, SWT.PUSH);
				exit.setText("EXIT");
				// Listener for exit maze

				exit.addListener(SWT.Selection, new Listener() {

					@Override
					public void handleEvent(Event arg0) {
						commands.add("exit".split("\b"));
						commands.add("null".split("\b"));
						commands.add("null".split("\b"));
						setChanged();
						notifyObservers();
						mazePainterAdapter.mazePainter.close = true;
						
					}
				});

				
				// Help button in the bar
				MenuItem helpItem = new MenuItem(menuButton, SWT.CASCADE);
				helpItem.setText("&Help");
				// Drop down functions for help button
				Menu subMenu1 = new Menu(shell, SWT.DROP_DOWN);
				helpItem.setMenu(subMenu1);

				MenuItem item = new MenuItem(subMenu1, SWT.PUSH);
				item.addListener(SWT.Selection, new Listener() {

					@Override
					public void handleEvent(Event arg0) {
						System.out.println("Select All");

					}
				});
				MenuItem item1 = new MenuItem(subMenu, SWT.PUSH);
				item1.addListener(SWT.Selection, new Listener() {

					@Override
					public void handleEvent(Event arg0) {
						System.out.println("Select All");

					}
				});

				Button generateButton = new Button(shell, SWT.PUSH);
				generateButton.setText("Generate");
				generateButton.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 1, 1));

				generateButton.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent arg0) {
						generateWindow = new GenerateMazeWindow(shell);
						generateWindow.setTriggerOk(new SelectionListener() {

							@Override
							public void widgetSelected(SelectionEvent arg0) {
								/*String[] generateline = { "generate", "3d", "maze", generateWindow.nameText.getText(),
										generateWindow.heightText.getText(), generateWindow.rowText.getText(),
										generateWindow.columnText.getText() };
								mazeName = generateWindow.nameText.getText();
								
								StringBuilder sb = new StringBuilder();
								sb.append("generate 3d maze " + generateWindow.nameText + " " +
										generateWindow.heightText + " " +
										generateWindow.rowText.getText() + " " + generateWindow.columnText.getText());
								String regex = ("generate 3d maze [A-Za-z0-9]+ [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}");
								
								setChanged();
								notifyObservers(new CommandData(regex, sb.toString().split(" ")));
								
								//commands.add(regex);
								//commands.add(generateline);
								mazePainterAdapter.in = true;
								//setChanged();
								//notifyObservers();
								mazePainterAdapter.in = false;
								//commands.clear();
								generateWindow.generateShell.close();
								// mazeCanvas.mazePainter.redraw();
								mazePainterAdapter.mazePainter.setFocus();

							}

							@Override
							public void widgetDefaultSelected(SelectionEvent arg0)
							{
								
							}

						});
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) 
					{

					}
				});

				mazePainter.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 3));
				mazePainterAdapter = new MazeDisplayAdapter(mazePainter);
				System.out.println("fffg");
				Button solve = new Button(shell, SWT.PUSH);
				solve.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false, 1, 1));
				solve.setText("solve");
				solve.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						//*String[] line = ("solve" + " " + mazeName + " " + "airdistance").split(" ");
						String[] regexSolve = { "solve [A-Za-z0-9]+ [A-Za-z0-9]+" };
						commands.add(regexSolve);
						commands.add(line);
						mazePainterAdapter.in = false;
						StringBuilder sb = new StringBuilder();
						sb.append("solve " + mazeName + "BFS");
						String regex = "solve [A-Za-z0-9]+ [A-Za-z0-9]+";
						
						notifyObservers(new CommandData(regex, sb.toString().split(" ")));
						setChanged();
						notifyObservers();
						mazePainterAdapter.in = true;
					}
				});

				Button music = new Button(shell, SWT.PUSH);
				music.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false, 1, 1));
				music.setText("music");
				music.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent arg0) {
						playMusic(new File("backgroundMusic.wav"));

					}

					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) 
					{

					}
				});
				mouseZoomlListener = new MouseWheelListener() {

					@Override
					public void mouseScrolled(MouseEvent e) {
						// if both ctrl and wheel are being operated
						if ((e.stateMask & SWT.CTRL) != 0)
							mazePainterAdapter.mazePainter.setSize(mazePainterAdapter.mazePainter.getSize().x + e.count,
									mazePainterAdapter.mazePainter.getSize().y + e.count);

					}
				};
				shell.addMouseWheelListener(mouseZoomlListener);
				mazePainterAdapter.mazePainter.addKeyListener(new KeyListener() {

					@Override
					public void keyReleased(KeyEvent s) 
					{

					}

					@Override
					public void keyPressed(KeyEvent e) {
						if (e.keyCode == SWT.ARROW_UP)
							mazePainterAdapter.mazePainter.moveCharacterUp();
						if (e.keyCode == SWT.ARROW_DOWN)
							mazePainterAdapter.mazePainter.moveCharacterDown();
						if (e.keyCode == SWT.ARROW_LEFT)
							mazePainterAdapter.mazePainter.moveCharacterLeft();
						if (e.keyCode == SWT.ARROW_RIGHT)
							mazePainterAdapter.mazePainter.moveCharacterRight();
						if (e.keyCode == SWT.PAGE_UP)
							mazePainterAdapter.mazePainter.moveCharacterForward();
						if (e.keyCode == SWT.PAGE_DOWN)
							mazePainterAdapter.mazePainter.moveCharacterBackward();
					}
				});
	
	// mazePainter.setMaze(maze3d);
			shell.setSize(1300, 800);
			shell.open();

			
			shell.addDisposeListener(new DisposeListener()
			{

				@Override
				public void widgetDisposed(DisposeEvent e) 
				{

				}
			});
			shell.addKeyListener(new KeyListener() {

				@Override
				public void keyReleased(KeyEvent arg0) 
				{

				}

				@Override
				public void keyPressed(KeyEvent e)
				{
					if (e.keyCode == SWT.CLOSE) {
						commands.add("exit".split("\b"));
						commands.add("null".split("\b"));
						commands.add("null".split("\b"));
						setChanged();
						notifyObservers();
						mazePainterAdapter.mazePainter.close = true;
						// mazePainter.getDisplay().getThread().;
						shell.dispose();
						// shell.getDisplay().dispose();
					}

				}
			});

		}
	
	private void playMusic(File file) {

		try {
			music = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem
					.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			music.open(inputStream);
			// loop infinitely
			music.setLoopPoints(0, -1);
			music.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setMazePainter(MazeDisplayer mazePainter)
	{
		this.mazePainter = mazePainter;
	}
	
}
*/