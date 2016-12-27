package Domain;

public abstract class Wagon {
	private String name;
	
	public Wagon() {
	}
	
	public Wagon(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}