package Domain;

import java.util.ArrayList;
import java.util.HashMap;

public class TrainStation extends java.util.Observable {
	String name = "bla";
	private ArrayList<CompleteTrain> completeTrains;
	private ArrayList<Wagon> wagons = new ArrayList<Wagon>();
	CompleteTrain selectedTrain;
	Wagon selectedWagon;
	
	public TrainStation() {
		this.completeTrains = new ArrayList<CompleteTrain>()
;	}
	public String getName(){
		return name;
	}

	public ArrayList<Wagon> getWagons() {
		return wagons;
	}
	public void setWagons(ArrayList<Wagon> wagons) {
		this.wagons = wagons;
	}
	// observable udaten.
	private void update(){
		this.setChanged();
		this.notifyObservers();
	}
	
/*	public void new_command(String objectType,String naam, String stoelen)	{
		if(objectType.equals("train")){
			Locomotive loco = new Locomotive(naam);
			CompleteTrain compTrain = new CompleteTrain(loco);
		}
	}*/

	public TrainStation(ArrayList<CompleteTrain> train) {
		train = new ArrayList<CompleteTrain>();
	}

	public void addTrain(CompleteTrain train) {
		completeTrains.add(train);
	}

	
	public void addWagon(Wagon w){
		wagons.add(w);
	}
	

	public void removeTrain(String verwijderWaarde) {
		for (CompleteTrain zoekTrain : completeTrains) {
			if (zoekTrain.getLocomotive().getName().equals(verwijderWaarde)) {
				completeTrains.remove(zoekTrain);
				break;
			}
		}
	}

	public ArrayList<CompleteTrain> getCompleteTrains() {
		return completeTrains;
	}

	public void setCompleteTrains(ArrayList<CompleteTrain> completeTrains) {
		this.completeTrains = completeTrains;
	}

	public boolean zoekTrain(String naam) {
		boolean b = false;
		for (CompleteTrain gevonden : completeTrains) {
			if (gevonden.getLocomotive().getName().equals(naam)) {
				b = true;
			}
		}
		return b;
	}

	public boolean TrainExists(String id) {
		boolean b = false;

		if(completeTrains.isEmpty()== false){

			for (CompleteTrain zoekTrain : completeTrains) {
				Locomotive loco = zoekTrain.getLocomotive();
				String waardeNaam = loco.getName();
				if (waardeNaam.equals(id)) {
					b = true;
					break;
				}
			}
		}
		else{
			b = false;
		}
		return b;
	}
	
	public int geefAantalTreinen(){
		int aantal = 0;
		for(CompleteTrain t : completeTrains){
			aantal +=1;			
		}
		return aantal;
	}
	
	public int geefAantalWagons(){
		int aantal = 0;
		for(Wagon w : wagons){
			aantal +=1;
		}
		return aantal;
	}
	
	public boolean bestaatWagon(String name){
		boolean b = false;
		for(Wagon w : wagons){
			if (w.getName().equals(name)){
				b = true;
			}
		}
		return b;
	}

		

	
	public CompleteTrain getSelectedTrain(String name){
		
		for(CompleteTrain t : completeTrains){
			if(t.getLocomotive().getName().equals(name)){
				selectedTrain = t;
				}			
			}
		return selectedTrain;
	}
	
	public Wagon getSelectedWagon(String naam){
		
		for(Wagon w : wagons){
			if(w.getName().equals(naam)){
				selectedWagon = w;
				}
			}
		return selectedWagon;
		}
	

	// om de treinen/wagons op textvlak te tonen.
	public String getData() {
		String data = "wagons \n";

		for (CompleteTrain trains : completeTrains) {
			data += trains.toString();
		}
		return data;
	}

}