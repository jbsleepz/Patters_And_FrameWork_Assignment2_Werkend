package Controller_Main;

import javax.swing.SwingUtilities;

import VoorHetTekenenVanShapes.GraphicalDrawer;

public class Controller {
	
	public void LaunchGraphicalInterface(){
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				GraphicalDrawer drawer = new GraphicalDrawer();
				drawer.setLocationRelativeTo(null);
				drawer.setVisible(true);
			}
		});
	}

}
