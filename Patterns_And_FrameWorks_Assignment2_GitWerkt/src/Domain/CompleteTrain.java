package Domain;

import java.util.ArrayList;

public class CompleteTrain {
	private Locomotive locomotive;
	private ArrayList<Wagon> wagons = new ArrayList<Wagon>();

	public CompleteTrain(Locomotive l) {
		locomotive = new Locomotive();
		locomotive = l;
	};

	public CompleteTrain(Wagon Wagons) {
	};

	public CompleteTrain(Locomotive l, Wagon wagons) {
	};

	public void addWagons(Wagon wagon) {
		wagons.add(wagon);
	}

	public ArrayList<Wagon> getWagons() {
		return wagons;
	}

	public void setWagons(ArrayList<Wagon> wagons) {
		this.wagons = wagons;
	}

}
