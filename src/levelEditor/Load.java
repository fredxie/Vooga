package levelEditor;

/**
 * @author Ran Zhang
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import api.util.LoadUtil;


@SuppressWarnings("serial")
public class Load extends JFrame {

	private JPanel myPanel;

	public static List<List<Object>> list;

	public Load() {

		super("Load Files");
		myPanel = new JPanel();
		myPanel = (JPanel) chooseFile();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(myPanel, BorderLayout.NORTH);
		pack();
		setVisible(true);
	}

	private JComponent chooseFile() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Please select a file:");

		final JButton select = new JButton("Browse");
		select.setEnabled(true);
		select.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser("./");
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fc.showOpenDialog(select);

				LoadUtil.loadJson(fc.getSelectedFile());
			}

		});

		panel.add(label);
		panel.add(select);
		setVisible(true);
		setPreferredSize(new Dimension(500, 100));
		return panel;
	}

}
