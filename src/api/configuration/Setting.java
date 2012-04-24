package api.configuration;

/**
 * @author Ran Zhang
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import api.util.JsonUtil;


@SuppressWarnings("serial")
public abstract class Setting extends JFrame {

	private JPanel keyPanel;
	private JPanel paraPanel;
	public ArrayList<String> keySettingList = new ArrayList<String>();
	public ArrayList<String> paraSettingList = new ArrayList<String>();

	public Setting() {

		super("Setting");
		setList();
		keyPanel = new JPanel();
		keyPanel = (JPanel) keySetting();
		paraPanel = (JPanel) parameterSetting();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(keyPanel, BorderLayout.NORTH);
		add(paraPanel, BorderLayout.SOUTH);
		pack();
		setVisible(true);

	}

	public abstract void setList();

	private JComponent keySetting() {
		JPanel panel = new JPanel();
		for (int i = 0; i < keySettingList.size(); i++) {
			JLabel label = new JLabel(keySettingList.get(i).toString());
			JTextField textField = new JTextField(10);
			textField.setEnabled(true);
			textField.addKeyListener(new KeySettingListener(keySettingList
					.get(i)));
			panel.add(label);
			panel.add(textField);
		}
		setVisible(true);
		return panel;
	}

	private JComponent parameterSetting() {
		JPanel panel = new JPanel();
		for (int i = 0; i < paraSettingList.size(); i++) {
			JLabel label = new JLabel(paraSettingList.get(i).toString());
			JTextField textField = new JTextField(10);
			textField.setEnabled(true);
			textField.addActionListener(new ParameterListener(paraSettingList
					.get(i), textField));
			panel.add(label);
			panel.add(textField);
		}
		setVisible(true);
		return panel;
	}

	public class ParameterListener implements ActionListener {

		private String parameter;
		private JTextField textField;

		public ParameterListener(String para, JTextField field) {
			parameter = para;
			textField = field;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.print(textField.getText());
			HashMap<String, Integer> map = JsonUtil.parse("json/paraConfig.json");
			map.put(parameter, Integer.parseInt(textField.getText()));
			JsonUtil.output(map, "json/paraConfig.json");
		}

	}

	public class KeySettingListener extends JFrame implements KeyListener {
		String action;

		public KeySettingListener(String action) {
			this.action = action;
		}

		@Override
		public void keyPressed(KeyEvent arg0) {

			HashMap<String, Integer> keyMap = JsonUtil.parse("json/keyConfig.json");
			keyMap.put(action, arg0.getKeyCode());
			JsonUtil.output(keyMap, "json/keyConfig.json");
			KeyChangedSubject.getInstance().notifyObservers();
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

}
