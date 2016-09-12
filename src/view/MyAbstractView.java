package view;

import java.util.HashMap;

import controller.Controller;
import controller.ICommand;

public abstract class MyAbstractView implements View {

	protected Controller controller;
	protected CLI cli;
	
	
	public MyAbstractView(Controller controller) {
		this.controller = controller;
	}
	
	
	
	public CLI getCli() {
		return cli;
	}



	public void setCli(CLI cli) {
		this.cli = cli;
	}



	@Override
	public void setController(Controller controller) {
		this.controller = controller;

	}

	@Override
	public Controller getController() {
		return this.controller;
	}

	@Override
	public void start() {
		cli.start();

	}

	@Override
	public void setCommands(HashMap<String, ICommand> commands) {
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<String, ICommand> getCommands() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void operation(String regex) {
		// TODO Auto-generated method stub

	}

}
