package MVP.presenter;


/**
* <h1>Command Data Class</h1>
*<br> Holds the input of the user command and the regular expression<br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/
public class CommandData
{
	public String regex;
	public String[] input;
	
	/**
	 * Constructor
	 * @param regex String
	 * @param input String[]
	 */
	public CommandData(String regex, String[] input) {
		super();
		this.regex = regex;
		this.input = input;
	}
	
	/** Getter */
	public String getRegex() {
		return regex;
	}
	
	/** Getter */
	public String[] getInput() {
		return input;
	}
	
}
