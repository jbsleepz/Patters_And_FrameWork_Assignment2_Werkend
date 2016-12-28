package Controller_Commands;

import java.util.ArrayList;

import Domain.CompleteTrain;
import Domain.GoodsWagon;
import Domain.Locomotive;
import Domain.PassengerWagon;
import Domain.TrainStation;
import Domain.Wagon;
import LibariesImport.Program;

public class newWagon_command extends Command{
	
	TrainStation trains;
	CompleteTrain completeTrain;
	
	// example command: "new wagon <<WagonID>> numseats <<NUMBER>>" or "new wagon <<WagonID>> maxweight <<NUMBER>>"
	@Override
	public boolean execute() {
		
		boolean b = true;
		
		if (characters[0].equals("new") && characters[1].equals("wagon")|| super.GeldigheidCommandcontrole("[a-z0-9]*", characters[2])) {
			if (characters[3].equals("maxweight")) {
				String sMaxWeight = characters[4];
				int iMaxWeight = Integer.parseInt(sMaxWeight.trim());	
				Wagon w = new GoodsWagon(characters[2], iMaxWeight);
				super.setErrorMessage("er is een goederen wagon " + characters[2] + " aangemaakt /n");
			} else if (characters[3].equals("numseats")) {
				String sAmountPassengers = characters[4];
				int iAmountPassengers = Integer.parseInt(sAmountPassengers.trim());	
				Wagon w = new PassengerWagon(characters[2], iAmountPassengers);
				super.setErrorMessage("er is een passagiers wagon " + characters[2] + " aangemaakt /n");
			} else {
				Wagon w = new PassengerWagon(characters[2], 20);
				super.setErrorMessage("er is een passagiers wagon " + characters[2] + " aangemaakt /n");
			}
		} else {
			super.setErrorMessage("De command is verkeerd meegegeven, example wg1 Passenger to tr1 /n");
			b = false;
		}
		return b;
		
	}

}
/*String wagonID = Program.after(input, "wagon");

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
			*/