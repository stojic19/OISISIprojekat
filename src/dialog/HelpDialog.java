package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class HelpDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelpDialog(Frame parent, String title) {
		super(parent, title, false);
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
		setSize(700, screenHeight/2);
		setLocationRelativeTo(null);
		ImageIcon helpIcon = new ImageIcon("slike/help_menu.png");
		setIconImage(helpIcon.getImage());
		
		JTextArea JTA = new JTextArea("Precice:\nNew - CTRL + N\nClose - CTRL + C\n"
				+ "Edit - CTRL + E\nDelete - CTRL + D\nHelp - CTRL + H\nAbout - CTRL + A\n"
				+ "TO DO: Dodavanje opisa upotrebe same aplikacije.",20,20);
        JTA.setLineWrap(true);
		JTA.setEditable(false);
		JTA.setBackground(new Color(155,172,194));
		JTA.setSize(400, 350);
		
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel1.setBackground(new Color(155,172,194));
		panel1.add(JTA,BorderLayout.CENTER);
		
		JScrollPane JSP = new JScrollPane(panel1,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(JSP);
		
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton closeButton = new JButton("Zatvori");
		closeButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
				});
		panel2.add(closeButton);
		getContentPane().add(panel2,BorderLayout.SOUTH);
	}

}
