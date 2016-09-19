package MVP.boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import MVP.view.MyView;
import MVP.model.MyModel;
import MVP.presenter.MyPresenter;

public class Run {

	public static void main(String[] args) 
	{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
				
		MyView view = new MyView(in, out);
		MyModel model = new MyModel();
		
		MyPresenter presenter = new MyPresenter(model, view);
		model.addObserver(presenter);
		view.addObserver(presenter);
				
		
		presenter.start();

	}

}
