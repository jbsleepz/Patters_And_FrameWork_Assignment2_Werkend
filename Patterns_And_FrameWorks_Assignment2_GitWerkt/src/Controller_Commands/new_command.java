package Controller_Commands;

import Domain.CompleteTrain;
import Domain.GoodsWagon;
import Domain.Locomotive;
import Domain.PassengerWagon;
import Domain.TrainStation;
import Domain.Wagon;

public class new_command extends Command {

	TrainStation trains = null;
	Wagon w = null; 

	@Override
	public boolean execute() {

		boolean b = true;

		if (characters[0].equals("new") && characters[1].equals("train")) {
			// voor het aanmaken van een nieuwe trein.
			if (super.GeldigheidCommandcontrole("[a-z0-9]*", characters[2])) {
				Locomotive locomotive = new Locomotive();
				locomotive.setname(characters[2]);
				CompleteTrain completetrain = new CompleteTrain(locomotive);
				super.setErrorMessage("De trein " + locomotive.toString() + " is aangemaakt \n");
			} else {
				super.setErrorMessage("De command is verkeerd meegegeven, vb. ; 'new train tr1' \n");
				b = false;
			}

		}
		// voor het aanmaken van nieuwe wagon
		// example command: "new wagon <<WagonID>> numseats <<NUMBER>>" or "new
		// wagon <<WagonID>> maxweight <<NUMBER>>"
		else if (characters[0].equals("new") && characters[1].equals("wagon")) {

			if (super.GeldigheidCommandcontrole("[a-z0-9]*", characters[2]) || super.GeldigheidCommandcontrole("[0-9]*", characters[4])) {
				if (characters[3].equals("maxweight")) {
					String sMaxWeight = characters[4];
					int iMaxWeight = Integer.parseInt(sMaxWeight.trim());
					w = new GoodsWagon(characters[2], iMaxWeight);
					
					super.setErrorMessage("er is een goederen wagon " + w.toString() + " aangemaakt \n");
				} else if (characters[3].equals("numseats")) {
					String sAmountPassengers = characters[4];
					int iAmountPassengers = Integer.parseInt(sAmountPassengers.trim());
					String naam = characters[2];
					w = new PassengerWagon(naam, iAmountPassengers);
					super.setErrorMessage("er is een passagiers wagon " + w.toString() + " aangemaakt \n");
				} else {
					w = new PassengerWagon(characters[2], 20);

					super.setErrorMessage("er is een passagiers wagon " + w.toString() + " aangemaakt \n");
					b = false;
				}
			} else {
				super.setErrorMessage("De command is verkeerd meegegeven, example wg1 Passenger to tr1 \n");
				b = false;
			}
		} else {
			super.setErrorMessage("Het nieuwe object dat je wilt aanmaken heeft andere syntax");
		}
		return b;

	}

}
/*
 * String wagonID = Program.after(input, "wagon");
 * 
 * ArrayList<CompleteTrain> train = trains.getCompleteTrains();
 * 
 * for (CompleteTrain completeTrain : train) { ArrayList<Wagon> wagons =
 * completeTrain.getWagons(); for (Wagon wagon : wagons){
 * if(wagon.getName().equals(wagonID)){ System.out.println(
 * "het meegegeven ID bestaat al"); break; } else
 * if(input.contains("maxweight")){ String sMaxWeight = Program.after(input,
 * "maxweight"); int iMaxWeight = Integer.parseInt(sMaxWeight.trim()); new
 * GoodsWagon(wagonID, iMaxWeight); } else if(input.contains("numseats")){
 * String sAmountPassengers = Program.after(input, "numseats"); int
 * iAmountPassengers = Integer.parseInt(sAmountPassengers.trim()); new
 * PassengerWagon(wagonID, iAmountPassengers); } else { new
 * PassengerWagon(wagonID, 20); }
 */