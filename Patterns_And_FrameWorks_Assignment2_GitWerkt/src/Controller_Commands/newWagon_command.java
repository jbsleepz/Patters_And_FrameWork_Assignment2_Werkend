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
	
	@Override
	public boolean execute() {
		
		boolean b = true;
		
		if (characters[0].equals("new") && characters[1].equals("train")|| super.GeldigheidCommandcontrole("[a-z0-9]*", characters[2])) {
			Locomotive locomotive = new Locomotive();
			locomotive.setname(characters[2]);
			CompleteTrain completetrain = new CompleteTrain(locomotive);
			if (characters[2].equals("goods")) {
				Wagon w = new GoodsWagon(characters[1], 1000);
				completetrain.addWagons(w);
				super.setErrorMessage("er is een goederen wagon aan trein" + locomotive.toString() + " toegevoegd /n");
			} else if (characters[2].equals("passenger")) {
				Wagon w = new PassengerWagon(characters[1], 20);
				completetrain.addWagons(w);
				super.setErrorMessage("er is een passagiers wagon aan trein" + locomotive.toString() + " toegevoegd /n");
			} else {
				super.setErrorMessage("Het type is verkeerd meegegeven, example wg1 Passenger to tr1 /n");
				b = false;
			}
		} else {
			super.setErrorMessage("De command is verkeerd meegegeven, example wg1 Passenger to tr1 /n");
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