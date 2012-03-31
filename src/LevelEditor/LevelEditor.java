package LevelEditor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.IOException;
public class LevelEditor extends JFrame implements ActionListener{
	
	private JScrollPane panel1;
	//private JPanel panel1;
	//private JPanel panel;
	private JScrollPane panel2;
	
	private JPanel panel_1;
	private JPanel panel_2;

	private JButton icon;
	
	public LevelEditor(){
		super("Level Editor");
		panel_1 = new JPanel();
		panel_2 = new JPanel();
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.PAGE_AXIS));
		
		setLayout(null);
		panel1 = new JScrollPane(panel_1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panel2 = new JScrollPane(panel_2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		//panel1.getViewport().setBackground(Color.BLACK);
		panel_1.setBackground(Color.BLACK);
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
		JButton enemy = new JButton("Enemies");	
		JButton player = new JButton("Player");	
		JButton map = new JButton("Background");	
		JButton weapon = new JButton("Weapons");	
		JButton bonus = new JButton("Power-Ups");	
		JButton block = new JButton("Obstacles");	
//		BufferedImage image = null;	
//		try 
//		{
//		image = ImageIO.read(icon.getClass().getResource("/enemy7.png"));  
//		Image Image = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
//		ImageIcon Icon = new ImageIcon(Image);
//		icon.setIcon(Icon);
//		icon.setText("Enemy");
//		} catch (IOException e) 
//		{
//		e.printStackTrace();
//		}
		enemy.setAlignmentX(Component.CENTER_ALIGNMENT);
		player.setAlignmentX(Component.CENTER_ALIGNMENT);
		map.setAlignmentX(Component.CENTER_ALIGNMENT);
		weapon.setAlignmentX(Component.CENTER_ALIGNMENT);
		bonus.setAlignmentX(Component.CENTER_ALIGNMENT);
		block.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(enemy);
		panel_2.add(player);
		panel_2.add(map);
		panel_2.add(weapon);
		panel_2.add(bonus);
		panel_2.add(block);
	}
	
	public static void main(String[] args){
		LevelEditor l = new LevelEditor();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub	
	}
}
