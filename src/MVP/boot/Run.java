package MVP.boot;

import MVP.model.MyModel;
import MVP.presenter.MyPresenter;

public class Run {

	public static void main(String[] args) 
	{
		
	MyModel model = new MyModel();
	MyView view = new MyView();
	MyPresenter presenter = new MyPresenter(model,view);
	
	model.addObserver(presenter);
	view.addObserver(presenter);

	}

}
