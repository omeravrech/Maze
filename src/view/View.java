package view;

import java.util.HashMap;

import controller.Controller;
import controller.ICommand;

public interface View 
{
	public void setController(Controller controller);
	public Controller getController();
	public void start();
	public void setCommands(HashMap<String, ICommand> commands);
	public HashMap<String, ICommand> getCommands();
	public void operation(String regex);
}
