package levelEditor;

/**
 * @author Jiawei SHI
 */

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import demo.DemoEnemy;

import menu.GameSL;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import element.Element;
import element.RegularEnemy;
import demo.DemoFighter;

public class LevelEditor extends JFrame implements ActionListener {

	protected static final JFileChooser ImageChooser = new JFileChooser(
			"./images/");

	private JScrollPane panel1;
	private JScrollPane panel2;
	private ImagePanel panel_1;
	private JPanel panel_2;

	private JMenuBar menuBar;
	private ImageLabel cachedLabel;

	private ArrayList<ImageLabel> list;
	private HashMap<Integer, String> myMap;

	public LevelEditor() {
		super("Level Editor");
		list = new ArrayList<ImageLabel>();
		cachedLabel = null;
		myMap = new HashMap<Integer, String>();

		panel_1 = new ImagePanel(loadDefalutBackground());
		panel_1.setLayout(null);
		panel1 = new JScrollPane(panel_1,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel1.setBounds(0, 0, 500, 600);

		panel_2 = new JPanel();
		// panel_2.setLayout(null);
		panel_2.setLayout(new GridLayout(4, 4));
		panel_2.setBackground(Color.WHITE);
		panel2 = new JScrollPane(panel_2,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel2.setBounds(500, 0, 300, 600);

		setLayout(null);

		// int gap = 10;
		// panel_2.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap,
		// gap));

		setMenu();
		setJMenuBar(menuBar);

		add(panel1);
		add(panel2);

		pack();

		setSize(810, 635);
		setVisible(true);

	}

	private void setMenu() {
		menuBar = new JMenuBar();
		JMenu menu[] = { new JMenu("File"), new JMenu("Action") };
		for (JMenu m : menu) {
			menuBar.add(m);
		}

		JMenuItem loadLevel = new JMenuItem("Load Level");
		loadLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

			}
		});
		menu[0].add(loadLevel);

		JMenuItem saveLevel = new JMenuItem("Save Level");
		saveLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

			}
		});
		menu[0].add(saveLevel);

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
		menu[0].add(exit);

		JMenuItem loadElement = new JMenuItem("Load Image");
		loadElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				loadNewElement();
			}
		});
		menu[1].add(loadElement);

		JMenuItem loadBackground = new JMenuItem("Load Background");
		loadBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				loadBackground();
			}
		});
		menu[1].add(loadBackground);

		JMenuItem pasteElement = new JMenuItem("Paste Item");
		pasteElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				pasteElement();
			}
		});
		menu[1].add(pasteElement);
	}

	private void loadBackground() {
		panel_1.setImage(getSelectedImage());
		panel_1.revalidate();
		panel_1.repaint();
	}

	private void loadNewElement() {
		ImageLabel element = new ImageLabel(getSelectedImage(), this);
		panel_2.add(element);
		panel_2.revalidate();
		panel_2.repaint();
	}

	private void pasteElement() {
		ImageLabel element = new ImageLabel(cachedLabel.getImage(), this);
		putLabelOnPlayField(element);
	}

	private BufferedImage getSelectedImage() {
		int retval = ImageChooser.showOpenDialog(null);
		if (retval != JFileChooser.APPROVE_OPTION) {
			return null;
		}
		File myFile = ImageChooser.getSelectedFile();
		BufferedImage image = convertToBufferedImage(myFile);
		return image;
	}

	public static void main(String[] args) {
		LevelEditor l = new LevelEditor();
	}

	private BufferedImage convertToBufferedImage(File myFile) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(myFile);
		} catch (IOException e) {
		}

		return img;
	}

	private Image loadDefalutBackground() {
		File myFile = new File("src/images/background1.jpg");
		BufferedImage image = convertToBufferedImage(myFile);
		return image;
	}

	public void deleteLabel(ImageLabel l) {
		l.setVisible(false);
		removeFromPanel(l);
		list.remove(l);
	}

	public void removeFromPanel(ImageLabel l) {
		if (l.inRightPanel()) {
			panel_2.remove(l);
			panel_2.revalidate();
		} else {
			panel_1.remove(l);
			panel_1.revalidate();
		}
	}

	public void putLabelOnPlayField(ImageLabel l) {
		removeFromPanel(l);
		panel_1.add(l);
		l.setDefaultPosition();
		list.add(l);
	}

	public void setCachedLabel(ImageLabel i) {
		cachedLabel = i;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
