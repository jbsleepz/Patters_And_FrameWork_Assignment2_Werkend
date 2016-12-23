package VoorHetTekenenVanShapes;

import javax.swing.JPanel;

public abstract class Shape implements ShapeInterface{
	
	protected int currentTrain = -1;
	protected int OFFSET = 100;
	protected int TRAINLENGTH = 100;
	
	public void drawShape(String name, JPanel drawPanel){}


}
