package Controller_command;

public class Command {
	private String command;

	public void input() {

	};

	public boolean GeldigheidCommandcontrole(String controle){
		Boolean b = false;
		
				if(controle.contains("add to") ){
					b = true;
				} else if(controle.contains("delete")) {
					b = true;
				} else if(controle.contains("getnumseats")) {
					b = true;
				}else if(controle.contains("new train")) {
					b = true;
				}else if(controle.contains("new wagon")){
					// type van wagon checken of het goederen is of passagiers anders moeten het aantal stoelen nog mee.
					b = true;
				}else if(controle.equalsIgnoreCase("REMCOMMAND")){
					b = true;
				}
		return b;
	}
	public Boolean ExecuteCommand(String type){
		boolean b = false;
		CommandType command = null;
		//type.equalsIgnoreCase("ADDCOMMAND") &&
		
		if(type.contains("add") && type.contains("to") ){
			b = true;
			System.out.println("Test, hij geeft true terug");
			command = new AddCommand();	
		} else if(type.equalsIgnoreCase("DELCOMMAND") ) {
			command = new DelCommand();
		} else if(type.equalsIgnoreCase("GETCOMMAND")) {
			command = new GetCommand();
		}else if(type.equalsIgnoreCase("NEWTRAINCOMMAND")) {
			command = new NewTrainCommand();
		}else if(type.equalsIgnoreCase("NEWWAGONCOMMAND")){
			command = new NewWagonCommand();
		}else if(type.equalsIgnoreCase("REMCOMMAND")){
			command = new RemCommand();
		}
		System.out.println("Test, hij geeft false terug");
		command.execute();
		return b;
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
