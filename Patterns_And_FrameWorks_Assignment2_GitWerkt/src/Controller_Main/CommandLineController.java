package Controller_Main;

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
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller_command.Command;
import Domain.TrainStation;
import GUI.CommandLineOutputStream;
import GUI.GraphicalDrawerCommandLine;

public class CommandLineController implements ActionListener, Observer{
	private TrainStation station = null;
	private JButton executeButton = null;
	private JPanel drawpanel = null;
	private JTextField input = null;
	private GraphicalDrawerCommandLine graphicalDrawerCommandLine;
	
	public CommandLineController(TrainStation station){
		this.station = station;
		/*station.addObserver(this); */
	}
	
	public void show(){
		JFrame GUIFrame = new JFrame("Rich Rail");
		GUIFrame.setResizable(false);
		GUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawpanel = new JPanel();
		input = new JTextField(40);
		executeButton = new JButton("Execute");
		executeButton.addActionListener(this);
		executeButton.setMnemonic(KeyEvent.VK_X);
		//input.addKeyListener(this);
		graphicalDrawerCommandLine = new GraphicalDrawerCommandLine(GUIFrame,executeButton,input,drawpanel);
		GUIFrame.addWindowFocusListener(new WindowAdapter() {
			public void windowGainedFocus(WindowEvent e){
				input.requestFocus();
			}
		});
		GUIFrame.pack();
		input.setRequestFocusEnabled(true);
		GUIFrame.setVisible(true);
		System.setOut(new PrintStream(new CommandLineOutputStream(graphicalDrawerCommandLine)));
		
	}
	
	
		
	public void actionPerformed(ActionEvent e) {
	/*	Command command = new Command();
		String inputText = TextCommandLine.getText();
		//controle(inputText) bestaat de command.
		if (command.GeldigheidCommandcontrole(inputText)== true){
			outputLines.setText("Doet iets");
			//command.ExecuteCommand(type);
			command.ExecuteCommand(command.getCommandType(inputText), inputText);
		} else {
			outputLines.setText("De command is ongeldig");
		}*/
	}

/*	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		int keyUsed = event.getKeyCode();
		if (keyUsed == KeyEvent.VK_ENTER) {
			doCommand();
		}else if(keyUsed==KeyEvent.VK_X && keyUsed == KeyEvent.VK_ALT){
			doCommand();
		}
		
	}*/

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	
/*	public void paint() throws IOException{
		String str;
		String[] split;
		BufferedReader reader = new BufferedReader(
				new StringReader(model.toString()));
		int tr = -1;
		
		
		
		while((str=reader.readLine())!=null){
			int wg = 0;
			tr++;
			graphicalDrawerCommandLine.setData(model.getData());
			split = str.split("-");
			drawTrain(split[0],tr);
			for(int i=1;i<split.length;i++){
				wg++;
				graphicalDrawerCommandLine.setData("wg:"+wg);
				drawWagon(split[i],wg, tr);
			}
		}
		input.setText("");
	}*/

/*	public void update(Observable observer, Object object) {
		try {
			this.paint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Er kon niks worden getekend.");
		}
	}*/
	//
/*	public void drawTrain(String t,int i){
		
		graphicalDrawerCommandLine.drawTrain(t,i);
	}
	
	public void drawWagon(String w, int wg, int tr){
		graphicalDrawerCommandLine.drawWagon(w,wg,tr);
	}
		public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	*
	*
	*
	*/
/*	//Kijkt of de command een goede waarde is.
		@SuppressWarnings("unchecked")
		public void doCommand(){
			String command = graphicalDrawerCommandLine.getCommand();
			String [] charaters = null;
			charaters = command.split(" ");
	  
			String className = " command." + charaters[0] + "_command";

			//Try to instantiate command, else error.
			try {
				Class clas = Class.forName( className );
				Command object = (Command) clas.newInstance();
			    
				object.setTrainManagment(model);
				object.setParams(tokens);
				Boolean a = object.ExecuteCommand(type, input); .Action();
				
				if(a == false) {
					paint();
				}
			}	
			catch (ClassNotFoundException e) {
				System.out.println("command not correct" );
			} catch( Exception e ) {
				System.out.println("command not correct.");
			} 

		}*/

}
