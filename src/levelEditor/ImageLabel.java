package levelEditor;

/**
 * @author Jiawei Shi
 */

import java.awt.Color;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

public class ImageLabel extends JLabel implements MouseInputListener {

	private static int WIDTH = 60;
	private static int HEIGTHT = 80;
	private static int Default_X = 200;
	private static int Default_Y = 50;

	private BufferedImage myImage;
	private LevelEditor levelEditor;

	private boolean inRightPanel;
	private boolean firstLeftClick;
	private boolean isStored;
	private int X_pos, Y_pos;

	public ImageLabel(BufferedImage image, LevelEditor ld) {
		super();
		levelEditor = ld;
		myImage = image;
		setBackgroundImage();
		this.setSize(WIDTH, HEIGTHT);
		inRightPanel = true;
		firstLeftClick = false;
		isStored = false;
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	private void setBackgroundImage() {
		ImageIcon Icon = new ImageIcon(myImage);
		setIcon(Icon);
		setSize(WIDTH, HEIGHT);
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
	public void mousePressed(final MouseEvent arg0) {
		// TODO Auto-generated method stub

		if (SwingUtilities.isRightMouseButton(arg0)) {

			JPopupMenu menu = new JPopupMenu("Menu");

			JMenuItem spec = new JMenuItem("Spec");
			menu.add(spec);
			spec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					System.out.println("spec");
				}
			});
			menu.addSeparator();

			JMenuItem copy = new JMenuItem("Copy");
			menu.add(copy);
			copy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					System.out.println("copy");
					levelEditor.setCachedLabel((ImageLabel) arg0.getComponent());
				}
			});
			menu.addSeparator();

			JMenuItem delete = new JMenuItem("Delete");
			menu.add(delete);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					levelEditor.deleteLabel((ImageLabel) arg0.getComponent());
				}
			});

			menu.addSeparator();

			if (inRightPanel) {
				JMenuItem create = new JMenuItem("Create");
				menu.add(create);
				create.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						System.out.println("create");
						putThisOnPlayField();
					}
				});
			}

			else {
				JMenuItem storeItem = new JMenuItem("Store Item");
				this.isStored = true;
				menu.add(storeItem);
				storeItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						System.out.println("store");
					}
				});

			}

			menu.show(arg0.getComponent(), arg0.getX() + 15, arg0.getY() + 20);
		}

		else if (SwingUtilities.isLeftMouseButton(arg0) && !firstLeftClick) {
			firstLeftClick = true;
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (isStored)
			return;

		this.setLocation(X_pos, Y_pos);
		X_pos = arg0.getX();
		Y_pos = arg0.getY();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void moveToLeftPanel() {
		inRightPanel = false;
	}

	public boolean inRightPanel() {
		return inRightPanel;
	}

	public BufferedImage getImage() {
		return myImage;
	}

	public void setDefaultPosition() {
		this.setLocation(Default_X, Default_Y);
		X_pos = Default_X;
		Y_pos = Default_Y;
		moveToLeftPanel();
	}

	private void putThisOnPlayField() {
		ImageLabel anotherElement = new ImageLabel(myImage, levelEditor);
		levelEditor.putLabelOnPlayField(anotherElement);
	}

}