package levelEditor;

/**
 * @author Jiawei Shi
 */

import java.awt.Color;
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

import util.LoadUtil;

import java.io.File;
import java.util.*;

public class LevelEditor extends JFrame implements KeyListener, MouseListener {

	protected static final JFileChooser ImageChooser = new JFileChooser(
			"./images/");

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
		// panel_1 = new ImagePanel();
		panel_1.setLayout(null);
		panel_1.addMouseListener(this);
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

	public void loadBackground(int length) {
		playFieldLength = length;
		File myFile = getSelectedFile();
		background_Path = LevelEditorUtil.getSelectedPath(myFile);
		BufferedImage image = LevelEditorUtil.getSelectedImage(myFile);
		panel_1.setImage(image, length);
		//panel_1.setImage(image);
		//height = image.getHeight();
		//width = image.getWidth();
		panel_1.revalidate();
		panel_1.repaint();
	}
	
	private void setNewBackground(){
		BackgroundLengthDialog bd = new BackgroundLengthDialog(this);
	}

	private Image loadDefalutBackground() {
		File myFile = new File("src/images/background1.jpg");
		background_Path = LevelEditorUtil.getSelectedPath(myFile);
		BufferedImage image = LevelEditorUtil.convertToBufferedImage(myFile);
		//return image;
		//return LevelEditorUtil.combine(image);
		return image;
	}

	private void loadNewElement() {
		File myFile = getSelectedFile();
		ImageLabel element = new ImageLabel(LevelEditorUtil.getSelectedImage(myFile), this);
		element.setImagePath(LevelEditorUtil.getSelectedPath(myFile));
		panel_2.add(element);
		panel_2.revalidate();
		panel_2.repaint();
	}

	private void pasteElement() {
		ImageLabel element = new ImageLabel(cachedLabel.getImage(), this);
		putLabelOnPlayField(element);
	}
	
	private File getSelectedFile(){
		int retval = ImageChooser.showOpenDialog(null);
		if (retval != JFileChooser.APPROVE_OPTION) {
			return null;
		}
		File myFile = ImageChooser.getSelectedFile();
		return myFile;
	}
	

/******************************Main******************************/
	
	public static void main(String[] args) {
		LevelEditor l = new LevelEditor();
	}
/**************************************************************/

	

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
		//list.add(l);
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
		 //System.out.println(list.size());
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (cachedLabel != null) {
			cachedLabel.setLocation(arg0.getX() - ImageLabel.WIDTH / 2,
					arg0.getY() - ImageLabel.HEIGTHT / 2);
			panel_1.add(cachedLabel);
			//output();
			panel_1.repaint();
			panel_1.revalidate();
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Object>> storeToList(){
		List<List<Object>> store = new ArrayList<List<Object>>();
		List<Object> storeBackground = new ArrayList<Object>();
		storeBackground.add(background_Path);
		storeBackground.add(playFieldLength);
		store.add(storeBackground);
		
		for(ImageLabel label: list){
			if(label.getX()!=0 || label.getY()!=0)
				store.add(label.toList());
		}
		for(List<Object> a: store){
			System.out.println(a.toString());
		}
		LoadUtil.saveJson(store);
		return store;
	}
	

}
