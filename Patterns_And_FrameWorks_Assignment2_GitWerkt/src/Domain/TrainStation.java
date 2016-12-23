package Domain;
import java.util.ArrayList;

public class TrainStation {
	private ArrayList<CompleteTrain> completeTrains;
	
	public TrainStation(){
		completeTrains = new ArrayList<CompleteTrain>();
	}
	
	public void addTrain(CompleteTrain trein){
		completeTrains.add(trein);
	}

	public ArrayList<CompleteTrain> getCompleteTrains() {
		return completeTrains;
	}

	public void setCompleteTrains(ArrayList<CompleteTrain> completeTrains) {
		this.completeTrains = completeTrains;
	}
	

}
