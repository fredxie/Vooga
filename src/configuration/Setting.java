package configuration;


/**
 * @author Ran Zhang
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

import util.JsonUtil;


public class Setting extends JFrame  {

	private JPanel mainPanel;
	private JLabel fire;
	private JLabel up;
	private JLabel down;
	private JLabel left;
	private JLabel right;
	private JLabel enemyNum;
	private JLabel blockNum;
	private JLabel bonusNum;
	private JLabel bombNum;
	private JLabel lifeNum;
	private JLabel gameSpeed;
	private JTextField fireText;
	private JTextField leftText;
	private JTextField rightText;
	private JTextField upText;
	private JTextField downText;
	private JTextField enemyNumText;
	private JTextField blockNumText;
	private JTextField bonusNumText;
	private JTextField bombNumText;
	private JTextField lifeNumText;
	private JTextField gameSpeedText;
	
	public Setting() {
		
		super("Setting");
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(keySetting(), BorderLayout.NORTH);
		mainPanel.add(parameterSetting(), BorderLayout.CENTER);
		mainPanel.add(levelSetting(), BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(mainPanel);
        pack();
        setVisible(true);

	}
	
	private JComponent keySetting() {
		JPanel panel = new JPanel();

		fire = new JLabel("FIRE");
		up = new JLabel("UP");
		down = new JLabel("DOWN");
		left = new JLabel("LEFT");
		right = new JLabel("RIGHT");

		fireText = new JTextField(10);
		fireText.setEnabled(true);
		fireText.addKeyListener(new KeySettingListener(GameParameters.FIRE));
		
		upText = new JTextField(10);
		upText.setEnabled(true);
		upText.addKeyListener(new KeySettingListener(GameParameters.UP));
		
		downText = new JTextField(10);
		downText.setEnabled(true);
		downText.addKeyListener(new KeySettingListener(GameParameters.DOWN));
		
		leftText = new JTextField(10);
		leftText.setEnabled(true);
		leftText.addKeyListener(new KeySettingListener(GameParameters.LEFT));
		
		rightText = new JTextField(10);
		rightText.setEnabled(true);
		rightText.addKeyListener(new KeySettingListener(GameParameters.RIGHT));
		
		panel.add(fire);
		panel.add(fireText);
		panel.add(up);
		panel.add(upText);
		panel.add(down);
		panel.add(downText);
		panel.add(left);
		panel.add(leftText);
		panel.add(right);
		panel.add(rightText);
		
		setVisible(true);
		return panel;
	}
	
	private JComponent parameterSetting() {
		JPanel panel = new JPanel();

		enemyNum = new JLabel("Enemy Number");
		blockNum = new JLabel("Block Number");
		bonusNum = new JLabel("Bonus Number");
		bombNum = new JLabel("Bomb Number");
		lifeNum = new JLabel("Fighter Life Number");

		enemyNumText = new JTextField(10);
		enemyNumText.setEnabled(true);
		enemyNumText.addActionListener(new ParameterListener(GameParameters.ENEMY_NUM, enemyNumText));
		
		blockNumText = new JTextField(10);
		blockNumText.setEnabled(true);
		blockNumText.addActionListener(new ParameterListener(GameParameters.BLOCK_NUM, blockNumText));
		
		bonusNumText = new JTextField(10);
		bonusNumText.setEnabled(true);
		bonusNumText.addActionListener(new ParameterListener(GameParameters.BONUS_NUM, bonusNumText));
		
		bombNumText = new JTextField(10);
		bombNumText.setEnabled(true);
		bombNumText.addActionListener(new ParameterListener(GameParameters.BOMB_NUM, bombNumText));
		
		lifeNumText = new JTextField(10);
		lifeNumText.setEnabled(true);
		lifeNumText.addActionListener(new ParameterListener(GameParameters.lifeNum, lifeNumText));
		
		panel.add(enemyNum);
		panel.add(enemyNumText);
		panel.add(blockNum);
		panel.add(blockNumText);
		panel.add(bonusNum);
		panel.add(bonusNumText);
		panel.add(bombNum);
		panel.add(bombNumText);
		panel.add(lifeNum);
		panel.add(lifeNumText);
		
		setVisible(true);
		return panel;
	}
	
	private JComponent levelSetting() {
		JPanel panel = new JPanel();

		gameSpeed = new JLabel("Game Speed");

		gameSpeedText = new JTextField(10);
		gameSpeedText.setEnabled(true);
		gameSpeedText.addActionListener(new ParameterListener(GameParameters.BACKGROUND_SPEED, gameSpeedText));
		
		panel.add(gameSpeed);
		panel.add(gameSpeedText);
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
			HashMap<GameParameters, Integer> map = JsonUtil.parse("paraConfig.json");
			map.put(parameter, Integer.parseInt(textField.getText()));
			JsonUtil.output(map, "paraConfig.json");
		}

	}

}
