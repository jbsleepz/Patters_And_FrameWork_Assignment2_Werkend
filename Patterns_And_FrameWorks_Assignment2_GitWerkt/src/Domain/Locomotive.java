package Domain;

public class Locomotive {
	//private int horsepower;
	private String name;

	public Locomotive(String name){
		this.name = name;
	}


	public Locomotive() {
	}


	/*public int getHorsepower() {
		return horsepower;
	}
	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}
*/
	public String getName() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	public String toString(){
		return " " + name;
	}

}