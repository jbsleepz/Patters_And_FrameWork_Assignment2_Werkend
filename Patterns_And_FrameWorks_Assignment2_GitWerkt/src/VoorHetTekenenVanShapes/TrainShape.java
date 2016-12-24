package VoorHetTekenenVanShapes;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TrainShape extends Shape {
	
	public TrainShape(){
		super();
	}
	
	
	public void drawShape(String trainName, JPanel drawPannel){
		System.out.print("\n Er wordt een trein getekend.");
		
		Graphics g = drawPannel.getGraphics();
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(30,80+currentTrain*OFFSET,80,40);
		g.fillRect(80,60+currentTrain*OFFSET,30,30);
		g.drawRoundRect(85, 40+currentTrain*OFFSET, 20, 20, 20, 20);
		g.drawRoundRect(85, currentTrain*OFFSET, 40, 40, 40, 40);
		g.setColor(Color.BLACK);
		g.fillRoundRect(35, 120+currentTrain*OFFSET, 20, 20, 20, 20);
		g.fillRoundRect(80, 120+currentTrain*OFFSET, 20, 20, 20, 20);
		g.drawString(trainName,40,105+currentTrain*OFFSET);
	
		currentTrain += 1;
		
	}


}
