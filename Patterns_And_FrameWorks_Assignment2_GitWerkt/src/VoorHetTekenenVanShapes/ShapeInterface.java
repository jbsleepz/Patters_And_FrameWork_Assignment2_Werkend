package VoorHetTekenenVanShapes;

import javax.swing.JPanel;

public interface ShapeInterface {

	public void drawShape(String name, JPanel drawPanel);
	public void drawShape(String name, int currentNumberOfWagons, JPanel drawPanel);
	/*public void drawShape();*/
}
