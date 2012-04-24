package api.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.golden.gamedev.util.ImageUtil;
/**
 * Utility methods to read buffered image(s)
 * @author Ran Zhang
 */
public class TopDownImageUtil {
	public static BufferedImage[] getImages(String imagefile, int col, int row) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(imagefile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ImageUtil.splitImages(image, col, row);
	}

	public static BufferedImage getImage(String imagefile) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(imagefile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

}
