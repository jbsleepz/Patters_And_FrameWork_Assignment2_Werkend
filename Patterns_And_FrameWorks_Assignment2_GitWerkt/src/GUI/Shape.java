package GUI;

import javax.swing.JPanel;

public abstract class Shape implements ShapeInterface{
	
	protected int currentTrain = -1;
	protected int currentNumberOfWeagons;
	protected int OFFSET = 100;
	protected int TRAINLENGTH = 100;
	
	public void drawShape(String name, JPanel drawPanel){}
	public void drawShape(String name, int currentNumberOfWagons, JPanel drawPanel){}


}
