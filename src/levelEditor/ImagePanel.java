package levelEditor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class ImagePanel extends JPanel {

	private Image img;
	private int height = 600;

	public ImagePanel() {

	}

	public ImagePanel(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), height);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void setImage(Image img) {

		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), height);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void setImage(Image img, int length) {
		height = length;
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), height);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		int len = img.getHeight(null);
		for (int i = 0; i * len <= height; i++) {
			g.drawImage(img, 0, i * len, null);
		}
	}

}
