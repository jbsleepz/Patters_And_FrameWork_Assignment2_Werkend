package Domain;
import java.util.ArrayList;

import LibariesImport.Program;

public class TrainStation {
	private ArrayList<CompleteTrain> completeTrains;
	
	public TrainStation(){
		completeTrains = new ArrayList<CompleteTrain>();
	}
	public TrainStation(ArrayList<CompleteTrain> train){
		train = new ArrayList<CompleteTrain>();
	}
	
	
	public void addTrain(CompleteTrain train){
		completeTrains.add(train);
	}
	
	public void removeTrain(CompleteTrain train){
		completeTrains.remove(train);
	}

	public ArrayList<CompleteTrain> getCompleteTrains() {
		return completeTrains;
	}

	public void setCompleteTrains(ArrayList<CompleteTrain> completeTrains) {
		this.completeTrains = completeTrains;
	}
	
	public boolean TrainExists(String id){
		boolean b = false;
		ArrayList<CompleteTrain> train = getCompleteTrains();
		
		for(CompleteTrain zoekTrain : train){
			if(zoekTrain.getLocomotive().getName().equals(id)){
				b = true;
				break;
			}
		}
		return b;
	}
	

}