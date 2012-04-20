package configuration;

/**
 * @author Ran Zhang
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JFrame;

import util.JsonUtil;


public class KeySettingListener extends JFrame implements KeyListener {
	GameParameters action;

	public KeySettingListener(GameParameters action) {
		this.action = action;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		HashMap<GameParameters, Integer> keyMap = JsonUtil.parse("keyConfig.json");
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
