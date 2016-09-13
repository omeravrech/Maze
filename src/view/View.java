package view;

import java.io.IOException;

public interface View 
{
	public void start();
	public void operation(String regex) throws IOException;
	public void setCommands();
	public void returnedMessage(Object msg);
}
