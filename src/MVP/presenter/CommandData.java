package MVP.presenter;

public class CommandData
{
	public String regex;
	public String[] input;
	
	public CommandData(String regex, String[] input) {
		super();
		this.regex = regex;
		this.input = input;
	}

	public String getRegex() {
		return regex;
	}

	public String[] getInput() {
		return input;
	}
	
}
