package levelEditor;
/**
 * @author Ran Zhang
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;

import keyconfiguration.KeyConfig;

public class Temp extends JFrame implements KeyListener {
	String action;
	public Temp(String action) {
		this.action = action;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		KeyConfig.keyMap.put(action, arg0.getKeyCode());
		try {
			KeyConfig.outputJsonFile("keyConfig.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}


}