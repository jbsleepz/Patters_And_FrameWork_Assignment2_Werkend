package GUI;

import javax.swing.JPanel;

public abstract class Shape implements ShapeInterface{
	
	protected int OFFSET = 100;
	protected int TRAINLENGTH = 100;
	
	public void drawShape(String name, int currentTrain,String trainName, JPanel drawPanel){}
	public void drawShape(String name, int currentTrain, int currentNumberOfWagons, JPanel drawPanel){}


}
