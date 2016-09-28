package MVP.boot;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import MVP.model.MyModel;
import MVP.presenter.MyPresenter;
import MVP.presenter.Properties;
import MVP.view.MyView;
import MVP.view.UserInterface;
import MVP.view.Windows.MainWindow;

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
			
		/*UserInterface ui = new CLI(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out, true));
		//*/UserInterface ui = new MainWindow(1000, 700, prop);	
				
		MyView view = new MyView(ui);
		MyModel model = new MyModel(prop);
		
		MyPresenter presenter = new MyPresenter(model, view);
		model.addObserver(presenter);
		view.addObserver(presenter);
		presenter.start();
		
	}

}
