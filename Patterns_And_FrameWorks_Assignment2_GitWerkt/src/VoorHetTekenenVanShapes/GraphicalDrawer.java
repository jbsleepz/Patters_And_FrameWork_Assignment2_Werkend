package VoorHetTekenenVanShapes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import Domain.CompleteTrain;
import Domain.Locomotive;
import Domain.TrainStation;

public class GraphicalDrawer extends javax.swing.JFrame implements ActionListener {

	private JPanel drawPanel, jPanel1, jPanel2, pnlWagons;

	// buttons die je kan aanroepen deleten en toevoegen en selecteren.
	private JButton btnDeleteWagon1, btnDeleteWagon2, btnDeleteWagon3, btnDeleteTrain;
	private JButton btnAddWagon1, btnAddWagon2, btnAddWagon3, btnNewTrain;
	private JButton btnChooseTrain;
	private JButton backToMenuGUI;

	// Textfields voor het aanmaken van een nieuwe trein.
	private JTextField tfNewTrain;

	// Labels voor het tonen van output.
	private JLabel lbCurrentTrain, tpTextTrain;

	// ComboBox om de treinen in te vullen.
	private JComboBox<String> cbAllTrains;

	// globale variable nodig voor het tekenen.
	private int currentNumberOfWagons = 1;


	// aanmaken van relaties voor objecten die aangemaakt gaan worden.
	GraphicalShapeDrawer shapeDraw = new GraphicalShapeDrawer();
	TrainShape trainShape = new TrainShape();
	WagonShape wagonShape = new WagonShape();
	CompleteTrain completeTrain;
	TrainStation station = new TrainStation();
	ArrayList<CompleteTrain> trainArray = new ArrayList<CompleteTrain>();

	
	
	

	ArrayList<String> trainNames = new ArrayList<String>();
	

	public GraphicalDrawer() {
		initGUI();
	}

	@SuppressWarnings("unchecked")
	public void initGUI() {
		try {
			this.setTitle("Rich Rails");

			// standaard waarden voor je grid pane waarop je de panels gaat
			// tekenen.

			GridBagLayout thisLayout = new GridBagLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			thisLayout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
			thisLayout.rowHeights = new int[] { 7, 7, 7, 7 };
			thisLayout.columnWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
			thisLayout.columnWidths = new int[] { 7, 7, 7, 7 };
			getContentPane().setLayout(thisLayout);

			// voor het tekenen van het witte scherm bovenin.
			{
				jPanel1 = new JPanel();
				jPanel1.setLayout(new BorderLayout());
				getContentPane().add(jPanel1, new GridBagConstraints(0, 0, 4, 2, 0.0, 0.0, GridBagConstraints.EAST,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					drawPanel = new JPanel();
					drawPanel.setBackground(Color.WHITE);
					jPanel1.add(drawPanel, BorderLayout.CENTER);
				}
			}

			/// Voor het tekenen van het scherm links onder.

			{
				jPanel2 = new JPanel();
				GridBagLayout jPanel2Layout = new GridBagLayout();
				// jPanel2.setLayout(null);
				jPanel2.setLayout(jPanel2Layout);
				getContentPane().add(jPanel2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					tpTextTrain = new JLabel();
					jPanel2.add(tpTextTrain, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jPanel2.setBounds(10, 10, 100, 15);
					jPanel2Layout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
					jPanel2Layout.rowHeights = new int[] { 7, 7, 7, 7 };
					jPanel2Layout.columnWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
					jPanel2Layout.columnWidths = new int[] { 7, 7, 7, 7 };
					tpTextTrain.setText("train name:");
				}
				{
					tfNewTrain = new JTextField(20);
					jPanel2.add(tfNewTrain, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					btnNewTrain = new JButton();
					jPanel2.add(btnNewTrain, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnNewTrain.setText("make new train");
					btnNewTrain.addActionListener(this);
				}
				{

					// deze combobox moet gevuld worden met de waardes van het domain model : Trainstations of CompleteTrain.
					ComboBoxModel cbAllTrainsModel = new DefaultComboBoxModel(new String[trainArray.size()]);
					String[] array = trainNames.toArray(new String[trainNames.size()]);
//					JComboBox comboBox = new JComboBox(array);
					cbAllTrains = new JComboBox<String>(array);
					
					jPanel2.add(cbAllTrains, new GridBagConstraints(1, 1, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					cbAllTrains.setModel(cbAllTrainsModel);

					/*
					 * String[] array = new String[trainArray.size()]; for(int i
					 * = 0; i < array.length; i++) { array[i] =
					 * trainArray.get(i); }
					 */

					/*
					 * GridLayout cbAllTrainsLayout = new GridLayout(1, 1);
					 * cbAllTrainsLayout.setColumns(1);
					 * cbAllTrainsLayout.setHgap(5);
					 * //cbAllTrainsLayout.setVgap(5);
					 * cbAllTrains.setLayout(cbAllTrainsLayout);
					 */

				}
				{
					btnChooseTrain = new JButton();
					jPanel2.add(btnChooseTrain, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnChooseTrain.setText("select train");
					btnChooseTrain.addActionListener(this);
				}
				{
					btnDeleteTrain = new JButton();
					jPanel2.add(btnDeleteTrain, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnDeleteTrain.setText("delete train");
					btnDeleteTrain.addActionListener(this);
				}
			}

			// Scherm rechtsboven om de wagens te gaan tekenen.

			{
				pnlWagons = new JPanel();
				GridBagLayout jPanel3Layout = new GridBagLayout();
				getContentPane().add(pnlWagons, new GridBagConstraints(1, 2, 2, 3, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jPanel3Layout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
				jPanel3Layout.rowHeights = new int[] { 7, 7, 7, 7 };
				jPanel3Layout.columnWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
				jPanel3Layout.columnWidths = new int[] { 7, 7, 7, 7 };
				pnlWagons.setLayout(jPanel3Layout);
				pnlWagons.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				{
					lbCurrentTrain = new JLabel();
					pnlWagons.add(lbCurrentTrain, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					lbCurrentTrain.setText("Adding and deleting wagons: ");
				}
				{
					btnAddWagon1 = new JButton();
					pnlWagons.add(btnAddWagon1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnAddWagon1.setText("add PersonenWagon");
					btnAddWagon1.addActionListener(this);
				}
				{
					btnAddWagon2 = new JButton();
					pnlWagons.add(btnAddWagon2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnAddWagon2.setText("del PersonenWagon");
					btnAddWagon2.addActionListener(this);
				}
				{
					btnAddWagon3 = new JButton();
					pnlWagons.add(btnAddWagon3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnAddWagon3.setText("add GoederenWagon");
					btnAddWagon3.addActionListener(this);
				}
				{
					btnDeleteWagon1 = new JButton();
					pnlWagons.add(btnDeleteWagon1, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnDeleteWagon1.setText("del GoederenWagon");
					btnDeleteWagon1.addActionListener(this);
				}

				backToMenuGUI = new JButton();
				pnlWagons.add(backToMenuGUI, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				backToMenuGUI.setText("Terug naar menu");
				backToMenuGUI.addActionListener(this);
			}
			pack();
			setSize(1400, 1200);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent event) {

		// Knop om een nieuwe trein aan te maken
		if (event.getSource() == btnNewTrain) {

			String waardeNieuweTrein = tfNewTrain.getText();
			if (waardeNieuweTrein != null && waardeNieuweTrein.trim().length() > 0) {
				//maak locomotief + complete trein aan
				Locomotive locomotief = new Locomotive(waardeNieuweTrein);
				CompleteTrain complete = new CompleteTrain(locomotief);
				
				//voeg de complete trein toe aan de array met complete treinen
				trainArray.add(complete);
				
				//vul de combobox met namen
				fillCombobox(cbAllTrains, locomotief.getname());
				System.out.println("trein is aanmaken is gelukt");

				
			}
				
//				addTrain(waardeNieuweTrein);

				// ipv addTrain uit deze klasse moet hij worden toegevoegd worden aan de klasse TrainStations
				// Daarnaast moet de arraylist van Trainstations worden ingelezen worden in de combobox. test test
				//cbAllTrains.getSelectedIndex();
				


			}
		
	{
		/*
		 * else if (event.getSource() == btnChooseTrain) { if
		 * (cbAllTrains.getItemCount() > 0) { String selection =
		 * (String)cbAllTrains.getSelectedItem(); tfCurrentTrain.setText(
		 * "selected: " + selection); int ti = cbAllTrains.getSelectedIndex();
		 * if (ti != currentTrain) { numberOfWagons.put(currentTrain,
		 * currentNumberOfWagons); } currentTrain = ti; try {
		 * currentNumberOfWagons = (Integer) numberOfWagons.get(currentTrain); }
		 * catch (Exception e) { currentNumberOfWagons = 0; } } } else if
		 * (event.getSource() == btnDeleteTrain) { if
		 * (cbAllTrains.getItemCount() > 0) { String t =
		 * (String)cbAllTrains.getSelectedItem();
		 * cbAllTrains.removeItemAt(cbAllTrains.getSelectedIndex());
		 * numberOfWagons.remove(t); repaint(); if
		 * ((String)cbAllTrains.getSelectedItem() != null) { currentTrain =
		 * cbAllTrains.getSelectedIndex(); tfCurrentTrain.setText("selected: " +
		 * (String)cbAllTrains.getSelectedItem()); } else { currentTrain = 0;
		 * tfCurrentTrain.setText("selected: "); } } } else if
		 * (event.getSource() == btnAddWagon1) { currentNumberOfWagons++;
		 * drawWagon("Wagon1"); } else if (event.getSource() == btnAddWagon2) {
		 * currentNumberOfWagons++; drawWagon("Wagon2"); } else if
		 * (event.getSource() == jButton1) { currentNumberOfWagons++;
		 * drawWagon("Wagon3"); } else if (event.getSource() == btnDeleteWagon1)
		 * { repaint(30+TRAINLENGTH,80+currentTrain*OFFSET,1,1); } else if
		 * (event.getSource() == btnDeleteWagon2) {
		 * repaint(30+TRAINLENGTH,80+currentTrain*OFFSET,1,1); } else if
		 * (event.getSource() == btnDeleteWagon3) {
		 * repaint(30+TRAINLENGTH,80+currentTrain*OFFSET,1,1); }
		 */
		
		//button om terug te keren naar het hoofdmenu.
		if(event.getSource() == backToMenuGUI) {

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					MenuGUI menu = new MenuGUI();
					menu.setLocationRelativeTo(null);
					menu.setVisible(true);
				}
			});
			setVisible(false);
			dispose();
		}
		
		if(event.getSource() == btnAddWagon1){
			shapeDraw.drawShapeObjectWagon(wagonShape, "type1" , currentNumberOfWagons, drawPanel);
			currentNumberOfWagons += 1;
		}
		
		if(event.getSource() == btnChooseTrain){
			Object o = cbAllTrains.getSelectedItem();
			//teken de trein
			shapeDraw.drawShapeObject(trainShape, o.toString(), drawPanel);
			System.out.print(trainNames.toString());
			String currentTrainName = o.toString();
			System.out.println("\nTrain: "+currentTrainName.toString());
		}
	}
	}
	


	private boolean trainNameExists(String nameLocomotive){
		boolean exists = false;
		
		for (CompleteTrain train : trainArray){
			if (train.getLocomotive().getname()== nameLocomotive){
				exists = true;
			}
		}
		return exists;
	
	}
	
	private void fillCombobox(JComboBox box, String nameLocomotive) {

		if(trainNameExists(nameLocomotive)==true){
			System.out.println("Trein bestaat al");
			}
		else{
			trainNames.add(nameLocomotive);
			String[] array = trainNames.toArray(new String[trainNames.size()]);
			box.addItem(array);
			
			}
		}

	}

//	public String addTrain(String train) {
//		String t = "";
//		try {
//			t = train.trim();
//			for (int i = 0; i < cbAllTrains.getItemCount(); i++) {
//				String cbTrain = (String) cbAllTrains.getItemAt(i);
//				if (cbTrain.equalsIgnoreCase(t)) {
//					t = "";
//					break;
//				}
//			}
//			if (t != "") {
//				if (currentTrain >= 0) {
//					numberOfWagons.put(currentTrain, currentNumberOfWagons);
//				}
//				cbAllTrains.addItem(t);
//				cbAllTrains.setSelectedItem(t);
//				numberOfWagons.put(t, 0);
//			}
//		} catch (Exception e) {
//		}
//		return t;
//
//	}


