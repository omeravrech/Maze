package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controller.CommonController;
import controller.MyController;
import model.CommonModel;
import model.MyModel;
import view.CommonView;
import view.MyView;

public class Run {

	/**
	* <h1>Run class</h1>
	*
	* @author  Omer Avrech & Bar Malka
	* @version 1.0
	* @since   15/09/2016 
	*/
	public static void main(String[] args)
	{
		CommonModel model = new MyModel();
		CommonView view = new MyView(new BufferedReader(new InputStreamReader(System.in)),new PrintWriter(System.out));
		CommonController myController = new MyController(view, model);
		
		model.setController(myController);
		view.setController(myController);
		
		view.start();
		

	}

}
