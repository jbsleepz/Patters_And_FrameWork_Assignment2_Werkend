package Controller_command;

import java.util.ArrayList;

import Domain.CompleteTrain;
import Domain.PassengerWagon;
import Domain.TrainStation;
import Domain.Wagon;
import LibariesImport.Program;

public class NewWagonCommand extends CommandType{
	
	TrainStation trains;
	CompleteTrain completeTrain;
	// Doet Daphne
	@Override
	public void execute(String input) {
		String wagonID = Program.after(input, "wagon");
		
		ArrayList<CompleteTrain> train = trains.getCompleteTrains();
		
		for (CompleteTrain completeTrain : train) {
				ArrayList<Wagon> wagons = completeTrain.getWagons();
				for (Wagon wagon : wagons){
					if(wagon.getName().equals(wagonID)){
						System.out.println("het meegegeven ID bestaat al");
						break;
						} 
					else if(input.contains("numseats")){
						String amountPassengers = Program.after(input, "numseats");
						int aantalPassangiers = Integer.parseInt(amountPassengers.trim());	
						Wagon w = new PassengerWagon(wagonID, aantalPassangiers);
					}
					else 
						{
						new PassengerWagon(wagonID, 20);
						break;
						}
				}
			}
	}

}
