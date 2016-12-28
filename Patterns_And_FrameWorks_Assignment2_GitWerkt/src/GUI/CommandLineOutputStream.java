package GUI;

import java.io.IOException;
import java.io.OutputStream;

public class CommandLineOutputStream extends OutputStream{
	private GraphicalDrawerCommandLine frameGUI = null;

	
	public CommandLineOutputStream(GraphicalDrawerCommandLine commandGUI){
		this.frameGUI = commandGUI;
	}

	public void write(int waarde) throws IOException{
		frameGUI.setLog("" + (char)waarde);
	}

}
