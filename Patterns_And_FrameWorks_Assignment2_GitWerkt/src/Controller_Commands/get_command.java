package Controller_Commands;

import java.util.ArrayList;

import Domain.CompleteTrain;
import Domain.PassengerWagon;
import Domain.Wagon;

public class get_command extends Command {

	CompleteTrain treintje;

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		boolean b = false;

		if (characters[1].equals("train") || characters[1].equals("wagon") || characters[2].isEmpty()) {
			if (characters[1].equals("train")) {
				int aantalPlaatsen = 0;
				//treintje = train.zoekTrain(characters[2]);
			/*	ArrayList<Wagon> wagons = treintje.getWagons();
				
				int waarde = 0;
				for (Wagon wagon : wagons) {
					if (wagon instanceof PassengerWagon) {
						aantalPlaatsen += ((PassengerWagon) wagon).getAmountPassengers();
					}
				}*/
				super.setErrorMessage("aantal passagiers is : " + aantalPlaatsen + "\n");

			} else if (characters[1].equals("wagon")) {
				Wagon w = treintje.zoekWagon(characters[2]);
				int aantalPlaatsen = 0;
				if (w instanceof PassengerWagon) {
					aantalPlaatsen = ((PassengerWagon) w).getAmountPassengers();
					super.setErrorMessage("aantal passagiers is : " + aantalPlaatsen);
				} else {
					super.setErrorMessage(
							"aantal passagiers is : " + aantalPlaatsen + " want het is een goederen wagon");
				}
			}

		}

		return b;
	}

}
