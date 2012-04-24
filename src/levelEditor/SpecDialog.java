package levelEditor;

/**
 * @author Jiawei Shi
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SpecDialog extends JFrame {

	private JPanel myPanel;
	private Container con;

	private JLabel image;
	private JLabel XPos_Label;
	private JLabel XPos;
	private JLabel YPos_Label;
	private JLabel YPos;
	private JLabel category_Label;
	private JComboBox category;
	private JLabel HP_Label;
	private JComboBox HP;

	private ImageLabel myElement;

	private static int HEIGHT = 400;
	private static int WIDTH = 300;

	public SpecDialog(ImageLabel image) {
		super("Specification");
		myElement = image;

		myPanel = new JPanel();
		setSize(HEIGHT, WIDTH);
		setLocation(300, 300);
		myPanel.setLayout(null);

		setDisplayedImage();
		setPositionLabel();
		setCategory();
		setHPNumber();

		con = this.getContentPane();
		con.add(myPanel);
		myPanel.setOpaque(true);
		setVisible(true);

	}

	public void setDisplayedImage() {
		image = new JLabel();
		ImageIcon Icon = new ImageIcon(myElement.getImage());
		image.setIcon(Icon);
		image.setSize(60, 60);
		image.setLocation(10, 10);
		myPanel.add(image);
	}

	public void setPositionLabel() {
		XPos_Label = new JLabel("X Position");
		XPos_Label.setForeground(Color.RED);
		XPos_Label.setBounds(10, 80, 100, 20);
		myPanel.add(XPos_Label);

		XPos = new JLabel(myElement.getX() + "");
		XPos.setBounds(10, 110, 100, 20);
		myPanel.add(XPos);

		YPos_Label = new JLabel("Y Position");
		YPos_Label.setForeground(Color.RED);
		YPos_Label.setBounds(10, 140, 100, 20);
		myPanel.add(YPos_Label);

		YPos = new JLabel(myElement.getY() + "");
		YPos.setBounds(10, 170, 100, 20);
		myPanel.add(YPos);
	}

	public void setCategory() {
		category_Label = new JLabel("Category");
		category_Label.setForeground(Color.RED);
		category_Label.setBounds(150, 10, 100, 30);
		myPanel.add(category_Label);

		String[] Category = { "Fighter", "Enemy", "Block", "Bonus" };
		category = new JComboBox(Category);
		category.setBackground(Color.GRAY);
		category.setForeground(Color.RED);
		category.setBounds(150, 40, 150, 30);
		myPanel.add(category);

		category.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				String str = (String) category.getSelectedItem();
				myElement.setCategory(str);
			}
		});

	}

	public void setHPNumber() {
		HP_Label = new JLabel("HP");
		HP_Label.setForeground(Color.RED);
		HP_Label.setBounds(150, 70, 150, 30);
		myPanel.add(HP_Label);

		String[] healthPoint = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		HP = new JComboBox(healthPoint);
		HP.setBackground(Color.GRAY);
		HP.setForeground(Color.RED);
		HP.setBounds(150, 100, 150, 30);
		myPanel.add(HP);

		HP.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				String str = (String) HP.getSelectedItem();
				int health = Integer.parseInt(str);
				myElement.setHP(health);
			}
		});
	}

}
