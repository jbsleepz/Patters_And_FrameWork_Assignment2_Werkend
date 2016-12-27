package Controller_command;

import java.util.ArrayList;

import Domain.CompleteTrain;
import LibariesImport.Program;
import Domain.TrainStation;

public class RemCommand extends CommandType {
	// Doet Daphne
	@Override
	public void execute(String input) {
		String WagonID = Program.between(input, "remove", "from");
		String TrainID = Program.after(input, "from");

		TrainStation trains;
		ArrayList<CompleteTrain> train = trains.getCompleteTrains();

		for (CompleteTrain completeTrain : train) {
			if (completeTrain.getLocomotive().equals(TrainID)) {
				completeTrain.removeWagons(WagonID);
			}
		}

	}
}
