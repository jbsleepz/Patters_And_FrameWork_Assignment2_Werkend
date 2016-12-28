package GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class WagonShape extends Shape{
	
	public WagonShape(){
		super();
	}

	public void drawShape(String wagonName,int currentTrain,  int currentNumberOfWagons, JPanel drawPannel){
		
		System.out.println("\n Er wordt een wagon getekend");
		
		
			Graphics g = drawPannel.getGraphics();
			
			if(wagonName.equals("type1")){	
				g.setColor(Color.ORANGE);
			}
			else{
				g.setColor(Color.YELLOW);
			}			
			//grote blok
			g.fillRect(30+currentNumberOfWagons*TRAINLENGTH,200+currentTrain*OFFSET,80,40);
			
			g.setColor(Color.BLACK);
			
			//wiel 1
			g.fillRoundRect(35+currentNumberOfWagons*TRAINLENGTH, 240+currentTrain*OFFSET, 20, 20, 20, 20);
			
			//wiel 2
			g.fillRoundRect(80+currentNumberOfWagons*TRAINLENGTH, 240+currentTrain*OFFSET, 20, 20, 20, 20);
					
			//naam van type wagon
			g.drawString(wagonName,40+currentNumberOfWagons*TRAINLENGTH,220+currentTrain*OFFSET);
			System.out.println("Wagon is getekent");
			
	}


	@Override
	public void drawShape(String trainName, int currentNumberOfWagons, JPanel drawPanel) {
		// TODO Auto-generated method stub
		
	}

}
