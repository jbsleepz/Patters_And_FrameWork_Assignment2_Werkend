package Controller_Main;

import javax.swing.SwingUtilities;

import VoorHetTekenenVanShapes.GraphicalDrawer;
import VoorHetTekenenVanShapes.MenuGUI;

public class Controller {
	
	public void LaunchGraphicalInterface(){
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				MenuGUI menu = new MenuGUI();
				menu.setLocationRelativeTo(null);
				menu.setVisible(true);
			}
		});
		
	}

}
