package Domain;

import java.util.ArrayList;

public class CompleteTrain {
	private String id;
	private Locomotive locomotive;
	private ArrayList<Wagon> wagons;

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
	
	public int getAmoundOfWagons(){
		
		int count = 0;
			for(Wagon w : wagons){
				count +=1;
			}
		return count;
	}
	
	public String toString(){
		return "" + id;
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
}
	