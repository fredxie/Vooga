package levelEditor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LevelEditorUtil {
	
	
	public static BufferedImage convertToBufferedImage(File myFile) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(myFile);
		} catch (IOException e) {
		}

		return img;
	}
	
	public static String getSelectedPath(File file){
		String absolutePath = file.getAbsolutePath();
		
		File baseFile = new File("./");
		String base = baseFile.getAbsolutePath().substring(0, baseFile.getAbsolutePath().length()-1);
		
		if (absolutePath.startsWith(base)) {
		    return absolutePath.substring(base.length());
		}

		return null;
	}
	
	public static BufferedImage getSelectedImage(File file) {
		BufferedImage image = LevelEditorUtil.convertToBufferedImage(file);
		return image;
	}

}
