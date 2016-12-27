package Domain;

public class PassengerWagon extends Wagon {
	private int amountPassengers;

	public PassengerWagon(){
		super();
	}
	
	public int getAmountPassengers() {
		return amountPassengers;
	}  

	public void setAmountPassengers(int amountPassengers) {
		this.amountPassengers = amountPassengers;
	}

}