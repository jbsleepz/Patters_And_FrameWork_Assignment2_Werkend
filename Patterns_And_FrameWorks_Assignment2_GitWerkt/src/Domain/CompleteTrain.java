package Domain;

import java.util.ArrayList;

public class CompleteTrain {
	private String idCompleteTrain;
	private Locomotive locomotive;
	private ArrayList<Wagon> wagons;
	private Wagon selectedWagon = null;
	
	public CompleteTrain(){
		
	}

	public CompleteTrain(Locomotive l) {
	 	 locomotive = l;
		 wagons = new ArrayList<Wagon>();
	}

	public CompleteTrain(Locomotive l, ArrayList<Wagon> wagons) {
		locomotive = l;
		locomotive = new Locomotive();
		wagons = new ArrayList<Wagon>();
	};

	public void addWagons(Wagon wagon) {
		wagons.add(wagon);
		}
	
	public void removeWagons(Wagon wagon) {
		wagons.remove(wagon);
		if ( wagon instanceof PassengerWagon){
			locomotive.verwijderPlaatsen(((PassengerWagon) wagon).getAmountPassengers());
		}
	}
	public Wagon zoekWagon(String naam){
		Wagon wagon = null;
		for(Wagon zoek: wagons){
			if (zoek.getName().equals(naam)){
				wagon = zoek;
			}
		}
		return wagon;
	}
	
	public ArrayList<Wagon> getWagons() {
		return wagons;
	}

	public void setWagons(ArrayList<Wagon> wagons) {
		this.wagons = wagons;
	}

	public Locomotive getLocomotive(){
		return locomotive;
	}
	
	public int getAmoundOfWagons(){
		
		int count = 0;
			for(Wagon w : wagons){
				count +=1;
			}
		return count;
	}

	public void deleteWagon(String name) {
		int index = wagons.size()-1;

		for(Wagon w : wagons){
			Wagon wag = wagons.get(index);
			if(wag.getName().equals(name)){
				wagons.remove(index);
				break;
			}
			else{
				index -=1;
			}
		}
	}
	public void setLocomotive(Locomotive locomotive) {
		this.locomotive = locomotive;
		setIdCompleteTrain(locomotive.getName());
	}


	public String getIdCompleteTrain() {
		return idCompleteTrain;
	}

	public void setIdCompleteTrain(String idCompleteTrain) {
		this.idCompleteTrain = idCompleteTrain;
	}
	
	
	public String toString(){
		return "" + idCompleteTrain;
	}

	public Wagon getSelectedWagon(String string) {
		for(Wagon w: wagons){
			if(w.getName().equals(string)){
				selectedWagon = w;
				break;
			}
		}
		return selectedWagon;
	}
}
	