package levelEditor;

/**
 * @author Jiawei Shi
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BackgroundLengthDialog extends JFrame {

	private JPanel myPanel;
	private Container con;

	private JLabel label;
	private JTextField textField;

	private LevelEditor levelEditor;

	private static int HEIGHT = 200;
	private static int WIDTH = 300;

	public BackgroundLengthDialog(LevelEditor level) {
		super("Length of background");
		levelEditor = level;

		myPanel = new JPanel();
		setSize(WIDTH, HEIGHT);
		setLocation(300, 300);
		myPanel.setLayout(null);

		setLabel();
		setTextField();

		con = this.getContentPane();
		con.add(myPanel);
		myPanel.setOpaque(true);
		setVisible(true);
	}

	public void setLabel() {
		label = new JLabel("Input the length of playfield");
		label.setForeground(Color.RED);
		label.setBounds(10, 10, 200, 30);
		myPanel.add(label);
	}

	public void setTextField() {
		textField = new JTextField(10);
		textField.setBounds(10, 70, 100, 30);
		textField.setEnabled(true);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setPlayFieldLength();
			}
		});
		myPanel.add(textField);
	}

	public void setPlayFieldLength() {
		String text = textField.getText();
		dispose();
		File myFile = LevelEditorUtil.getSelectedImageFile();
		levelEditor.loadBackground(myFile, Integer.parseInt(text));

	}
}
