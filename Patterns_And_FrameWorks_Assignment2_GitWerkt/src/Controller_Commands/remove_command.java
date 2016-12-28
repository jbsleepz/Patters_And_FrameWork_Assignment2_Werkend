package Controller_Commands;

import java.util.ArrayList;

import Domain.CompleteTrain;
import LibariesImport.Program;
import Domain.TrainStation;
import Domain.Wagon;

public class remove_command extends Command {
	TrainStation trains;
	CompleteTrain trainWagon;

	
	//example command: "remove <<TrainID>> from <<WagonID>>";
	@Override
	public boolean execute() {
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
