package Controller_command;

import java.util.ArrayList;

import Domain.CompleteTrain;
import Domain.GoodsWagon;
import Domain.Locomotive;
import Domain.PassengerWagon;
import Domain.TrainStation;
import Domain.Wagon;
import LibariesImport.Program;

public class NewTrainCommand extends CommandType{
	
	TrainStation trains;
	CompleteTrain completeTrain;
	
	@Override
	public void execute(String input) {
		String trainID = Program.after(input, "train");
		
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
				
			}
		}
		
	

}
