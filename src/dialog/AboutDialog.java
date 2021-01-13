package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class AboutDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AboutDialog(Frame parent, String title) {
		super(parent, title, false);
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
		setSize(700, screenHeight/2);
		setLocationRelativeTo(null);
		ImageIcon helpIcon = new ImageIcon("slike"+ File.separator + "about_menu.png");
		setIconImage(helpIcon.getImage());
		
		JTextArea JTA = new JTextArea("Informacije o aplikaciji:\n"
				+ "Finalna verzija aplikacije.\n"
				+ "Aplikacija je namenjena da olakša rad studentske službe i da omogući dodavanje,izmenu i brisanje profesora, studenata, predmeta.\n Za svakog studenta moguć je prikaz ocena kao i nepoloženih predmeta. Svaku ocenu je moguće poništiti, nepoložene predmete je moguće položiti ili ukloniti,"
				+ " a u zavisnosti od godine studenta moguće je studentu dodati nove predmete na slušanje."
				+ "\nZa svakog profesora je moguće prikazati listu predmeta koje predaje, kao i dodavanje novih predmeta u pomenutu listu."
				+ "\nZa svaki predmet je moguće dodati/ukloniti profesora koji će biti zadužen za taj predmet."
				+ "Podatke iz tabela je moguće pretraživati i sortirati po kriterijumima koji su prikazani u kolonama svake tabele.\n"
				+ "Sažete biografije studenata:\n"
				+ "Magdalena Rejin rođena je u Novom Sadu 1999. godine. Završila je Gimnaziju \"Laza Kostić\". Trenutno studira na Fakultetu tehničkih nauka, smer Računarstvo i automatika.\n"
				+ " Aleksa Stojić rođen je u Novom Sadu 1999. godine. Završio je Gimnaziju \"Jovan Jovanović Zmaj\". Trenutno studira na Fakultetu tehničkih nauka, smer Računarstvo i automatika.",20,20);
		JTA.setLineWrap(true);
		JTA.setWrapStyleWord(true);
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
