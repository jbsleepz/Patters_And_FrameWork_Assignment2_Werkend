package Domain;

import java.util.ArrayList;

public class CompleteTrain {
	private String id;
	private Locomotive locomotive;
	private ArrayList<Wagon> wagons;

	public CompleteTrain(Locomotive l) {
	 	 locomotive = l;
		 locomotive = new Locomotive();
	};

	public CompleteTrain(Locomotive l, ArrayList<Wagon> wagons) {
		locomotive = l;
		locomotive = new Locomotive();
		wagons = new ArrayList<Wagon>();
	};

	public void addWagons(Wagon wagon) {
		wagons.add(wagon);
	}
	
	public void removeWagons(String wagon) {
		wagons.remove(wagon);
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
	
}