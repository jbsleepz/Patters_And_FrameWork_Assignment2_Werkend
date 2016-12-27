package Controller_command;
import Domain.CompleteTrain;
import Domain.GoodsWagon;
import Domain.TrainStation;
import Domain.Wagon;
import LibariesImport.Program;

public class AddCommand extends CommandType{
	Program program;
	//doet jb
	//'add' ID 'to' ID;
	//add wg1 to tr1; // response: “wagon wg1 added to train tr1”
	
	String a = "add";
	String b = "to";
	
	@Override
	public void execute(String input) {
		String ObjectAFromWagon = program.between(input, a, b);
		String ObjectBtoTrain = program.after(input, b);
		
		CompleteTrain compTrain;
		TrainStation station; 
		//station.searchTrain();
		Wagon wagon = new GoodsWagon(ObjectAFromWagon);
		compTrain.addWagons(wagon);
		
	}

}
