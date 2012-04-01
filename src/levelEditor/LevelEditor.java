package levelEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import menu.GameSL;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;


import element.Element;
import element.RegularEnemy;
import element.RegularFighter;

public class LevelEditor extends JFrame implements ActionListener{
	
	protected static final JFileChooser ourChooser = new JFileChooser("./src/images");
	private JScrollPane panel1;
	//private JPanel panel1;
	//private JPanel panel;
	private JScrollPane panel2;
	
	//private JPanel panel_1;
	private JPanel panel_2;
	private ImagePanel panel_1;

	
	private JButton enemy;	
	private JButton player;	
	private JButton map;	
	private JButton weapon;	
	private JButton bonus;	
	private JButton block;
	private JButton save;
	private JButton exit;
	
	private ArrayList<Element> list;
	private HashMap<Integer,String> myMap;
	
	public LevelEditor(){
		super("Level Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		list = new ArrayList<Element>();
		myMap = new HashMap<Integer,String>();
		panel_1 = new ImagePanel(loadDefalutBackground());
		panel_1.setLayout(null);
		panel_2 = new JPanel();
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.PAGE_AXIS));
		//panel_2.setLayout(null);
		
		setLayout(null);
		panel1 = new JScrollPane(panel_1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panel2 = new JScrollPane(panel_2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		//panel1.getViewport().setBackground(Color.BLACK);
		//panel_1.setBackground();
		panel1.setBounds(0, 0, 500, 1000);
		
		//panel2.getViewport().setBackground(Color.WHITE);
		panel_2.setBackground(Color.WHITE);
		panel2.setBounds(500,0,300,1000);
		
		add(panel1);
		add(panel2);
		
		setButtons();
			
		setSize(800,600);
		setVisible(true);
	}
	
	private void setButtons(){
		enemy = new JButton("Enemies");	
		player = new JButton("Player");	
		map = new JButton("Background");	
		weapon = new JButton("Weapons");	
		bonus = new JButton("Power-Ups");	
		block = new JButton("Obstacles");	
		save = new JButton("Save");
		exit = new JButton("Exit");

		
		enemy.setAlignmentX(Component.CENTER_ALIGNMENT);
		player.setAlignmentX(Component.CENTER_ALIGNMENT);
		map.setAlignmentX(Component.CENTER_ALIGNMENT);
		weapon.setAlignmentX(Component.CENTER_ALIGNMENT);
		bonus.setAlignmentX(Component.CENTER_ALIGNMENT);
		block.setAlignmentX(Component.CENTER_ALIGNMENT);
		save.setAlignmentX(Component.CENTER_ALIGNMENT);
		exit.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		/*
		enemy.setBounds(520,20,100,100);
		player.setBounds(670, 20, 100, 100);
		map.setBounds(520, 170, 100, 100);
		weapon.setBounds(670,170,100,100);
		bonus.setBounds(520,320,100,100);
		block.setBounds(670,320,100,100);
		save.setBounds(520, 470, 100, 100);
		exit.setBounds(670, 470, 100, 100);
		*/
		
		enemy.addActionListener(this);
		player.addActionListener(this);
		map.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		
		panel_2.add(enemy);
		panel_2.add(player);
		panel_2.add(map);
		panel_2.add(weapon);
		panel_2.add(bonus);
		panel_2.add(block);
		panel_2.add(save);
		panel_2.add(exit);
		
	}
	
	public static void main(String[] args){
		LevelEditor l = new LevelEditor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		if(e.getSource() == enemy){
			int retval = ourChooser.showOpenDialog(null);
    		if (retval != JFileChooser.APPROVE_OPTION) {
    			return;
    		}
    		File myFile = ourChooser.getSelectedFile();
    
        	BufferedImage image = convertToBufferedImage(myFile);   	
        	RegularEnemy enemy = new RegularEnemy(image);
        	DragImage di = new DragImage(enemy,list,image);
        	
        	di.setDefalutLocation();
        	di.addToPanel(panel_1);
        	
        	di.setVisible(true);
        	panel_1.revalidate();
        	panel_1.repaint();
	}
		
		if(e.getSource() == player){
			int retval = ourChooser.showOpenDialog(null);
    		if (retval != JFileChooser.APPROVE_OPTION) {
    			return;
    		}
    		File myFile = ourChooser.getSelectedFile();
        	BufferedImage image = convertToBufferedImage(myFile);
        	RegularFighter fighter = new RegularFighter(image);
        	DragImage di = new DragImage(fighter,list,image);
        	di.setDefalutLocation();
        	di.addToPanel(panel_1);
        	
        	di.setVisible(true);
        	panel_1.revalidate();
        	panel_1.repaint();
		}
		
		if(e.getSource() == map){
			int retval = ourChooser.showOpenDialog(null);
    		if (retval != JFileChooser.APPROVE_OPTION) {
    			return;
    		}
    		File myFile = ourChooser.getSelectedFile();
    		String path = myFile.getAbsolutePath();
    		String miniPath = path.substring(path.lastIndexOf(File.separator));
           
    		BufferedImage image = convertToBufferedImage(myFile);
    		
    		myMap.put(0, miniPath);
    		
    		panel_1.setImage(image);
    		panel_1.revalidate();
        	panel_1.repaint();
    		
		}
		
		if(e.getSource() == save){
			GameSL gs = new GameSL();
			try{
			gs.saveLevel(list, myMap,"1");
			}
			catch(IOException a){
				
			}
		}
		
		if(e.getSource() == exit){
			dispose();
		}
	}
	
	private BufferedImage convertToBufferedImage(File myFile){
		BufferedImage img = null;
		try {
		    img = ImageIO.read(myFile);
		} catch (IOException e) {
		}
		return img;
	}
	
	private Image loadDefalutBackground(){
		File myFile = new File("src/images/background1.jpg");
		BufferedImage image = convertToBufferedImage(myFile);
		return image;
	}
}
