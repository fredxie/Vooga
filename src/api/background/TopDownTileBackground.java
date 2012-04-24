package api.background;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.background.TileBackground;

@SuppressWarnings("serial")
public class TopDownTileBackground extends TileBackground {

	public TopDownTileBackground(BufferedImage[] tileImages, int horiz, int vert) {
		super(tileImages, horiz, vert);
	}

	public TopDownTileBackground(BufferedImage[] images, int[][] tiles) {
		super(images, tiles);
	}

}
