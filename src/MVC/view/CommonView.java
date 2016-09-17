package MVC.view;

import java.io.IOException;

import MVC.controller.Controller;
/**
* <h1>CommonView abstract class</h1>
*<br> an abstract class that contain the data members<br>
*and holds abstract methods as well
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   15/09/2016 
*/
public abstract class CommonView implements View {
	
	
	/**
	 * data member of CommonView
	 */
	protected Controller controller;
	/**
	 * data member of CommonView
	 */
	protected CLI cli;

	public void setController(Controller controller)
	{
		this.controller = controller;
		this.cli.setCommands(controller.getCommands());
	}

	public Controller getController() {
		return this.controller;
	}

	@Override
	abstract public void start();
	@Override
	abstract public void operationCommand(String command, String input) throws IOException;
	abstract public void notify(String message);

}
