package MVP.boot;

import java.beans.XMLDecoder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import MVP.model.MyModel;
import MVP.presenter.MyPresenter;
import MVP.presenter.Properties;
import MVP.view.MyView;

public class Run {

	public static void main(String[] args) 
	{
		
		Properties prop;
		XMLDecoder xmlDecoder = null;
		try
		{
			File file = new File("Maze\\Resources");
			System.out.println(file.exists());
			InputStream in = new FileInputStream(file);
			xmlDecoder = new XMLDecoder(in);
			Object object  = xmlDecoder.readObject();
			prop = (Properties)object;
		}
		catch (Exception e)
		{
			prop = new Properties();
			prop.setNumOfThreads(4);
			prop.setSolveMazeAlgorithm("DFS");
			prop.setGenerateMazeAlgorithm("Simpale");
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
				
		
		presenter.start();

	}

}
