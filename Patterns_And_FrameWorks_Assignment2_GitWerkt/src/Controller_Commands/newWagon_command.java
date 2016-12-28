package Controller_Commands;

import java.util.ArrayList;

import Domain.CompleteTrain;
import Domain.GoodsWagon;
import Domain.PassengerWagon;
import Domain.TrainStation;
import Domain.Wagon;
import LibariesImport.Program;

public class newWagon_command extends CommandType{
	
	TrainStation trains;
	CompleteTrain completeTrain;
	
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
					else if(input.contains("maxweight")){
						String sMaxWeight = Program.after(input, "maxweight");
						int iMaxWeight = Integer.parseInt(sMaxWeight.trim());	
						new GoodsWagon(wagonID, iMaxWeight);
					}
					else if(input.contains("numseats")){
						String sAmountPassengers = Program.after(input, "numseats");
						int iAmountPassengers = Integer.parseInt(sAmountPassengers.trim());	
						new PassengerWagon(wagonID, iAmountPassengers);
					}
					else 
						{
						new PassengerWagon(wagonID, 20);
						}
					
				}
			}
	}

}
