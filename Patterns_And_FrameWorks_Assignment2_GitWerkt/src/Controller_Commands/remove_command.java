package Controller_Commands;

import java.util.ArrayList;

import Domain.CompleteTrain;
import Domain.GoodsWagon;
import Domain.Locomotive;
import Domain.PassengerWagon;
import LibariesImport.Program;
import Domain.TrainStation;
import Domain.Wagon;

public class remove_command extends Command {
	TrainStation trains;
	CompleteTrain selectedTrain = null;
	Wagon selectedWagon = null;
	
	//example command: "remove <<WagonID>> from <<TrainID>>";
	@Override
	public boolean execute() {
		boolean b = true;
		
		if (characters[0].equals("remove") && characters[2].equals("from")) {
			
/*			ArrayList<CompleteTrain> allTrains = trains.getCompleteTrains();
			String wagonID = characters[1];
			String trainID = characters[3];*/
			
			selectedTrain = train.getSelectedTrain(characters[3]);			
			selectedWagon = selectedTrain.getSelectedWagon(characters[1]);
			selectedTrain.removeWagons(selectedWagon);
			
			
/*
			for (CompleteTrain completeTrain : allTrains) {
				Locomotive locomotive = completeTrain.getLocomotive();
				if (locomotive.getName().equals(trainID)) {
					ArrayList<Wagon> wagons = completeTrain.getWagons();
					for (Wagon wagon : wagons){
						if(wagon.getName().equals(wagonID)){
							completeTrain.removeWagons(wagon);
							break;
						} 
					}
				}*/
			
		}else {
			super.setErrorMessage("De command is verkeerd meegegeven, example: 'remove <<TrainID>> from <<WagonID>>' \n");
			b = false;
		}
		return b;
		
		

	}
}

/*String WagonID = Program.between(input, "remove", "from");
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
	}*/