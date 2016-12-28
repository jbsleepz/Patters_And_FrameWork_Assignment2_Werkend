package Domain;
import java.util.ArrayList;

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
	public CompleteTrain zoekTrain(String naam){
		CompleteTrain heleTrein = null;
		for(CompleteTrain zoekTrain : completeTrains) {
			if(zoekTrain.getLocomotive().getName().equals(naam)){
				heleTrein = zoekTrain;
			}
		}	
		return heleTrein;
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
	// om de treinen/wagons op textvlak te tonen.
		public String getData(){
			String data = "wagons \n";
			
			for(CompleteTrain trains: completeTrains){
				data += trains.toString();
			}
			return data;
		}
	

}