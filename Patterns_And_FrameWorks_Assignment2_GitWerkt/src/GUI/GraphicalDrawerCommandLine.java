package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import Controller_command.Command;

public class GraphicalDrawerCommandLine extends javax.swing.JFrame implements ActionListener  {
	
	//Jpanels
	private JPanel drawPanel, logging, commandLines ; 
	
	//Jtextfields
	private JTextField TextCommandLine , inputLines;
	
	//JButtons
	private JButton ButtonExectureCommand, backToMenuGUI;
	
	//JLabels
	private JLabel instructieLabel, outputLines;
	
	//TextAreas
	private TextArea commandView, logView;
	
	public GraphicalDrawerCommandLine(){
		try {
			Container pane = new Container();
			JButton ButtonExectureCommand = new JButton();
			JTextField newInput = new JTextField();
			JPanel newDrawPanel = new JPanel();
			
			//Grote van de Container.
			pane.setSize(new Dimension(1000,800));
			pane.setLayout(new GridBagLayout());
			GridBagConstraints container = new GridBagConstraints();
			
			//contex van het te tekenen Panel aanmaken.
			drawPanel = newDrawPanel;
			drawPanel.setBackground(Color.white);
			drawPanel.setPreferredSize(new Dimension(1000,300));
			container.fill = GridBagConstraints.HORIZONTAL;
			container.gridwidth = GridBagConstraints.REMAINDER;
			container.gridx = 0;
			container.gridy = 0;
			pane.add(drawPanel,container);
			
			//TextArea om de command input te zien.
			commandView = new TextArea();
			commandView.setSize(new Dimension(400,400));
			commandView.setEditable(false);
			
			//
			logging = new JPanel();
			JLabel jview = new JLabel("Output");
			logging.add(jview);
			logView = new TextArea();
			logView.setForeground(Color.WHITE);
			logView.setBackground(Color.black);
			logging.add(logView);
			
			
			container.gridwidth = 1;
			container.gridx = 0;
			container.gridy = 1;
			pane.add(commandView,container);
			container.gridx = 1;
			pane.add(logging,container);
			
			
			commandLines = new JPanel(new FlowLayout(0));
			JLabel linput = new JLabel("command");
			TextCommandLine = newInput;
			JButton bexe = ButtonExectureCommand;
			
			commandLines.add(linput);
			commandLines.add(TextCommandLine);
			commandLines.add(bexe);
			
			container.weightx = 1;
			container.gridx = 0;
			container.gridy = 3;
			pane.add(commandLines,container);
			
			
		} catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void actionPerformed(ActionEvent event) {
		
		Command command = new Command();
		
		if (event.getSource() == backToMenuGUI) {

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
		if (event.getSource() == ButtonExectureCommand){
			String inputText = TextCommandLine.getText();
			//controle(inputText) bestaat de command.
			if (command.GeldigheidCommandcontrole(inputText)== true){
				outputLines.setText("Doet iets");
				//command.ExecuteCommand(type);
				command.ExecuteCommand(command.getCommandType(inputText), inputText);
			} else {
				outputLines.setText("De command is ongeldig");
			}

		}
		
	}

}
