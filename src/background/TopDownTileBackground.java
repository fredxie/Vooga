package background;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.background.TileBackground;

public class TopDownTileBackground extends TileBackground{

	public TopDownTileBackground(BufferedImage[] tileImages, int horiz, int vert) {
		super(tileImages, horiz, vert);
		// TODO Auto-generated constructor stub
	}

	public TopDownTileBackground(BufferedImage[] images, int[][] tiles) {
		super(images, tiles);
	}

}
