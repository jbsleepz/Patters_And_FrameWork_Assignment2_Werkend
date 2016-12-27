package GUI;

import javax.swing.JPanel;

public class GraphicalShapeDrawer {
	public void drawShapeObject(ShapeInterface s, String name, JPanel drawPanel){
		s.drawShape(name, drawPanel);
	}
	
	public void drawShapeObjectWagon(ShapeInterface s, String wagonName,int currentNumberOfWagons, JPanel drawPanel){
		s.drawShape(wagonName,currentNumberOfWagons, drawPanel);
	}
}
