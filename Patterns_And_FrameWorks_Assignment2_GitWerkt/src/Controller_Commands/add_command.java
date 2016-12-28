package Controller_Commands;

import Domain.CompleteTrain;
import Domain.GoodsWagon;
import Domain.Locomotive;
import Domain.PassengerWagon;
import Domain.TrainStation;
import Domain.Wagon;
import LibariesImport.Program;

public class add_command extends Command {

	// example van command : add <<wg1Naam>> <<type[goods/passenger]> to <<treinNaam>>

	public boolean execute() {
		boolean b = true;

		if (characters[3].equals("to") || super.GeldigheidCommandcontrole("[a-z0-9]*", characters[1])
				|| super.GeldigheidCommandcontrole("[a-z0-9]*", characters[2])
				|| super.GeldigheidCommandcontrole("[a-z0-9]*", characters[4])) {
			
			//moet gaan zoeken naar een treintje en niet een nieuwe aanmaken.
			
			Locomotive treintje = new Locomotive();
			treintje.setname(characters[4]);
			CompleteTrain completetrein = new CompleteTrain(treintje);
			if (characters[2].equals("goods")) {
				Wagon w = new GoodsWagon(characters[1], 1000);
				completetrein.addWagons(w);
				super.setErrorMessage("er is een goederen wagon aan trein" + treintje.toString() + " toegevoegd /n");
			} else if (characters[2].equals("passenger")) {
				Wagon w = new PassengerWagon(characters[1], 20);
				completetrein.addWagons(w);
				super.setErrorMessage("er is een passagiers wagon aan trein" + treintje.toString() + " toegevoegd /n");
			} else {
				super.setErrorMessage("Het type is verkeerd meegegeven, example wg1 Passenger to tr1 /n");
				b = false;
			}
		} else {
			super.setErrorMessage("De command is verkeerd meegegeven, example wg1 Passenger to tr1 /n");
		}
		return b;

	}

}
