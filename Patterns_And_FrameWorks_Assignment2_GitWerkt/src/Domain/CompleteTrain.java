package Domain;

import java.util.ArrayList;

public class CompleteTrain {
	private Locomotive locomotive;
	private ArrayList<Wagon> wagons;

	public CompleteTrain(Locomotive l) {
	 	 locomotive = l;
		 locomotive = new Locomotive();
	};

	
	//Weet deze niet zeker, moet er bij deze constuctor ipv 'Wagon Wagons' niet 'Arraylist<Wagon> Wagons' staan?
	public CompleteTrain(Wagon Wagons) {
		wagons.add(Wagons);
	};

	public CompleteTrain(Locomotive l, Wagon wagons) {
		locomotive = l;
		locomotive = new Locomotive();
		this.wagons.add(wagons);
	};

	public void addWagons(Wagon wagon) {
		wagons.add(wagon);
	}
	
	public void removeWagons(Wagon wagon) {
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