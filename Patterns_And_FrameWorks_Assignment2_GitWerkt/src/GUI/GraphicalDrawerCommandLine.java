package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraphicalDrawerCommandLine {

	// Jpanels
	private JPanel drawPanel, logging, commandLines;

	// TextAreas
	private TextArea commandView, loggingView;

	// Jtextfields
	private JTextField TextCommandLine;

	public GraphicalDrawerCommandLine(Container container, JButton ButtonExectureCommand, JTextField newInputLines,
			JPanel newDrawpanel) {
		try {
			container.setSize(new Dimension(1000, 800));
			container.setLayout(new GridBagLayout());
			GridBagConstraints gridcontainer = new GridBagConstraints();

			drawPanel = newDrawpanel;
			drawPanel.setBackground(Color.white);
			drawPanel.setPreferredSize(new Dimension(1000, 300));
			gridcontainer.fill = GridBagConstraints.HORIZONTAL;
			gridcontainer.gridwidth = GridBagConstraints.REMAINDER;
			gridcontainer.gridx = 0;
			gridcontainer.gridy = 0;
			container.add(drawPanel, gridcontainer);

			//linker scherm met wat er nu is aangemaakt	
			commandView = new TextArea();
			commandView.setSize(new Dimension(400, 400));
			commandView.setEditable(false);

			//zwarte scherm rechtsonder
			logging = new JPanel();
			JLabel jview = new JLabel("Output");
			logging.add(jview);
			loggingView = new TextArea();
			loggingView.setForeground(Color.WHITE);
			loggingView.setBackground(Color.black);
			logging.add(loggingView);

			gridcontainer.gridwidth = 1;
			gridcontainer.gridx = 0;
			gridcontainer.gridy = 1;
			container.add(commandView, gridcontainer);
			gridcontainer.gridx = 1;
			container.add(logging, gridcontainer);

			commandLines = new JPanel(new FlowLayout(0));
			JLabel linput = new JLabel("command");
			TextCommandLine = newInputLines;
			JButton ButtonExecute = ButtonExectureCommand;

			commandLines.add(linput);
			commandLines.add(TextCommandLine);
			commandLines.add(ButtonExecute);

			gridcontainer.weightx = 1;
			gridcontainer.gridx = 0;
			gridcontainer.gridy = 3;
			container.add(commandLines, gridcontainer);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public void setLog(String t) {
		loggingView.append(t);
	}

	public String getCommand() {
		return TextCommandLine.getText();
	}

	public void setData(String s) {
		commandView.setText(s);
	}

}
