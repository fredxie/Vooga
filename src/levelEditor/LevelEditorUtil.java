package levelEditor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class LevelEditorUtil {
	protected static final JFileChooser ImageChooser = new JFileChooser(
			"./images/");
	protected static final JFileChooser JsonChooser = new JFileChooser("./");
	
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
	

	public static File getSelectedImageFile(){
		int retval = ImageChooser.showOpenDialog(null);
		if (retval != JFileChooser.APPROVE_OPTION) {
			return null;
		}
		File myFile = ImageChooser.getSelectedFile();
		return myFile;
	}
	
	public static File getJsonFile(){
		int retval = JsonChooser.showOpenDialog(null);
		if (retval != JFileChooser.APPROVE_OPTION) {
			return null;
		}
		File myFile = JsonChooser.getSelectedFile();
		return myFile;
	}
	
	public static int castObjectToInteger(Object o){
		double aa = (Double) o;
		return (int)aa;
	}

}
