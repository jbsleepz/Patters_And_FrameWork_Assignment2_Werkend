package Controller_command;

import java.util.ArrayList;

import Domain.CompleteTrain;
import LibariesImport.Program;
import Domain.TrainStation;
import Domain.Wagon;

public class RemCommand extends CommandType {
	TrainStation trains;
	CompleteTrain trainWagon;
	// Doet Daphne
	@Override
	public void execute(String input) {
		String WagonID = Program.between(input, "remove", "from");
		String TrainID = Program.after(input, "from");

		ArrayList<CompleteTrain> train = trains.getCompleteTrains();
	

		for (CompleteTrain completeTrain : train) {
			if (completeTrain.getLocomotive().equals(TrainID)) {
				ArrayList<Wagon> wagons = trainWagon.getWagons();
				for (Wagon wagon : wagons){
					if(wagon.getName().equals(WagonID)){
						completeTrain.removeWagons(WagonID);
						break;
					}
				}
			} else {
				System.out.println("er kan geen trein worden gevonden met meegegeven ID");
				break;
			}
		}

	}
}
