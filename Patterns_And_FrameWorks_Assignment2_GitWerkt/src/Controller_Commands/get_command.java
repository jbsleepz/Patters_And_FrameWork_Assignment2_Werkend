package Controller_Commands;

public class get_command extends Command{
	//doet jb
	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		boolean b = false;
		
		if(characters[1].equals("train") || characters[1].equals("wagon")|| characters[2].isEmpty()){
			if(characters[1].equals("train")){
				if(train.TrainExists(characters[2])){
					train.getCompleteTrains();
					
				}
			}
			
			
		}
			
		
		
		return b;
	}

}
