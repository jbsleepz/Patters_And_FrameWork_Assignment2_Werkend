package Domain;

public class GoodsWagon extends Wagon {
	private int maxWeight;
	
	public GoodsWagon(String naam, int maxWeight){
		super.setName(naam);
		this.maxWeight = maxWeight;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	public String toString(){
		return " " + super.getName() + " met als maximale belading: " + maxWeight + " kg.";
	}
	
}