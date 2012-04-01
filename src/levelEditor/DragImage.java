package levelEditor;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import element.Element;
import element.RegularEnemy;

public class DragImage extends JLabel implements MouseMotionListener, MouseListener {
	
	static int imageWidth = 60;
	static int imageHeight = 80;
	
	private int x_pos;
	private int y_pos;
	private Element myElement;
	
	private BufferedImage image;
	private ArrayList<Element> list;
	
	private boolean Store = true;
	
	
	public DragImage(Element element,ArrayList<Element> inputList,BufferedImage im){
		myElement = element;
		list = inputList;
		image = im;
		//this.setAutoscrolls(true);
		addMouseMotionListener(this);
		addMouseListener(this);
		ImageIcon Icon = new ImageIcon(image);
		this.setIcon(Icon);
		this.setSize(imageWidth,imageHeight);
		
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x_pos = arg0.getX();
		y_pos = arg0.getY();
		this.setLocation(250+arg0.getX(), 300+arg0.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
		
	}
	
	
	public void addToPanel(JPanel panel){
		panel.add(this);
	}
	
	public void setDefalutLocation(){
		this.setLocation(250, 300);
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
		// TODO Auto-generated method stub
		
	   }

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(Store){
		this.setLocation(250+arg0.getX(), 300+arg0.getY());
		myElement.setLocation(250+arg0.getX(), 300+arg0.getY());
		System.out.println((250+arg0.getX())+" "+ (300+arg0.getY()));
		list.add(myElement);
		Store = false;
		System.out.println(list.size());
		}
		
	}
	

}
