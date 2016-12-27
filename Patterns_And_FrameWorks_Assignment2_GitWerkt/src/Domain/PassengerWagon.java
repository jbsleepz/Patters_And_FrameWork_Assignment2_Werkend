package Domain;

public class PassengerWagon extends Wagon {
	private int amountPassengers;

	public PassengerWagon(String name, int amountPassengers){
		super.setName(name);
		this.amountPassengers = amountPassengers;
	}
	
	public String getName(){
		return super.getName();
	}
	
	public void setName(String name){
		super.setName(name);
	}
	
	public int getAmountPassengers() {
		return amountPassengers;
	}  

	public void setAmountPassengers(int amountPassengers) {
		this.amountPassengers = amountPassengers;
	}

}