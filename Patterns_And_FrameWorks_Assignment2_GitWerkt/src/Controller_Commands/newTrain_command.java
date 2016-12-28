package Controller_Commands;

import java.util.ArrayList;

import Domain.CompleteTrain;
import Domain.GoodsWagon;
import Domain.Locomotive;
import Domain.PassengerWagon;
import Domain.TrainStation;
import Domain.Wagon;
import LibariesImport.Program;

public class newTrain_command extends Command{
	
	/*TrainStation trains;
	CompleteTrain completeTrain;*/
	
	
	// example command: new train <<treinID>>
	@Override
	public boolean execute() {
		boolean b = true;
		
		if (characters[0].equals("new") && characters[1].equals("train")|| super.GeldigheidCommandcontrole("[a-z0-9]*", characters[2])) {
			Locomotive locomotive = new Locomotive();
			locomotive.setname(characters[2]);
			CompleteTrain completetrain = new CompleteTrain(locomotive);
			super.setErrorMessage("De trein " + locomotive.toString() + " is aangemaakt /n");
		} else {
			super.setErrorMessage("De command is verkeerd meegegeven, vb. ; 'new train tr1' /n");
		}
		return b;
		
		
			}
		}
		
	
/*

ArrayList<CompleteTrain> train = trains.getCompleteTrains();


for (CompleteTrain completeTrain : train) {
	Locomotive locomotive = completeTrain.getLocomotive();
		if(locomotive.getName().equals(trainID)){
			System.out.println("het meegegeven ID bestaat al");
			break;
			} 
		else 
			{
			new Locomotive(trainID);
			}
		*/
}
