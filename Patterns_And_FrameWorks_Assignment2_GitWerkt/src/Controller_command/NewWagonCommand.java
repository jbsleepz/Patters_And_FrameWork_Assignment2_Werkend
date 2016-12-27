package Controller_command;

import Domain.Wagon;
import LibariesImport.Program;

public class NewWagonCommand extends CommandType{
	// Doet Daphne
	@Override
	public void execute(String input) {
		String wagonID = Program.after(input, "wagon");
		new Wagon(wagonID);
	}

}
