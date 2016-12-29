package Domain;

public abstract class Wagon {
	protected String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public abstract String toString();
	

}