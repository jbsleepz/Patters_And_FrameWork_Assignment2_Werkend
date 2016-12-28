package GUI;

import javax.swing.JPanel;

public interface ShapeInterface {

	public void drawShape(String trainName, int currentTrain, JPanel drawPanel);
	public void drawShape(String wagonName,int currentTrain,  int currentNumberOfWagons, JPanel drawPannel);
	/*public void drawShape();*/
}
