package api.configuration;

/**
 * @author Ran Zhang
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JFrame;

import api.util.JsonUtil;


public class KeySettingListener extends JFrame implements KeyListener {
	String action;

	public KeySettingListener(String action) {
		this.action = action;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		HashMap<String, Integer> keyMap = JsonUtil.parse("keyConfig.json");
		keyMap.put(action, arg0.getKeyCode());
		JsonUtil.output(keyMap, "keyConfig.json");
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
