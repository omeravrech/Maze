package MVP.boot;

import java.beans.XMLDecoder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.eclipse.swt.SWT;

import MVP.model.MyModel;
import MVP.presenter.MyPresenter;
import MVP.presenter.Properties;
import MVP.view.CLI;
import MVP.view.Maze2D;
import MVP.view.MazeDisplayAdapter;
import MVP.view.MazeWindow;
import MVP.view.MyView;

public class Run {

	public static void main(String[] args) 
	{
		
		Properties prop;
		XMLDecoder xmlDecoder = null;
		try
		{
			File file = new File("Resources/properties.xml");
			InputStream in = new FileInputStream(file);
			xmlDecoder = new XMLDecoder(in);
			prop  = (Properties)xmlDecoder.readObject();
		}
		catch (Exception e)
		{
			prop = new Properties();
			prop.setNumOfThreads(4);
			prop.setSolveMazeAlgorithm("DFS");
			prop.setGenerateMazeAlgorithm("Simpale");
			prop.setSolutionMapPath("Resources/SolutionMap.zip");
			prop.setMazesMapPath("Resources/Mazes");
		}
		finally
		{
			xmlDecoder.close();
		}
			
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
				
		MyView view = new MyView(in, out);
		MyModel model = new MyModel(prop);
		
		MyPresenter presenter = new MyPresenter(model, view, prop);
		model.addObserver(presenter);
		view.addObserver(presenter);
		CLI cli = new CLI(new BufferedReader(new InputStreamReader(System.in)),
				new PrintWriter(System.out, true));
		//presenter.start();
		MazeWindow gui = new MazeWindow("GameWindow", 500, 300);
		MazeDisplayAdapter painter = new MazeDisplayAdapter( new Maze2D(gui.getShell(), SWT.BORDER | SWT.DOUBLE_BUFFERED));
		gui.setMazePainter(painter.getMazeDisplayer());
		view.setMazeDisplayAdapter(painter);
		view.setBasicWindow(gui);
		painter.addObserver(view);
		gui.addObserver(view);
		cli.addObserver(view);
		view.setCli(cli);
		gui.run();
	}

}
