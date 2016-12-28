package Controller_Commands;

import java.util.ArrayList;

import Domain.CompleteTrain;
import Domain.GoodsWagon;
import Domain.Locomotive;
import Domain.PassengerWagon;
import Domain.TrainStation;
import Domain.Wagon;

public class new_command extends Command {

	TrainStation trains;
	ArrayList<CompleteTrain> completed;

	Wagon w = null; 

	public new_command(){
		trains = super.getTrain();
		completed = trains.getCompleteTrains();
	}
	@Override
	public boolean execute() {
		
		boolean b = true;

		if (characters[0].equals("new") && characters[1].equals("train")) {
			// voor het aanmaken van een nieuwe trein.
			if (super.GeldigheidCommandcontrole("[a-z0-9]*", characters[2])) {
				Locomotive locomotive = new Locomotive();
				locomotive.setname(characters[2]);
				ArrayList<Wagon> wagons = new ArrayList<Wagon>();
				completed.add(new CompleteTrain(locomotive, wagons));
				trains.setCompleteTrains(completed);
				super.setErrorMessage("De trein " + locomotive.toString() + " is aangemaakt \n");
			} else {
				super.setErrorMessage("De command is verkeerd meegegeven, vb. ; 'new train tr1' \n");
				b = false;
			}

		}
		// voor het aanmaken van nieuwe wagon, example command: 
		// passenger wagon: "new wagon <<WagonID>> numseats <<NUMBER>>" 
		// OR 
		// goods wagon: "new wagon <<WagonID>> maxweight <<NUMBER>>"
		else if (characters[0].equals("new") && characters[1].equals("wagon")) {
			System.out.println("test 0");
				if (super.GeldigheidCommandcontrole("[a-z0-9]*", characters[2]) || super.GeldigheidCommandcontrole("[0-9]*", characters[4])) {
					System.out.println("test skeer");
					if (characters[3].equals("maxweight")) {
						System.out.println("test 1");
						String sMaxWeight = characters[4];
						int iMaxWeight = Integer.parseInt(sMaxWeight.trim());
						w = new GoodsWagon(characters[2], iMaxWeight);
						System.out.println("test 2");
						//wagons = new ArrayList<Wagon>();
						System.out.println("test 3");
						//wagons.add(w);
						System.out.println("test 4");
						//System.out.println(completetrain);
						//completetrain.setWagons(wagons);
						System.out.println("test 5");
				
						super.setErrorMessage("er is een goederen wagon " + w.toString() + " aangemaakt \n");
					} else if (characters[3].equals("numseats")) {
						String sAmountPassengers = characters[4];
						int iAmountPassengers = Integer.parseInt(sAmountPassengers.trim());
						String naam = characters[2];
						w = new PassengerWagon(naam, iAmountPassengers);
						
						//wagons = new ArrayList<Wagon>();
						//wagons.add(w);
						//completetrain.setWagons(wagons);
						//completetrain.addWagons(w);
						super.setErrorMessage("er is een passagiers wagon " + w.toString() + " aangemaakt \n");
					} else {
						w = new PassengerWagon(characters[2], 20);
						
						//wagons = new ArrayList<Wagon>();
						//wagons.add(w);
						//completetrain.setWagons(wagons);
						
						//completetrain.addWagons(w);
						super.setErrorMessage("er is een passagiers wagon " + w.toString() + " aangemaakt \n");
						b = false;
					}
				} else {
					super.setErrorMessage("De command is verkeerd meegegeven, example wg1 Passenger to tr1 \n");
					b = false;
				}
			} 
		 else {
			super.setErrorMessage("Het nieuwe object dat je wilt aanmaken heeft andere syntax\n");
		}
		return b;

	}

}