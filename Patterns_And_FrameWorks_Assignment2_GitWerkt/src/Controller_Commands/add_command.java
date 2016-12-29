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
	
	
	CompleteTrain selectedCurrentTrain = null;
	Wagon selectedWagon = null;
	
	

	// example van command : add <<wg1Naam>> <<type[goods/passenger]> to <<treinNaam>>

	public add_command(){
		super();
	}
	
	public boolean execute() {
		boolean b = true;
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//									WAGONS AAN TREIN TOEVOEGEN
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		
		

		if (characters[0].equals("add") && characters[2].equals("to")) {
			
			//als de wagon bestaat in de lijst met wagons
			
			System.out.println("123");
			if(train.geefAantalWagons()> 0 == true && train.bestaatWagon(characters[1])){
				System.out.println("!!!!!!!!!");
				if(train.geefAantalTreinen()>0 == true && train.zoekTrain(characters[3])){
					System.out.println("bwibegbievibhj");
					selectedCurrentTrain = train.getSelectedTrain(characters[3]);
					System.out.println("#############");
					selectedWagon = train.getSelectedWagon(characters[1]);
					System.out.println("$$$$");
					System.out.println("huide trein:L "+selectedCurrentTrain.getLocomotive().getName());
					System.out.println("..........");
					System.out.println("geselecteerde wagon: "+ selectedWagon.getName());
					
					//voeg wagon toe uit de lijst met wagons aan de trein
					selectedCurrentTrain.addWagons(selectedWagon);
					System.out.println("wagon"+ selectedWagon.getName() + "is toegevoegd aan trein: "+ selectedCurrentTrain.getLocomotive().getName());
					
					//nog wel verwijderen uit de lijst met losse wagons van het station
					
				}
			}
			
/*
			
			//kijken in de lijst met complete treinen of de naam van de locomotief al voorkomt
			boolean bool = false;
			compTrains = train.getCompleteTrains();
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
		
			//super.setErrorMessage("er is een goederen wagon aan trein"+ treintjes.getName() + " toegevoegd \n");
		} else {
			super.setErrorMessage("De command is verkeerd meegegeven, example wg1 Passenger to tr1 \n");
			b = false;*/
		}
		
		return b;
	}
	

}
