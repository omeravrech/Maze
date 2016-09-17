package MVP.presenter;

import MVP.commands.ICommand;

public class Request implements Comparable<Integer>
{
	ICommand command;
	String args[];
	Integer priority;
	
	public Request(ICommand command, String[] args)
	{
		this.command = command;
		this.args = args;
		this.priority = Priorities.NEUTRAL;
	}
	public ICommand getCommand() {
		return command;
	}
	public String[] getArgs() {
		return args;
	}
	public void setPriority(Integer p)
	{
		this.priority = p;
	}
	@Override
	public int compareTo(Integer other)
	{
		return (this.priority - other);
	}
}
