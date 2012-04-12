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

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LevelEditor extends JFrame implements KeyListener,MouseListener {

	protected static final JFileChooser ImageChooser = new JFileChooser(
			"./images/");

	private JScrollPane panel1;
	private JScrollPane panel2;
	private ImagePanel panel_1;
	private JPanel panel_2;

	private JMenuBar menuBar;
	private ImageLabel cachedLabel;
	private int width, height;

	private ArrayList<ImageLabel> list;
	private HashMap<Integer, String> myMap;

	public LevelEditor() {
		super("Level Editor");
		list = new ArrayList<ImageLabel>();
		cachedLabel = null;
		width = 500;
		height = 600;

		myMap = new HashMap<Integer, String>();
		addKeyListener(this);
		

		 panel_1 = new ImagePanel(loadDefalutBackground());
		//panel_1 = new ImagePanel();
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
		BufferedImage image = getSelectedImage();
		panel_1.setImage(image);
		height = image.getHeight();
		width = image.getWidth();
		panel_1.revalidate();
		panel_1.repaint();
	}
	
	private Image loadDefalutBackground() {
		File myFile = new File("src/images/background1.jpg");
		BufferedImage image = convertToBufferedImage(myFile);
		return image;
	}


	private void loadNewElement() {
		ImageLabel element = new ImageLabel(getSelectedImage(), this);
		// currentLabel = element;
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


	public void deleteLabel(ImageLabel l) {
		l.setVisible(false);
		removeFromPanel(l);
	}

	public void removeFromPanel(ImageLabel l) {
		if (l.inRightPanel()) {
			panel_2.remove(l);
			panel_2.revalidate();
			System.out.println(list.size());
		} else {
			panel_1.remove(l);
			list.remove(l);
			panel_1.revalidate();
			System.out.println(list.size());
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

	
	public int getBackgroundHeight() {
		return height;
	}

	public int getBackgroundWidth() {
		return width;
	}
	
	public void addToList(ImageLabel i){
		list.add(i);
		System.out.println(list.size());
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
		if(cachedLabel != null){
			cachedLabel.setLocation(arg0.getX()-ImageLabel.WIDTH/2, arg0.getY()-ImageLabel.HEIGTHT/2);
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
	
	public void output(){
		for(int i=0; i<list.size(); i++){
			System.out.println("item "+ i+" "+list.get(i).getX()+" "+list.get(i).getY());
		}
		System.out.println(" ");
	}
}
