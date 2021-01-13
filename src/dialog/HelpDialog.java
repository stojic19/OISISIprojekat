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
		ImageIcon helpIcon = new ImageIcon("slike" + File.separator + "help_menu.png");
		setIconImage(helpIcon.getImage());
		
		JTextArea JTA = new JTextArea("Prečice:\nNew - CTRL + N\nClose - CTRL + C\n"
				+ "Edit - CTRL + E\nDelete - CTRL + D\nHelp - CTRL + H\nAbout - CTRL + A\n"
				+ "U centralnom delu glavnog prozora korisnik može da izvrši pregled podataka o studentima,"
				+ " profesorima i predmetima.\n\n"
				+ "Dodavanje novog entiteta:\n"
				+ " Pritiskom na stavku menija New, ikonicu na toolbar-u ili korišćenjem"
				+ " odgovarajuće prečice, korisnik pokreće dijalog za dodavanje određenog entiteta, u skladu sa trenutno otvorenim tabom.\n"
				+ " Npr. Ukoliko korisnik želi da doda novog studenta, na glavnom prozoru treba da prikaže tab na kom se nalazi tabela studenata."
				+ " Nakon toga dijalog za dodavanje studenta pokreće na gore opisan način. Ekvivalentan proces se odvija za "
				+ "dodavanje profesora, odnosno predmeta.\n\n"
				+ "Izmena postojećeg entiteta:\n"
				+ "Pritiskom na stavku menija Edit, ikonicu na toolbar-u ili korišćenjem odgovarajuće prečice, korisnik pokreće dijalog za izmenu izabranog"
				+ " elementa tabele. U zavisnoti na trenutno otvoren tab i obeležen red u tabeli, otvara se dijalog za izmenu informacija o studentu, profesoru ili predmetu.\n"
				+ "\nU dijalogu za izmenu studenta omogućena je izmena informacija o samom studentu u tabu Informacije, a u tabovima Položeni i Nepoloženi moguće je izvršiti uvid u predmete koje je student položio i koje trenutno sluša.\n"
				+ "U tabu Položeni moguće je poništiti ocenu.\nPostupak za poništavanje ocene:\n"
				+ "U tabeli ocena korisnik bira red u kom se nalazi ocena koju želi da poništi, zatim pritiskom na dugme Poništi ocenu i potvrdnim odgovorom u iskačućem dijalogu ocena će biti poništena. Predmet se nakon toga može "
				+ "pronaći u tabu Nepoloženi.\nU tabu Nepoloženi moguće je ukloniti predmet iz liste, dodati novi ili položiti predmet.\n"
				+ "Sve tri akcije moguće je izvršiti odabirom predmeta iz tabele, a zatim pritiskom određenog dugmeta. Za dodavanje novog predmeta - dugme Dodaj, za uklanjanje - dugme Ukloni, a za polaganje predmeta - dugme Polaganje.\n"
				+ "U slučaju dodavanja odabrani predmet će sada biti prikazan u tabeli nepoloženih predmeta.\n"
				+ "U slučaju uklanjanja odabrani predmet više neće biti dostupan u tabeli nepoloženih predmeta.\n"
				+ "U slučaju polaganja odarani predmet će biti premeštan iz tabele nepoloženih predmeta u tabelu položenih, koja se nalazi u tabu Položeni.\n"
				+ "\nU dijalogu za izmenu profesora moguće je izmeniti informacije o samom profesoru u tabu Informacije, kao i izvršiti uvid u predmete koje profesor predaje u tabu Predmeti.\n"
				+ "U tabu Predmeti omogućeno je uklanjanje i dodavanje predmeta koje profesor predaje.\n"
				+ "Postupak za dodavanje predmeta profesoru:\n"
				+ "Pritiskom na dugme Dodaj predmet otvara se dijalog sa listom predmeta na koje je moguće dodati profesora. Odabrani predmet iz liste će se nakon dodavanja prikazati u tabeli predmeta koje profesor predaje.\n"
				+ "Postupak za uklanjanje predmeta sa profesora:\n"
				+ "Odabirom reda u tabeli predmeta koje profesor predaje i pritiskom na dugme Ukloni predmet korisnik će ukloniti predmet iz tabele predmeta koje profesor predaje i on više neće biti prikazan u tabeli.\n"
				+ "\nU dijalogu za izmenu predmeta moguće je izmeniti informacije o samom predmetu, ali i dodati/ukloniti profesora na/sa predmeta.\n"
				+ "Ukoliko na odabranom predmetu već postoji profesor nije moguće dodati novog. Pritiskom na dugme - profesor će biti uklonjen sa predmeta. Nakon toga će biti moguće ponovno dodavanje profesora.\n"
				+ "Ukoliko na odabranom predmetu ne postoji profesor pritiskom na dugme + korisniku će biti prikazana lista profesora koje je moguće dodati na predmet. Odabrani profesor će nakon dodavanja biti prikazan u informacijama o predmetu"
				+ " i neće biti moguće dodati novog pre uklanjanja postojećeg.\n\n"
				+ "Uklanjanje postojećeg entiteta:\n"
				+ "Odabirom određenog reda u tabeli i pritiskom na stavku menija Delete, ikonicu na toolbar-u ili korišćenjem odgovarajuće prečice korisnik može da ukloni odabrani entitet.\n"
				+ "Npr. Brisanje studenta se može izvršiti pozicioniranjem na tab Studenti, odabirom odgovarajućeg reda u tabeli i pokretanjem akcije brisanja na iznad opisan način."
				+ "Nakon toga obrisani student više neće biti vidljiv u tabeli.\n"
				+ "Ekvivalentan postupak se primenjuje za brisanje profesora i predmeta.\n\n"
				+ "Pretraga entiteta:\n"
				+ "U zavisnosti od odabranog taba, unosom teksta u polje za pretragu na toolbar-u i pritiskom na ikonicu lupe moguće je izvršiti pretragu podataka unutar sistema.\n"
				+ "Početno stanje tabele se dobija brisanjem sadržaja iz polja za pretragu i pritiskom ikonice lupe.\n"
				+ "Pretraga studenata:\n"
				+ "Može se sastojati od jedne, dve ili tri reči.\n"
				+ "Prva reč je obavezna i odnosi se na deo prezimena studenta."
				+ " Druga, odnosno treća reč su opcione i odnose se na deo imena, odnosno broja indeksa studenta.\n"
				+ "Pretraga profesora:\n"
				+ "Prva reč je obavezna i odnosi se na deo prezimena profesora."
				+ " Druga reč je opciona i odnosi se na deo imena profesora.\n"
				+ "Pretraga predmeta:\n"
				+ "Unosom jedne obavezne reči koja se odnosi na deo naziva predmeta.\n"
				+ "\nSortiranje podataka u tabeli:\n"
				+ "Sortiranje podataka je omogućeno u svakoj tabeli pritiskom na polje u kom se nalazi naziv kolone tabele.\n"
				+ "U zavisnosti od broja pritisaka podatke je moguće sortirati rastuće/opadajuće.",20,20);
		
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
