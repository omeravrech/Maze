package MVP.view;

import java.util.Observable;


/**
* <h1>MyView Class</h1>
*<br>extends CommonView, this class is responsible for the visuals after being processed in the model<br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/
public class MyView extends CommonView
{
	/**
	 * Constructor
	 * @param ui UserInterface
	 */
	public MyView(UserInterface ui)
	{
		super(ui);
		ui.addObserver(this);
	}

	@Override
	public void result(Object result)
	{
		ui.result(result);
	}

	@Override
	public void update(Observable o, Object args)
	{
		this.setChanged();
		this.notifyObservers(args);
	}
	

}
