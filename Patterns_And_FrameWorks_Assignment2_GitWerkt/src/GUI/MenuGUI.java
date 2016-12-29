package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import Controller_Main.CommandLineController;
import Domain.TrainStation;

public class MenuGUI extends javax.swing.JFrame implements ActionListener {

	private JButton commandlineInterface, normalInterface;
	private JLabel commandLine, normal;
	private JPanel jPanel1;
	

	public MenuGUI() {

		try {
			this.setTitle("MenuGIU");
			GridBagLayout thisLayout = new GridBagLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			thisLayout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
			thisLayout.rowHeights = new int[] { 7, 7, 7, 7 };
			thisLayout.columnWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
			thisLayout.columnWidths = new int[] { 7, 7, 7, 7 };
			getContentPane().setLayout(thisLayout);

			jPanel1 = new JPanel();
			GridBagLayout jPanel2Layout = new GridBagLayout();
			// jPanel2.setLayout(null);
			jPanel1.setLayout(jPanel2Layout);
			getContentPane().add(jPanel1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			{
				commandLine = new JLabel();
				normal = new JLabel();
				jPanel1.add(commandLine, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jPanel1.add(normal, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

				commandLine.setText("Button naar CommandLine interface");
				normal.setText("Button naar standaard interface");

				jPanel1.setBounds(10, 10, 100, 15);
				jPanel2Layout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
				jPanel2Layout.rowHeights = new int[] { 7, 7, 7, 7 };
				jPanel2Layout.columnWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
				jPanel2Layout.columnWidths = new int[] { 7, 7, 7, 7 };
				
				{
					commandlineInterface = new JButton();
					jPanel1.add(commandlineInterface, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					commandlineInterface.setText("Go to Command GUI");
					commandlineInterface.addActionListener(this);
				}
				{
					normalInterface = new JButton();
					jPanel1.add(normalInterface, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					normalInterface.setText("Go to Standard GUI");
					normalInterface.addActionListener(this);
				}
			}
			pack();
			setSize(800, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent event) {
	
		CommandLineController commandlineGUI = null;
		TrainStation train = new TrainStation();
		// gaat nar de commandLine GUI om daar snel objecten aan te kunnen maken.
		if (event.getSource() == commandlineInterface){
			
			commandlineGUI = new CommandLineController(train);
			commandlineGUI.show();
			setVisible(false);
			dispose(); 
		}
		
		// gaat naar het normale standaard GUI dat gebruikelijk was voor poorrail
		else if (event.getSource() == normalInterface){
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
		setVisible(false); //you can't see me!
		dispose(); 

	}

}
