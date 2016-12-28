package Controller_command;

import Domain.CompleteTrain;
import Domain.GoodsWagon;
import Domain.Locomotive;
import Domain.PassengerWagon;
import Domain.TrainStation;
import Domain.Wagon;
import LibariesImport.Program;

public class AddCommand extends Command {

	// example van command : new train tr1

	public boolean execute() {
		boolean b = true;

		if (characters[3].equals("to") || super.GeldigheidCommandcontrole("[a-z0-9]*", characters[1])
				|| super.GeldigheidCommandcontrole("[a-z0-9]*", characters[2])
				|| super.GeldigheidCommandcontrole("[a-z0-9]*", characters[4])) {
			Locomotive treintje = new Locomotive();
			treintje.setname(characters[4]);
			CompleteTrain completetrein = new CompleteTrain(treintje);
			if (characters[2].equals("Goods")) {
				Wagon w = new GoodsWagon(characters[1], 1000);
				completetrein.addWagons(w);
			} else if (characters[2].equals("Passenger")) {
				Wagon w = new PassengerWagon(characters[1], 20);
				completetrein.addWagons(w);
			} else {
				super.setErrorMessage("Het type is verkeerd meegegeven, example wg1 Passenger to tr1");
				b = false;
			}
		} else {
			super.setErrorMessage("De command is verkeerd meegegeven, example wg1 Passenger to tr1");
		}
		return b;

	}

}
