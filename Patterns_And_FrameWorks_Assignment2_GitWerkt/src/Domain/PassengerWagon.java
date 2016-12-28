package Domain;

public class PassengerWagon extends Wagon {
	private String name;
	private int amountPassengers = 20;

	public PassengerWagon(String name, int amountPassengers){
		this.name = name;
		this.amountPassengers = amountPassengers;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getAmountPassengers() {
		return amountPassengers;
	}  

	public void setAmountPassengers(int amountPassengers) {
		this.amountPassengers = amountPassengers;
	}

}