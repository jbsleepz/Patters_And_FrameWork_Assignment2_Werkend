package Domain;

import java.util.ArrayList;
import java.util.HashMap;

public class TrainStation extends java.util.Observable {
	private ArrayList<CompleteTrain> completeTrains = new ArrayList<CompleteTrain>();
	private ArrayList<Locomotive> locomotives = new ArrayList<Locomotive>() ;
	
	
	
	
	public ArrayList<Locomotive> getLocomotives() {
		return locomotives;
	}
	public void setLocomotives(ArrayList<Locomotive> locomotives) {
		this.locomotives = locomotives;
	}
	public ArrayList<Wagon> getWagons() {
		return wagons;
	}
	public void setWagons(ArrayList<Wagon> wagons) {
		this.wagons = wagons;
	}

	private ArrayList<Wagon> wagons = new ArrayList<Wagon>();
	/*private HashMap<String,Locomotive> locomotiveOpslag = new HashMap<String, Locomotive>();
	private HashMap<String,CompleteTrain> completeTrainsOpslag = new HashMap<String, CompleteTrain>();
	private HashMap<String,Wagon> wagonOpslag = new HashMap<String, Wagon>();
	*/
	
	public TrainStation() {

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
	public void addLocomotive(Locomotive l){
		locomotives.add(l);
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

	public CompleteTrain zoekTrain(String naam) {
		CompleteTrain heleTrein = null;
		for (CompleteTrain zoekTrain : completeTrains) {
			if (zoekTrain.getLocomotive().getName().equals(naam)) {
				heleTrein = zoekTrain;
			}
		}
		return heleTrein;
	}

	public boolean TrainExists(String id) {
		boolean b = false;

		for (CompleteTrain zoekTrain : completeTrains) {
			Locomotive loco = zoekTrain.getLocomotive();
			String waardeNaam = loco.getName();
			if (waardeNaam.equals(id)) {
				b = true;
				break;
			}
		}
		return b;
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