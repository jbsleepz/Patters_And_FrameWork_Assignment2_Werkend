package GUI;

import javax.swing.JPanel;

public class GraphicalShapeDrawer {
	public void drawShapeObject(ShapeInterface s, String name, JPanel drawPanel){
		s.drawShape(name, drawPanel);
	}
}
