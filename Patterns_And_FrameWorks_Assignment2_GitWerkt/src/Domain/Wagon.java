package Domain;

public class Wagon {
	private int typeNumber;
	private String name;
	
	public Wagon() {
	}
	
	public Wagon(int typeNumber, String name){
		this.typeNumber = typeNumber;
		this.name = name;
	}
	
	public int getTypeNumber() {
		return typeNumber;
	}
	public void setTypeNumber(int typeNumber) {
		this.typeNumber = typeNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}