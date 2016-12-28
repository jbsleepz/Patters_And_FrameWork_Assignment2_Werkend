package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import Domain.CompleteTrain;
import Domain.GoodsWagon;
import Domain.Locomotive;
import Domain.PassengerWagon;
import Domain.TrainStation;
import Domain.Wagon;


public class GraphicalDrawer extends javax.swing.JFrame implements ActionListener {

	private JPanel drawPanel, jPanel1, jPanel2, pnlWagons;

	// buttons die je kan aanroepen deleten en toevoegen en selecteren.
	private JButton btnDeleteWagon1, btnDeleteWagon2, btnDeleteWagon3, btnDeleteTrain;
	private JButton btnAddWagon1, btnDelWag1, btnAddWagon2,btnDelWagon2, btnNewTrain;
	private JButton btnChooseTrain;
	private JButton backToMenuGUI;

	// Textfields voor het aanmaken van een nieuwe trein.
	private JTextField tfNewTrain;

	// Labels voor het tonen van output.
	private JLabel lbCurrentTrain, tpTextTrain;

	// ComboBox om de treinen in te vullen.
	private JComboBox<String> cbAllTrains;
	
	//laat de trein zien die je nu hebt geselecteerd
	JTextArea textArea;


	// globale variable nodig voor het tekenen.
	private int currentNumberOfWagons = 1;
	private int currentTrainNumber = -1;


	// aanmaken van relaties voor objecten die aangemaakt gaan worden.
	private String selectedTrain;
	private CompleteTrain currentSelectedTrain;
	
	GraphicalShapeDrawer shapeDraw = new GraphicalShapeDrawer();
	TrainShape trainShape = new TrainShape();
	WagonShape wagonShape = new WagonShape();
	CompleteTrain completeTrain;
	TrainStation station = new TrainStation();
	ArrayList<CompleteTrain> trainArray = new ArrayList<CompleteTrain>();
	ArrayList<Wagon> wagonArray = new ArrayList<Wagon>();
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
					drawPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
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
				jPanel2.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
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
					//textfield voor de treinnamen
					tfNewTrain = new JTextField(20);
					jPanel2.add(tfNewTrain, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					//button die de trein aanmaakt
					btnNewTrain = new JButton();
					jPanel2.add(btnNewTrain, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnNewTrain.setText("make new train");
					btnNewTrain.addActionListener(this);
				}
				{

					// deze combobox moet gevuld worden met de waardes van het domain model : Trainstations of CompleteTrain.
					/*ComboBoxModel cbAllTrainsModel = new DefaultComboBoxModel(new String[trainArray.size()]);
					String[] array = trainNames.toArray(new String[trainNames.size()]);*/
					ComboBoxModel cbAllTrainsModel = 
							new DefaultComboBoxModel(
									new String[] { });
//					JComboBox comboBox = new JComboBox(array);
					cbAllTrains = new JComboBox<String>();
					
					//Voeg de combobox toe aan het panel linksonder
					jPanel2.add(cbAllTrains, new GridBagConstraints(1, 1, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					cbAllTrains.setModel(cbAllTrainsModel);
				}
				{
					//button waarmee je een trein  uit de combobox selecteerd
					btnChooseTrain = new JButton();
					jPanel2.add(btnChooseTrain, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnChooseTrain.setText("select train");
					btnChooseTrain.addActionListener(this);
					for(String s : trainNames){
						System.out.println(s);
					}
				}
				{
					//button voor het verwijderen van de geselecteerde trein
					btnDeleteTrain = new JButton();
					jPanel2.add(btnDeleteTrain, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnDeleteTrain.setText("delete train");
					btnDeleteTrain.addActionListener(this);
				}
				{
					textArea = new JTextArea("Er is nog geen trein Geselecteerd");
					Font f = new Font("Courier", Font.BOLD,20);
					textArea.setFont(f);
					textArea.setEditable(false);
					jPanel2.add(textArea, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

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
					btnDelWag1 = new JButton();
					pnlWagons.add(btnDelWag1, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnDelWag1.setText("del PersonenWagon");
					btnDelWag1.addActionListener(this);
				}
				{
					btnAddWagon2 = new JButton();
					pnlWagons.add(btnAddWagon2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnAddWagon2.setText("add GoederenWagon");
					btnAddWagon2.addActionListener(this);
				}
				{
					btnDelWagon2 = new JButton();
					pnlWagons.add(btnDelWagon2, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnDelWagon2.setText("del GoederenWagon");
					btnDelWagon2.addActionListener(this);
				}
				//knop voor het terugbrengen naar het hoofdmenu
				backToMenuGUI = new JButton();
				pnlWagons.add(backToMenuGUI, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				backToMenuGUI.setText("Terug naar menu");
				backToMenuGUI.addActionListener(this);
			}
			
			//zet alle panels/labels/buttons op de layout
			pack();
			setSize(1400, 1200);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//alle akties die er zijn als je op een knop drukt
	public void actionPerformed(ActionEvent event) {

		// Knop om een nieuwe trein aan te maken
		if (event.getSource() == btnNewTrain) {

			String waardeNieuweTrein = tfNewTrain.getText();
			if (waardeNieuweTrein != null && waardeNieuweTrein.trim().length() > 0) {
				
				if(trainNameExists(waardeNieuweTrein)==true){
					String s = "Deze trein komt al voor";
					System.out.println(s);
				}
				else{
					//maak locomotief + complete trein aan
					Locomotive locomotief = new Locomotive(waardeNieuweTrein);
					CompleteTrain complete = new CompleteTrain(locomotief);
					
					//voeg de complete trein toe aan de array met complete treinen
					if(trainNameExists(locomotief.getName()) == false){
						trainArray.add(complete);
						
						//vul de combobox met namen
						fillCombobox(cbAllTrains, locomotief.getName());
						System.out.println("trein is aanmaken is gelukt" + locomotief.getName());
						selectedTrain = locomotief.getName();
						currentSelectedTrain = complete;

						draw();
					}
				}				
			}
		}

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
		
		//dit verwijderd te gehele trein
		if(event.getSource()== btnDeleteTrain){
			for(CompleteTrain t : trainArray){
				if(t.getLocomotive().getName().equals(currentSelectedTrain.getLocomotive().getName())){
					trainArray.remove(t);
					break;
				}
			}
			draw();
		}
		
		//zet wagon type 1 bij de geselecteerde trein
		if(event.getSource() == btnAddWagon1){
			//voeg een wagon toe aan de geselecteerde trein
				wagonArray = currentSelectedTrain.getWagons();
				wagonArray.add(new PassengerWagon("type1", 20));
				currentSelectedTrain.setWagons(wagonArray);
				
				// teken de wagon type 1 bij de trein erbij
				draw();
			}
		
		if(event.getSource() == btnAddWagon2){
			wagonArray = currentSelectedTrain.getWagons();
			wagonArray.add(new GoodsWagon("type2", 1000));
			currentSelectedTrain.setWagons(wagonArray);
			
			//teken de wagon type 2 bij de trein erbij
			draw();
		}
		
		if(event.getSource() == btnDelWag1){
			currentSelectedTrain.deleteWagon("type1");
			
			draw();
			}
		
		if(event.getSource() == btnDelWagon2){
			currentSelectedTrain.deleteWagon("type2");
			
			draw();
			}

		
		// selecteerd de trein die je hebt geselecteerd uit de combobox
		if(event.getSource() == btnChooseTrain){
			Object o = cbAllTrains.getSelectedItem();
			selectedTrain = o.toString();
			textArea.setText("Geselecteerd: " +selectedTrain );
			for(CompleteTrain train : trainArray){
				if(train.getLocomotive().getName().equals(selectedTrain)){
					currentSelectedTrain = train;
					System.out.println("\nselected Train: "+selectedTrain.toString());
				}
			}
		}
		
		if(event.getSource() == "btnDelWag1"){
					deleteWagon1(selectedTrain);					
		}
	}



	

	private void deleteWagon1(String selectedTrain) {
		// TODO Auto-generated method stub		
	}

	//checkt of de treinnaam al bestaat bij aangemaakte treinen
	private boolean trainNameExists(String nameLocomotive){
		boolean exists = false;
		
		for (CompleteTrain train : trainArray){
			if (train.getLocomotive().getName().equals(nameLocomotive)){
				exists = true;
			}
		}
		return exists;	
	}
	
	//vult de combobox met alle aangemaakte treinen(locomotieven)
	private void fillCombobox(JComboBox box, String nameLocomotive) {
		
			trainNames.add(nameLocomotive);
			box.addItem(nameLocomotive);			
			}
	
	private void draw(){
		clearScreen();
					
		for (CompleteTrain train : trainArray){
			currentNumberOfWagons = 1;

			selectedTrain = train.getLocomotive().getName(); 
			System.out.println("komt ie hier?"+selectedTrain);
			//teken de locomotive
			shapeDraw.drawShapeObject(trainShape,selectedTrain, currentTrainNumber, drawPanel);

			
			if(train.getAmoundOfWagons()>0){
				wagonArray = train.getWagons();
				for(Wagon wag : wagonArray){
					shapeDraw.drawShapeObjectWagon(wagonShape, wag.getName(),currentTrainNumber, currentNumberOfWagons, drawPanel);
					currentNumberOfWagons +=1;
				}
			}
			currentTrainNumber +=1;
		}
		currentTrainNumber = -1;
	}
	
	private void clearScreen(){
		Graphics g = jPanel1.getGraphics();
		g.clearRect(0, 0, 1400, 1200);
	}
}
