package MVP.commands;

import java.io.IOException;

import MVP.model.Model;
import MVP.view.View;

public class Display_solution extends CommonCommand {

	public Display_solution(Model model, View view) {
		super(model, view);
	}

	@Override
	public void doCommand(String[] args) throws IOException {
		String name = args[2];
		if (name == "" || name == " " || name == null)
			view.Result("Invalid name");
		else
			model.display_solution(name);

	}

}
