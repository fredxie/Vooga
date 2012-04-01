package levelEditor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import element.RegularEnemy;

public class EnemyChooseDialog extends JFrame implements ActionListener {
	
    protected static final JFileChooser ourChooser = new JFileChooser("./src/images");
    private BufferedImage image;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private File myFile;
    
    public EnemyChooseDialog()
    {
    	super("Choose enemy");
    	JPanel panel = (JPanel) getContentPane();
        panel.setLayout(new BorderLayout());
        button1 = new JButton("Enemy1");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int retval = ourChooser.showOpenDialog(null);
        		if (retval != JFileChooser.APPROVE_OPTION) {
        			return;
        		}
        		myFile = ourChooser.getSelectedFile();
            	
            	image = convertToBufferedImage(myFile);   	
        }
          
    }); 
        
        
        button2 = new JButton("Create Enemy");
        button2.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
            	//RegularEnemy enemy = new RegularEnemy(image); 
        		//DragImage di = new DragImage(image,null);
        		//di.addToPanel(panel_2);
            	
        }
        });
        
        
        panel.add(button1, BorderLayout.NORTH);
    	panel1 = new JPanel();
    	
    	
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private BufferedImage convertToBufferedImage(File myFile){
		BufferedImage img = null;
		try {
		    img = ImageIO.read(myFile);
		} catch (IOException e) {
		}
		return img;
	}


}
