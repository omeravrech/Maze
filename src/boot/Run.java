package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controller.MyController;
import model.MyModel;
import view.MyView;

public class Run {

	public static void main(String[] args)
	{
		
		
		MyModel myModel = new MyModel();
		MyView myView = new MyView(new BufferedReader(new InputStreamReader(System.in)),new PrintWriter(System.out));
		MyController myController = new MyController(myModel, myView);
		
		myModel.setController(myController);
		myView.setController(myController);
		
		myController.setHashMap();
		
		myView.start();
		

	}

}
