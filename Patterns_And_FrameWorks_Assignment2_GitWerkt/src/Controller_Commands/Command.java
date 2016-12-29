package Controller_Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Domain.CompleteTrain;
import Domain.Locomotive;
import Domain.TrainStation;
import Domain.Wagon;

public class Command {

	CompleteTrain treintje;
	Locomotive loco;
	TrainStation train;
	Wagon wagentje;
	String[] characters;
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

	
	public void setWagonToTrainstation(){
		train.addWagon(wagentje);
	}
	public void setCompleteTrainToTrainStation(){
		train.addTrain(treintje);
	//	returnTrainstationToController();
	}
	
	
	

	public boolean GeldigheidCommandcontrole(String waarde, String character) {

		Pattern pattern = Pattern.compile(waarde);
		Matcher matcher = pattern.matcher(character);

		boolean b = false;
		while (matcher.find()) {
			b = true;
		}
		return b;
	}
	
	public TrainStation returnTrainstationToController(){
		return train;
	}


	public TrainStation getTrain() {
		return train;
	}

}
