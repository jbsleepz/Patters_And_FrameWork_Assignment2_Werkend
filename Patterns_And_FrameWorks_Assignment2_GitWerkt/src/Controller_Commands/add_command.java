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
	
	ArrayList<CompleteTrain> compTrains;
	ArrayList<Locomotive> locos;
	ArrayList<Wagon> wagons;
	ArrayList<Wagon> wagonsTrain;
	Wagon wagentje = null;
	Locomotive treintjes = null;
	CompleteTrain compTrein = new CompleteTrain();

	// example van command : add <<wg1Naam>> <<type[goods/passenger]> to <<treinNaam>>

	public add_command(){
		super();
	}
	
	public boolean execute() {
		boolean b = true;

		if (characters[0].equals("add") && characters[2].equals("to") || super.GeldigheidCommandcontrole("[a-z0-9]*", characters[1])
				|| super.GeldigheidCommandcontrole("[a-z0-9]*", characters[3])) {
			
			//haal alle complete treinen, locomotieven en wagons op
			compTrains = train.getCompleteTrains();
			locos = train.getLocomotives();
			wagons = train.getWagons();
			
			//kijken in de lijst met complete treinen of de naam van de locomotief al voorkomt
			boolean bool = false;
			
			for(CompleteTrain t : compTrains){
				Locomotive l = t.getLocomotive();
				wagonsTrain = t.getWagons();
				
				//als de naam van de locomotief hetzelfde is als de opgegeven naam
				if(l.getName().equals(characters[3])){
					
					for(Wagon w : wagons){
						
						if(w.getName().equals(characters[1])){
							t.addWagons(w); bool = true;
							treintje = t;
							System.out.println("dit is de eerste x");
							break;
						}
					}
					break;
				}
			}
			if(bool == false){
				
				
					//aanmaken complete trein,
					//locomotief uit lijst locomotieven halen
					// wagen uit lijst met wagens halen
					//nieuwe complete trein aanmaken + locomotief
					//lijst met wagens toekennen aan de complete trein
					//complete trein toevoegen aan het treinstation
				
				for(Locomotive l : locos){
					if(l.getName().equals(characters[3])){
	
						
						for(Wagon w : wagons){
							if(w.getName().equals(characters[1])){
								compTrein.setLocomotive(l);
								wagonsTrain = new ArrayList<Wagon>();
								wagonsTrain.add(w);
								compTrein.setWagons(wagonsTrain);	
								
								treintje = compTrein;
								System.out.println("dit is de tweede x");
								break;
							}
						}
						break;
					}
				}
			}
			
			
/*			
			
			
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
			}*/
			super.setCompleteTrainToTrainStation();
		
			//super.setErrorMessage("er is een goederen wagon aan trein"+ treintjes.getName() + " toegevoegd \n");
		} else {
			super.setErrorMessage("De command is verkeerd meegegeven, example wg1 Passenger to tr1 \n");
			b = false;
		}
		return b;

	}

}
