package Controller_Commands;

import java.util.ArrayList;

import Domain.CompleteTrain;
import Domain.GoodsWagon;
import Domain.Locomotive;
import Domain.PassengerWagon;
import Domain.TrainStation;
import Domain.Wagon;
//voor het aanmaken van nieuwe wagon, example command:
		// passenger wagon: "new wagon <<WagonID>> numseats <<NUMBER>>"
		// OR
		// goods wagon: "new wagon <<WagonID>> maxweight <<NUMBER>>"
public class new_command extends Command {

	ArrayList<Locomotive> completed;
	ArrayList<Wagon> wagons = new ArrayList<Wagon>();
	Wagon w;
	
	//jelle extra
	CompleteTrain comptr = null;
	String selectedTrain = null;
	String selectedWagon = null;;
	
	public new_command() {
		super();
	}

	@Override
	public boolean execute() {
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//									TRAINS AANMAKEN
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		

		boolean b = true;
		if (characters[0].equals("new") && characters[1].equals("train")) {

			// voor het aanmaken van een nieuwe locomotief.
			if (super.GeldigheidCommandcontrole("[a-z0-9]*", characters[2])) {
				selectedTrain = characters[2];
				System.out.println("eerste invoer "+selectedTrain);
				System.out.println("123");
				//als er al treinen zijn
				if(train.geefAantalTreinen()> 0){
					System.out.println("!!!!!!!!");
					if(train.zoekTrain(characters[2])==true){
						System.out.println("........");
					System.out.println("trein" + characters[2]+ " bestaat al, kan niet opnieuw aanmaken");
					}
					
					else{
						System.out.println("abc");
						//maak een locomotief aan
						Locomotive loc = new Locomotive(characters[2]);
						//voeg locomotief aan een trein toe
						comptr = new CompleteTrain(loc);
						comptr.setWagons(wagons);
						//zet de trein in het treinstation
						train.addTrain(comptr);
						
						System.out.println("trein: "+ characters[2] + " bestaat nog niet");
					}
				}

				//als die trein nog niet bestaat --> toevoegen
				else{
					System.out.println("abc");
					//maak een locomotief aan
					Locomotive loc = new Locomotive(characters[2]);
					//voeg locomotief aan een trein toe
					comptr = new CompleteTrain(loc);
					comptr.setWagons(wagons);
					//zet de trein in het treinstation
					train.addTrain(comptr);
					
					System.out.println("trein: "+ characters[2] + " bestaat nog niet");
				}
			}
		}
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//									WAGONS AANMAKEN
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		
		else if  (characters[0].equals("new") && characters[1].equals("wagon")) {

			if(characters.length == 3){
					
				selectedWagon = characters[2];
				System.out.println(selectedWagon);
				
				//als er al wagons zijn en de wagon bestaat al
				if(train.geefAantalWagons() > 0 && train.bestaatWagon(selectedWagon) == true){
					System.out.println("Wagon met naam: " + selectedWagon + " bestaat al");
				}
				//anders wagon aanmaken en toevoegen aan het treinstation
				else{
					w = new PassengerWagon(selectedWagon, 20);	
					train.addWagon(w);
					System.out.println("Wagon: "+ selectedWagon + " is nu nieuw aangemaakt");
					}
				}

			 else {
			// goodswagon aanmaken
				if (characters[3].equals("maxweight") && super.GeldigheidCommandcontrole("[0-9999]*", characters[4])) {
					String sMaxWeight = characters[4];
					int iMaxWeight = Integer.parseInt(sMaxWeight.trim());
	
					w = new GoodsWagon(characters[2], iMaxWeight);
					wagons.add(w);
					wagentje = w;
					super.setWagonToTrainstation();
	
					super.setErrorMessage("er is een goederen wagon " + w.toString() + " aangemaakt \n");
	
				} else if (characters[3].equals("numseats") && super.GeldigheidCommandcontrole("[0-999]*", characters[4])) {//|| 
					String sAmountPassengers = characters[4];
					int iAmountPassengers = Integer.parseInt(sAmountPassengers.trim());
					String naam = characters[2];
	
					w = new PassengerWagon(naam, iAmountPassengers);
					wagons.add(w);
					wagentje = w;
					super.setWagonToTrainstation();
					super.setErrorMessage("er is een passagiers wagon " +  wagentje.toString() + " aangemaakt \n");
	
				} else {
					super.setErrorMessage("Context is verkeerd, example: new wagon <<naam>> [numseats/maxweight] <<aantal>>");
				}

			}
			
		}
		return b;
	}
}


