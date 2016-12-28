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
	
	public void removeTrain(String verwijderWaarde){
		for(CompleteTrain zoekTrain : completeTrains){
			if(zoekTrain.getLocomotive().getName().equals(verwijderWaarde)){
				completeTrains.remove(zoekTrain);
				break;
			}
		}
	}

	public ArrayList<CompleteTrain> getCompleteTrains() {
		return completeTrains;
	}

	public void setCompleteTrains(ArrayList<CompleteTrain> completeTrains) {
		this.completeTrains = completeTrains;
	}
	
	public boolean TrainExists(String id){
		boolean b = false;
		
		for(CompleteTrain zoekTrain : completeTrains){
			if(zoekTrain.getLocomotive().getName().equals(id)){
				b = true;
				break;
			}
		}
		return b;
	}
	

}