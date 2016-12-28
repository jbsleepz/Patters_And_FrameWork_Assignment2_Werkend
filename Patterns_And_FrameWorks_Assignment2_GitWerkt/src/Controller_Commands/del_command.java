package Controller_Commands;

public class del_command extends Command {
	// doet jb
	// delete train tr1; // response: “train tr1 deleted”
	// delete train tr2; // response: “train tr2 does not exist”
	// token[0] is altijd de class name
	@Override
	public boolean execute() {
		boolean b = true;

		if (characters[1].equals("wagon") || characters[1].equals("train")
				|| super.GeldigheidCommandcontrole("[a-zA-Z0-9]*", characters[2])) {

			if (characters[1].equals("train")) {
				if (train.TrainExists(characters[2])) {

				}
			if (characters[1].equals("wagon")){
				train.removeTrain(train);
			}

			}
		}

		return b;
	}

}
