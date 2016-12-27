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
		
		//grote blok
		g.fillRect(30, 200+currentTrain*OFFSET, 80, 40);
		//kleine blok
		g.fillRect(70,170+currentTrain*OFFSET,40,40);
		//stoom 1
		g.drawRoundRect(70, 150+currentTrain*OFFSET, 20, 20, 20, 20);
		//stoom 2
		g.drawRoundRect(90, 125+ currentTrain*OFFSET, 35, 35, 35, 35);
		g.setColor(Color.BLACK);
		//wiel 1
		g.fillRoundRect(35, 240+currentTrain*OFFSET, 20, 20, 20, 20);
		//wiel 2
		g.fillRoundRect(80, 240+currentTrain*OFFSET, 20, 20, 20, 20);
		g.drawString(trainName,40, 220+currentTrain*OFFSET);
	
		currentTrain += 2;
		
	}


	@Override
	public void drawShape(String name, int currentNumberOfWagons, JPanel drawPanel) {
		// TODO Auto-generated method stub
		
	}


}
