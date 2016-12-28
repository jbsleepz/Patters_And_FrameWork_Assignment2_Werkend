package Controller_command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Domain.TrainStation;

public class Command {

	TrainStation train = null;
	String[] characters = null;
	String outputMessage = "";

	public boolean execute() {
		return false;
	}

	public String getMessage() {
		return outputMessage;
	}

	public void setTrainStation(TrainStation trainStation) {
		this.train = trainStation;
	}

	public void setErrorMessage(String outputMessage) {
		this.outputMessage = outputMessage;
		System.out.print(outputMessage);
	}

	public void setParamaters(String[] characters) {
		this.characters = characters;
	}

	public boolean GeldigheidCommandcontrole(String waarde, String character) {

		Pattern pattern = Pattern.compile(waarde);
		Matcher matcher = pattern.matcher(character);

		boolean found = false;
		while (matcher.find()) {
			found = true;
		}
		return found;
	}

}
