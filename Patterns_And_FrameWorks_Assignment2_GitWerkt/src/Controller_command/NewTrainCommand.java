package Controller_command;

import Domain.Locomotive;
import LibariesImport.Program;

public class NewTrainCommand extends CommandType{
	// Doet Daphne
	@Override
	public void execute(String input) {
		String trainID = Program.after(input, "train");
		new Locomotive(trainID);
		
	}

}
