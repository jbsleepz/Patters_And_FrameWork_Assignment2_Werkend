package GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class WagonShape extends Shape{
	
	public WagonShape(){
		super();
	}

	public void drawShape(String wagonName, int currentNumberOfWagons, JPanel drawPannel){
		
		System.out.println("\n Er wordt een wagon getekend");
		
		
			Graphics g = drawPannel.getGraphics();
			g.setColor(Color.LIGHT_GRAY);

			g.fillRect(30+currentNumberOfWagons*TRAINLENGTH,200+currentTrain*OFFSET,80,40);
			g.setColor(Color.BLACK);
			g.fillRoundRect(35+currentNumberOfWagons*TRAINLENGTH, 240+currentTrain*OFFSET, 20, 20, 20, 20);
			g.fillRoundRect(80+currentNumberOfWagons*TRAINLENGTH, 240+currentTrain*OFFSET, 20, 20, 20, 20);
			g.drawString(wagonName,40+currentNumberOfWagons*TRAINLENGTH,220+currentTrain*OFFSET);

			
	}

}