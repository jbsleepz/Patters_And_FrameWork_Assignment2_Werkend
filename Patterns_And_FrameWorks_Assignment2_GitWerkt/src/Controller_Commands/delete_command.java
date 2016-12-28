package Controller_Commands;

public class delete_command extends Command {
	// doet jb
	// delete train tr1; // response: “train tr1 deleted”
	// delete train tr2; // response: “train tr2 does not exist”
	// token[0] is altijd de class name

	public boolean execute() {
		boolean b = true;

		if (characters[2].equals("train") || super.GeldigheidCommandcontrole("[a-z0-9]*", characters[1])) {
			if (train.TrainExists(characters[1])) {
				train.removeTrain(characters[1]);
			} else {
				super.setErrorMessage("Trein bestaat niet");
				b = false;
			}
		} else {
			super.setErrorMessage("De ingevoerde tekst is verkeerd, example : delete train <<naamTrein>>");
			b = false;
		}

		return b;
	}

}
