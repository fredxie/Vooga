package levelEditor;

/**
 * @author Ran Zhang
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class Setting extends JFrame implements KeyListener {

	protected static final JFileChooser ImageChooser = new JFileChooser(
			"./images/");

	private JPanel panel1;
	private JLabel fire;
	private JLabel up;
	private JLabel down;
	private JLabel left;
	private JLabel right;
	private JTextField fireText;
	private JTextField leftText;
	private JTextField rightText;
	private JTextField upText;
	private JTextField downText;

	public Setting() {
		super("Setting");
		panel1 = new JPanel();
		panel1.setBounds(0, 0, 500, 600);
		panel1.setLayout(null);
		add(panel1);

		pack();

		fire = new JLabel("FIRE");
		left = new JLabel("LEFT");
		right = new JLabel("RIGHT");
		up = new JLabel("UP");
		down = new JLabel("DOWN");
		fire.setBounds(100, 20, 100, 20);
		left.setBounds(100, 50, 100, 20);
		right.setBounds(100, 80, 100, 20);
		up.setBounds(100, 110, 100, 20);
		down.setBounds(100, 140, 100, 20);

		fireText = new JTextField(10);
		fireText.setEnabled(true);
		fireText.setBounds(300, 20, 100, 20);
		fireText.addKeyListener(new Temp("attack"));
		
		leftText = new JTextField(10);
		leftText.setEnabled(true);
		leftText.setBounds(300, 50, 100, 20);
		leftText.addKeyListener(new Temp("left"));
		
		rightText = new JTextField(10);
		rightText.setEnabled(true);
		rightText.setBounds(300, 80, 100, 20);
		rightText.addKeyListener(new Temp("right"));
		
		upText = new JTextField(10);
		upText.setEnabled(true);
		upText.setBounds(300, 110, 100, 20);
		upText.addKeyListener(new Temp("up"));
		
		downText = new JTextField(10);
		downText.setEnabled(true);
		downText.setBounds(300, 140, 100, 20);
		downText.addKeyListener(new Temp("down"));

		panel1.add(fire);
		panel1.add(up);
		panel1.add(down);
		panel1.add(right);
		panel1.add(left);

		panel1.add(fireText);
		panel1.add(leftText);
		panel1.add(rightText);
		panel1.add(upText);
		panel1.add(downText);
		addKeyListener(this);
		setSize(810, 635);
		setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {


	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

//	public static void main(String[] args) {
//		Setting s = new Setting();
//	}
}
