package view;

import java.io.IOException;

import controller.Controller;

public abstract class CommonView implements View {

	protected Controller controller;
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
