package VoorHetTekenenVanShapes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import Controller_command.Command;

public class GraphicalDrawerCommandLine extends javax.swing.JFrame implements ActionListener  {
	
	//Jpanels
	private JPanel logging, tekenObjecten, commandLines, drawPanel ; 
	
	//Jtextfields
	private JTextField TextCommandLine , inputLines;
	
	//JButtons
	private JButton ButtonExectureCommand, backToMenuGUI;
	
	//JLabels
	private JLabel instructieLabel, outputLines;
	
	public GraphicalDrawerCommandLine(){
		try 
		{
			this.setTitle("Rich Rails");
			
			// standaard waarden voor je grid pane waarop je de panels gaat tekenen.
			
			GridBagLayout thisLayout = new GridBagLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			thisLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			thisLayout.rowHeights = new int[] {7, 7, 7, 7};
			thisLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			thisLayout.columnWidths = new int[] {7, 7, 7, 7};
			getContentPane().setLayout(thisLayout);
			
			// voor het tekenen van het witte scherm bovenin.
			{
				tekenObjecten = new JPanel();
				tekenObjecten.setLayout(new BorderLayout());
				getContentPane().add(tekenObjecten, new GridBagConstraints(0, 0, 4, 2, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					drawPanel = new JPanel();
					drawPanel.setBackground(Color.WHITE);
					tekenObjecten.add(drawPanel,BorderLayout.CENTER);
				}
				
			}
			
			/// Voor het tekenen van het scherm links onder.
			
			{
				commandLines = new JPanel();
				GridBagLayout commandLinesLayout = new GridBagLayout();
				//commandLines.setLayout(null);
				commandLines.setLayout(commandLinesLayout);
				getContentPane().add(commandLines, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					instructieLabel = new JLabel();
					commandLines.add(instructieLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					commandLines.setBounds(10, 10, 100, 15);
					commandLinesLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
					commandLinesLayout.rowHeights = new int[] {12, 12, 12, 12};
					commandLinesLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
					commandLinesLayout.columnWidths = new int[] {9, 9, 9, 9};
					instructieLabel.setText("train name:");
				}
			
				{
					TextCommandLine = new JTextField(30);
					commandLines.add(TextCommandLine, new GridBagConstraints(0, 4, 5, 5, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					ButtonExectureCommand = new JButton();
					commandLines.add(ButtonExectureCommand, new GridBagConstraints(4, 5, 5, 5, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					ButtonExectureCommand.setText("Execute Command");
					ButtonExectureCommand.addActionListener(this);
				}
				{
					backToMenuGUI = new JButton();
					commandLines.add(backToMenuGUI, new GridBagConstraints(8, 15, 6, 1, 0.0, 0.0, GridBagConstraints.EAST,GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					backToMenuGUI.setText("Terug naar menu");
					backToMenuGUI.addActionListener(this);
				}
				
			}
			
			//Scherm om de logging te gaan maken.
			
			{
				logging = new JPanel();
				GridBagLayout jPanel3Layout = new GridBagLayout();
				getContentPane().add(logging, new GridBagConstraints(1, 2, 2, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jPanel3Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
				jPanel3Layout.rowHeights = new int[] {7, 7, 7, 7};
				jPanel3Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
				jPanel3Layout.columnWidths = new int[] {7, 7, 7, 7};
				logging.setLayout(jPanel3Layout);
				logging.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				
				outputLines = new JLabel();
				logging.add(outputLines, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				
			}
			pack();
			setSize(1200, 900);
		} catch (Exception e) 
		{
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
				command.ExecuteCommand(inputText);
			} else {
				outputLines.setText("De command is ongeldig");
			}

		}
		
	}

}
