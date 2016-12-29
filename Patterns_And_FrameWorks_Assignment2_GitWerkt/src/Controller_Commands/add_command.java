package Controller_Commands;

import java.util.ArrayList;

import Domain.CompleteTrain;
import Domain.GoodsWagon;
import Domain.Locomotive;
import Domain.PassengerWagon;
import Domain.TrainStation;
import Domain.Wagon;
import LibariesImport.Program;

public class add_command extends Command {
	
	ArrayList<Locomotive> locos = new ArrayList<Locomotive>();
	ArrayList<Wagon> wagons = new ArrayList<Wagon>();
	Wagon wagentje = null;
	Locomotive treintjes = null;
	CompleteTrain compTrein = null;

	// example van command : add <<wg1Naam>> <<type[goods/passenger]> to <<treinNaam>>

	public add_command(){
		super();
	}
	
	public boolean execute() {
		boolean b = true;

		if (characters[0].equals("add") && characters[2].equals("to") || super.GeldigheidCommandcontrole("[a-z0-9]*", characters[1])
				|| super.GeldigheidCommandcontrole("[a-z0-9]*", characters[3])) {
			
			
			locos = train.getLocomotives();
			System.out.print(locos);
			wagons = train.getWagons();
			for(Wagon zoekw: wagons){
				if(zoekw.getName().equals(characters[1])){
					wagentje = zoekw;
					for(Locomotive zoekLoco: locos){
						if(zoekLoco.getName().equals(characters[3])){
							treintjes = zoekLoco;
							treintjes.setname(characters[3]);
							ArrayList<Wagon> blaWagon = new ArrayList<Wagon>();
							blaWagon.add(wagentje);
							compTrein = train.zoekTrain(characters[3]);
							
							compTrein = new CompleteTrain(treintjes);
							compTrein.setWagons(blaWagon);
							System.out.println(compTrein.getLocomotive().getName() + "FSdfsdfasdfadsg");
							treintje = compTrein;
							System.out.print(treintje);
							break;
						}
					}
				}
			}
			super.setCompleteTrainToTrainStation();
		
			super.setErrorMessage("er is een goederen wagon aan trein"+ treintjes.getName() + " toegevoegd \n");
		} else {
			super.setErrorMessage("De command is verkeerd meegegeven, example wg1 Passenger to tr1 \n");
			b = false;
		}
		return b;

	}

}
