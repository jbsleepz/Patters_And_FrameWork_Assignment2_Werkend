package Domain;

public class Locomotive {
	//private int horsepower;
	private String name;
	private int totaalAantalStoelen = 0;

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


	public int getTotaalAantalStoelen() {
		return totaalAantalStoelen;
	}


	public void setTotaalAantalStoelen(int totaalAantalStoelen) {
		this.totaalAantalStoelen = totaalAantalStoelen;
	}
	public void verwijderPlaatsen(int removeSeat){
		totaalAantalStoelen -= removeSeat;
	}

}