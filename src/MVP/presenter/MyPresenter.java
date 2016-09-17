package MVP.presenter;

import java.util.Observable;

import MVP.model.Model;
import MVP.view.View;

public class MyPresenter extends CommonPresenter {

	public MyPresenter(Model model, View view)
	{
		super(model, view);
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		//TODO: Finish update function
	}

}
