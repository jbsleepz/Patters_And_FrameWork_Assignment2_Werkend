package Controller_Main;

import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller_Commands.Command;
import Domain.CompleteTrain;
import Domain.TrainStation;
import Domain.Wagon;
import GUI.CommandLineOutputStream;
import GUI.GraphicalDrawer;
import GUI.GraphicalDrawerCommandLine;
import GUI.GraphicalShapeDrawer;
import GUI.TrainShape;
import GUI.WagonShape;

public class CommandLineController implements ActionListener, KeyListener, Observer {
	private TrainStation station = new TrainStation();
	
	private JButton executeButton = null;
	private JPanel drawPanel = null;
	private JTextField TextCommandLine = null;
	private GraphicalDrawerCommandLine graphicalDrawerCommandLine;
	
	
	// aanmaken voor het tekenen van de treinen
	private GraphicalShapeDrawer shapedraw = new GraphicalShapeDrawer();
	TrainShape trainShape = new TrainShape();
	WagonShape wagonShape = new WagonShape();
	
	private int currentNumberOfWagons = 1;
	private int currentTrainNumber = -1;
	private String selectedTrain;
	
	private ArrayList<CompleteTrain> compTrains;
	private ArrayList<Wagon> wagons;
	

	public CommandLineController(TrainStation station) {
		this.station = station;
		/* station.addObserver(this); */
	}

	public void show() {
		JFrame GUIFrame = new JFrame("Rich Rail");
		GUIFrame.setResizable(false);
		GUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawPanel = new JPanel();
		TextCommandLine = new JTextField(40);
		executeButton = new JButton("Execute");
		executeButton.addActionListener(this);
		executeButton.setMnemonic(KeyEvent.VK_X);
		TextCommandLine.addKeyListener(this);
		graphicalDrawerCommandLine = new GraphicalDrawerCommandLine(GUIFrame, executeButton, TextCommandLine,
				drawPanel);
		GUIFrame.addWindowFocusListener(new WindowAdapter() {
			public void windowGainedFocus(WindowEvent e) {
				TextCommandLine.requestFocus();
			}
		});
		GUIFrame.pack();
		TextCommandLine.setRequestFocusEnabled(true);
		GUIFrame.setVisible(true);
		System.setOut(new PrintStream(new CommandLineOutputStream(graphicalDrawerCommandLine)));
	}

	// Deze methode is voor de controle van de commands
	@SuppressWarnings({ "rawtypes", "unused" })
	public void executeCommand() {
		// splitten van de command aan de hand van spatie.
		String command = graphicalDrawerCommandLine.getCommand();
		String[] characters = null;
		characters = command.split(" ");

		String className = "Controller_Commands." + characters[0] + "_command";

		// initialisatie van de Classe Command Object.
		try {
			Class klasse = Class.forName(className);
			Command object = (Command) klasse.newInstance();

			object.setTrainStation(station);
			object.setParamaters(characters);
			Boolean a = object.execute();

			
			
			teken();

			//vul de commandlinebox links
			
			/*fillcommandbox();*/
			
			
		/*	if (a == false) {
				teken();
			}*/

		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ingevoerde command is niet correct.");
		}

	}

	public void actionPerformed(ActionEvent e) {
		executeCommand();
	}

	
	public void teken(){
		clearScreen();
		fillCommandBox();
		
		compTrains = station.getCompleteTrains();
		/*CompleteTrain s = compTrains.get(0);*/


		
		for (CompleteTrain train : compTrains){
			currentNumberOfWagons = 1;
			selectedTrain = train.getLocomotive().getName(); 

			//teken de locomotive
			shapedraw.drawShapeObject(trainShape,selectedTrain, currentTrainNumber, drawPanel);

			
			if(train.getAmoundOfWagons()>0){
				wagons = train.getWagons();
				for(Wagon wag : wagons){
					
					
					//teken wagon
					shapedraw.drawShapeObjectWagon(wagonShape, wag.getName(),currentTrainNumber, currentNumberOfWagons, drawPanel);
					currentNumberOfWagons +=1;
				}
			}
			currentTrainNumber +=1;
		}
		currentTrainNumber = -1;
	}
	
	public void fillCommandBox(){
			String completeTreinen = "Dit zijn alle complete treinen: \n";
			String wagensTrein = "";
			String WagonsLos = "Deze wagons zijn nog niet toegekent aan een trein: \n";
			
			String tussen = "";
			String treintjes = "";
		for (CompleteTrain c : station.getCompleteTrains()){
			tussen = " " + c.getLocomotive().getName();
			treintjes += " "+ tussen;

			
			if(c.getAmoundOfWagons() > 0){
				for(Wagon w : c.getWagons()){
					tussen = " " + w.getName();
					wagensTrein += tussen;
				}
			}
			//wagons

		}
		if(station.geefAantalWagons() > 0 ){
			for(Wagon w: station.getWagons()){
				tussen += " " + w.getName();
				WagonsLos += tussen;
			}
		}
		
		
		String eindString = completeTreinen + "\n"+ treintjes + "\n" + wagensTrein + "\n" + WagonsLos;
		
			//output wagons van het station

		TextArea p = graphicalDrawerCommandLine.getTextArea();
		p.setText(eindString);
	}



	
	
private void clearScreen(){
		Graphics g = drawPanel.getGraphics();
		g.clearRect(0, 0, 1400, 1200);
	}


	
	
	
	
	
	
	/*public void teken() {
		String waarde;
		String[] split;
		BufferedReader reader = new BufferedReader(
				new StringReader(station.toString()));
		int tr = -1;
		
		GraphicalDrawer drawer = new GraphicalDrawer();
		
		try {
			while((waarde=reader.readLine())!=null){
				int wg = 0;
				tr++;
				graphicalDrawerCommandLine.setData(station.getData());
				split = waarde.split("-");
				drawer.draw();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TextCommandLine.setText("");
	}*/

	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		int keyUsed = event.getKeyCode();
		if (keyUsed == KeyEvent.VK_ENTER) {
			executeCommand();
		} else if (keyUsed == KeyEvent.VK_X && keyUsed == KeyEvent.VK_ALT) {
			executeCommand();
		}

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Observable o, Object arg) {
		this.teken();
	}

}
