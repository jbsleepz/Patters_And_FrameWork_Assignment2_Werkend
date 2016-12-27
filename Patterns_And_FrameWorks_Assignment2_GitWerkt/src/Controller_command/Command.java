package Controller_command;

public class Command {
	CommandType command = null;

	public boolean GeldigheidCommandcontrole(String controle){
		Boolean b = false;
		
				if(controle.contains("add") && controle.contains("to") ){
					b = true;
				} else if(controle.contains("delete")) {
					b = true;
				} else if(controle.contains("getnumseats")) {
					b = true;
				}else if(controle.contains("new") && controle.contains("train") ) {
					b = true;
				}else if(controle.contains("new") && controle.contains("wagon")){
					// type van wagon checken of het goederen is of passagiers anders moeten het aantal stoelen nog mee.
					b = true;
				}else if(controle.contains("remove") && controle.contains("from")){
					b = true;
				}
		return b;
	}
	public CommandType getCommandType(String type){
	
		//type.equalsIgnoreCase("ADDCOMMAND") &&
		
		if(type.contains("add") && type.contains("to") ){
			System.out.println("Test, hij geeft true terug");
			command = new AddCommand();	
		} else if(type.contains("delete")) {
			command = new DelCommand();
		} else if(type.contains("getnumseats")) {
			command = new GetCommand();
		}else if(type.contains("new") && type.contains("train") ) {
			command = new NewTrainCommand();
		}else if(type.contains("new") && type.contains("wagon")){
			// type van wagon checken of het goederen is of passagiers anders moeten het aantal stoelen nog mee.
			command = new NewWagonCommand();
		}else if(type.contains("remove") && type.contains("from")){
			command = new RemCommand();
		}
		return command;
	}
	
	public void ExecuteCommand(CommandType type){
		CommandType comType = type;
		comType.execute();
	}
	
	
	/*
	 * newcommand | addcommand | getcommand | delcommand | remcommand
	 *newcommand 	: newtraincommand | newwagoncommand;
newtraincommand : 'new' 'train' ID;
newwagoncommand	: 'new' 'wagon' ID ('numseats' NUMBER)?;
addcommand 	: 'add' ID 'to' ID;
getcommand 	: 'getnumseats' type ID;
delcommand 	: 'delete' type ID;
remcommand	: 'remove' ID 'from' ID;

type		: ('train') | ('wagon');

ID		: ('a'..'z')('a'..'z'|'0'..'9')*;
NUMBER		: ('0'..'9')+;
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+;

	 */
}
