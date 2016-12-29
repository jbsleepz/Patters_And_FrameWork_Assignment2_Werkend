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
	ArrayList<Locomotive> completed;
	ArrayList<Wagon> wagons;

	Wagon w = null; 

	public new_command(){
		super();
	}
	@Override
	public boolean execute() {
		
		boolean b = true;
		if (characters[0].equals("new") && characters[1].equals("train")) {

			// voor het aanmaken van een nieuwe trein.
			if (super.GeldigheidCommandcontrole("[a-z0-9]*", characters[2])) {

				//aanmaken locomotive, toevegen aan een complete trein	
				Locomotive locomotive = new Locomotive();
				locomotive.setname(characters[2]);
				
				loco = locomotive;
				//het treinobject opslaan bij de superklass en toewijzen aan het huidige station
				super.setLocomotiveToStation();
				
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
		else if (characters[3].equals("maxweight")|| characters[3].equals("numseats") ||super.GeldigheidCommandcontrole("[a-z0-9]*", characters[2]) || super.GeldigheidCommandcontrole("[0-9]*", characters[4])) {
					System.out.println("test skeer");
					if (characters[3].equals("maxweight")) {
						
						//goodswagon aanmaken
						String sMaxWeight = characters[4];
						int iMaxWeight = Integer.parseInt(sMaxWeight.trim());
						
						
						wagons = new ArrayList<Wagon>();
						w = new GoodsWagon(characters[2], iMaxWeight);
						wagons.add(w);
						
						wagentje = w;			
						super.setWagonToTrainstation();

				
						super.setErrorMessage("er is een goederen wagon " + w.toString() + " aangemaakt \n");
						b = false;
						
					} else if (characters[3].equals("numseats")) {
						String sAmountPassengers = characters[4];
						int iAmountPassengers = Integer.parseInt(sAmountPassengers.trim());
						String naam = characters[2];
						
						wagons = new ArrayList<Wagon>();
						w = new PassengerWagon(naam, iAmountPassengers);
						wagons.add(w);
						
						wagentje = w;			
						super.setWagonToTrainstation();
			
						super.setErrorMessage("er is een passagiers wagon " + w.toString() + " aangemaakt \n");
						b = false;
					}
				} 
		else if(characters[0].equals("new") && characters[1].equals("wagon")|| super.GeldigheidCommandcontrole("[a-z0-9]*", characters[2])){
						
						System.out.println("!");
						wagons = new ArrayList<Wagon>();
						w = new PassengerWagon(characters[2], 20);							
						wagons.add(w);
						
						wagentje = w;			
						super.setWagonToTrainstation();
						
						super.setErrorMessage("er is een passagiers wagon " + w.getName() + " aangemaakt \n");
						b = false;
					}
						
		return b;

	}

}