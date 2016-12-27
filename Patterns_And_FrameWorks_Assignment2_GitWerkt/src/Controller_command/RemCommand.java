package Controller_command;

import Domain.CompleteTrain;
import LibariesImport.Program;

public class RemCommand extends CommandType{
	// Doet Daphne
	@Override
	public void execute(String input) {
		String WagonID = Program.between(input, "remove", "from");
		String TrainID = Program.after(input, "from");
		
		CompleteTrain TrainID.removeWagons(WagonID);
	}

}
