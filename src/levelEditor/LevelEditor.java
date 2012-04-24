package levelEditor;

/**
 * @author Jiawei Shi
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

import api.util.LoadUtil;


import java.io.File;
import java.util.*;

public class LevelEditor extends JFrame implements KeyListener, MouseListener {

	protected static final JFileChooser ImageChooser = new JFileChooser(
			"./images/");
	protected static final JFileChooser JsonChooser = new JFileChooser("./");

	private JScrollPane panel1;
	private JScrollPane panel2;
	private ImagePanel panel_1;
	private JPanel panel_2;

	private JMenuBar menuBar;
	private ImageLabel cachedLabel;
	private int playFieldLength = 600;
	private static int width = 500;
	private static int height = 600;;

	private ArrayList<ImageLabel> list;
	private String background_Path;

	public LevelEditor() {
		super("Level Editor");
		list = new ArrayList<ImageLabel>();
		cachedLabel = null;

		addKeyListener(this);

		panel_1 = new ImagePanel(loadDefalutBackground());
		panel_1.setLayout(null);
		panel_1.addMouseListener(this);
		panel1 = new JScrollPane(panel_1,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel1.setBounds(0, 0, 500, 600);

		panel_2 = new JPanel();
		panel_2.setLayout(new GridLayout(4, 4));
		panel_2.setBackground(Color.WHITE);
		panel2 = new JScrollPane(panel_2,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel2.setBounds(500, 0, 300, 600);

		setLayout(null);

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
				loadSavedFile();
			}
		});
		menu[0].add(loadLevel);

		JMenuItem saveLevel = new JMenuItem("Save Level");
		saveLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				storeToList();
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
				setNewBackground();
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

	public void loadBackground(File myFile, int length) {
		playFieldLength = length;
		background_Path = LevelEditorUtil.getSelectedPath(myFile);
		BufferedImage image = LevelEditorUtil.getSelectedImage(myFile);
		panel_1.setImage(image, length);
		panel_1.revalidate();
		panel_1.repaint();
	}

	private void setNewBackground() {
		BackgroundLengthDialog bd = new BackgroundLengthDialog(this);
	}

	private Image loadDefalutBackground() {
		File myFile = new File("images/background/background1.jpg");
		background_Path = LevelEditorUtil.getSelectedPath(myFile);
		BufferedImage image = LevelEditorUtil.convertToBufferedImage(myFile);
		return image;
	}

	private void loadNewElement() {
		File myFile = LevelEditorUtil.getSelectedImageFile();
		ImageLabel element = new ImageLabel(
				LevelEditorUtil.getSelectedImage(myFile), this);
		element.setImagePath(LevelEditorUtil.getSelectedPath(myFile));
		panel_2.add(element);
		panel_2.revalidate();
		panel_2.repaint();
	}

	private void pasteElement() {
		ImageLabel element = new ImageLabel(cachedLabel.getImage(), this);
		putLabelOnPlayField(element);
	}

	public void deleteLabel(ImageLabel l) {
		l.setVisible(false);
		removeFromPanel(l);
	}

	public void removeFromPanel(ImageLabel l) {
		if (l.inRightPanel()) {
			panel_2.remove(l);
			panel_2.revalidate();
		} else {
			panel_1.remove(l);
			list.remove(l);
			panel_1.revalidate();
		}
	}

	public void putLabelOnPlayField(ImageLabel l) {
		removeFromPanel(l);
		panel_1.add(l);
		l.setDefaultPosition();
	}

	public void setCachedLabel(ImageLabel i) {
		cachedLabel = i;
	}

	public int getBackgroundHeight() {
		return height;
	}

	public int getBackgroundWidth() {
		return width;
	}

	public void addToList(ImageLabel i) {
		list.add(i);
	}

	public void keyPressed(KeyEvent arg0) {

	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void mouseClicked(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent arg0) {
		if (cachedLabel != null) {
			cachedLabel.setLocation(arg0.getX() - ImageLabel.WIDTH / 2,
					arg0.getY() - ImageLabel.HEIGTHT / 2);
			panel_1.add(cachedLabel);
			panel_1.repaint();
			panel_1.revalidate();
		}

	}

	public void mouseReleased(MouseEvent arg0) {

	}

	public void storeToList() {
		List<List<Object>> store = new ArrayList<List<Object>>();
		List<Object> storeBackground = new ArrayList<Object>();
		storeBackground.add(background_Path);
		storeBackground.add(playFieldLength);
		store.add(storeBackground);

		for (ImageLabel label : list) {
			if (label.getX() != 0 || label.getY() != 0)
				store.add(label.toList());
		}
		FileNameDialog fn = new FileNameDialog(store);
		/*
		 * for(List<Object> a: store){ System.out.println(a.toString()); }
		 */

	}

	private void loadSavedFile() {
		File myFile = LevelEditorUtil.getJsonFile();
		List<List<Object>> list = LoadUtil.loadJson(myFile);

		File background = new File((String) list.get(0).get(0));
		playFieldLength = LevelEditorUtil.castObjectToInteger(list.get(0)
				.get(1));
		loadBackground(background, playFieldLength);

		for (int i = 1; i < list.size(); i++) {
			loadElement(list.get(i));
		}

	}

	private void loadElement(List<Object> list) {
		File file = new File((String) list.get(0));
		BufferedImage image = LevelEditorUtil.convertToBufferedImage(file);
		ImageLabel label = new ImageLabel(image, this);
		label.setCategory((String) list.get(1));
		label.setHP(LevelEditorUtil.castObjectToInteger(list.get(2)));
		label.setLocation(LevelEditorUtil.castObjectToInteger(list.get(3)),
				LevelEditorUtil.castObjectToInteger(list.get(4)));
		list.add(label);

		panel_1.add(label);
		panel_1.revalidate();
		panel_1.repaint();
	}

	private class FileNameDialog extends JFrame {
		private JPanel myPanel;
		private Container con;
		private JLabel myLabel;
		private JTextField myTextField;
		private List<List<Object>> listToStore;

		private FileNameDialog(List<List<Object>> store) {
			super("File Name");
			listToStore = store;
			myPanel = new JPanel();
			setSize(200, 120);
			setLocation(300, 300);
			myPanel.setLayout(null);
			setTextField();

			con = this.getContentPane();
			con.add(myPanel);
			myPanel.setOpaque(true);
			setVisible(true);
		}

		private void setTextField() {
			myLabel = new JLabel("Input the File Name");
			myLabel.setBounds(10, 10, 200, 30);
			myLabel.setForeground(Color.RED);
			myPanel.add(myLabel);

			myTextField = new JTextField(20);
			myTextField.setBounds(10, 50, 100, 30);
			myTextField.setEnabled(true);
			myTextField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					getFileName();
				}
			});
			myPanel.add(myTextField);
		}

		private void getFileName() {
			String text = myTextField.getText();
			dispose();
			LoadUtil.saveJson(listToStore, text);
		}
	}

	/****************************** Main ******************************/

	public static void main(String[] args) {
		LevelEditor l = new LevelEditor();
	}
	/**************************************************************/

}
