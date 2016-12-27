package Controller_command;

import LibariesImport.Program;

public class RemCommand extends CommandType{
	// Doet Daphne
	@Override
	public void execute(String input) {
		// TODO Auto-generated method stub
		Program.between(input, "remove", "from");
	}

}
