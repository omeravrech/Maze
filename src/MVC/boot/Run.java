package MVC.boot;

import MVC.controller.MyController;
import MVC.model.MyModel;
import MVC.view.MyView;

public class Run {

	public static void main(String[] args)
	{
		
		MyController myController = new MyController();
		MyModel myModel = new MyModel(myController);
		MyView myView = new MyView(myController);
		
		myController.setModular(myModel);
		myController.setViewer(myView);
		
		myView.start();
		

	}

}
