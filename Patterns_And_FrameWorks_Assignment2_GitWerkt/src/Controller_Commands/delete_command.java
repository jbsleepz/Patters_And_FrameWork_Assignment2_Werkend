package Controller_Commands;

public class delete_command extends Command {
	// doet jb
	// delete train tr1; // response: “train tr1 deleted”
	// delete train tr2; // response: “train tr2 does not exist”
	// token[0] is altijd de class name

	public boolean execute() {
		boolean b = true;

		if (characters[0].equals("delete") && characters[1].equals("train") && super.GeldigheidCommandcontrole("[a-z0-9]*", characters[2])) {
			if (characters[1].equals("train")) {
				if (train.TrainExists(characters[2])) {
					train.removeTrain(characters[2]);
					super.setErrorMessage("Train met de waarde : " + characters[2].toString() + " is verwijderd \n");
				} else {
					super.setErrorMessage("Trein bestaat niet");
					b = false;
				}
			}
		} else {
			super.setErrorMessage("De ingevoerde tekst is verkeerd, example : delete train <<naamTrein>> \n");
			b = false;
		}

		return b;
	}

}
