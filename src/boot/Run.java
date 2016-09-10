package boot;

import controller.MyController;
import model.MyModel;
import view.MyView;

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
