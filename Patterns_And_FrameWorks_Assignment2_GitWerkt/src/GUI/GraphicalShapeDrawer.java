package GUI;

import javax.swing.JPanel;

public class GraphicalShapeDrawer {
	public void drawShapeObject(ShapeInterface s,String currentTrainName,int currentTrainNumber,  JPanel drawPanel){
		s.drawShape(currentTrainName,currentTrainNumber, drawPanel);
	}
	
	public void drawShapeObjectWagon(ShapeInterface s, String wagonName,int currentTrain,int currentNumberOfWagons, JPanel drawPanel){
		s.drawShape(wagonName,currentTrain, currentNumberOfWagons,  drawPanel);
	}

}
