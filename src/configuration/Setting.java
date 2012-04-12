package configuration;

/**
 * @author Ran Zhang
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import util.JsonUtil;

public abstract class Setting extends JFrame {

	private JPanel keyPanel;
	private JPanel paraPanel;
	public ArrayList<GameParameters> keySettingList = new ArrayList<GameParameters>();
	public ArrayList<GameParameters> paraSettingList = new ArrayList<GameParameters>();

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

		private GameParameters parameter;
		private JTextField textField;

		public ParameterListener(GameParameters para, JTextField field) {
			parameter = para;
			textField = field;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.print(textField.getText());
			HashMap<GameParameters, Integer> map = JsonUtil
					.parse("paraConfig.json");
			map.put(parameter, Integer.parseInt(textField.getText()));
			JsonUtil.output(map, "paraConfig.json");
		}

	}

}
