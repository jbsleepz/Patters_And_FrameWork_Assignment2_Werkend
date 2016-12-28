package Domain;

public class PassengerWagon extends Wagon {

	private int amountPassengers = 20;

	public PassengerWagon(String naam, int iAmountPassengers) {
		super.setName(naam);
		this.amountPassengers = iAmountPassengers;
	}

	public int getAmountPassengers() {
		return amountPassengers;
	}

	public void setAmountPassengers(int amountPassengers) {
		this.amountPassengers = amountPassengers;
	}

	public String toString() {
		return " " + super.getName() + " " + amountPassengers;
	}
}