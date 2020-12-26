	package izgled;

	import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

	import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import dialog.AboutDialog;
import dialog.HelpDialog;
import listeners.action.NewActionListener;;

	public class Meni extends JMenuBar {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Meni(final JFrame parent) {
			JMenu mFile = new JMenu("File");
			JMenu mEdit = new JMenu("Edit");
			JMenu mHelp = new JMenu("Help");
			
			JMenuItem miNew = new JMenuItem("New");
			JMenuItem miClose = new JMenuItem("Close");
			JMenuItem miEdit = new JMenuItem("Edit");
			JMenuItem miDelete = new JMenuItem("Delete");
			JMenuItem miHelp = new JMenuItem("Help");
			JMenuItem miAbout = new JMenuItem("About");
			
			miNew.setMnemonic(KeyEvent.VK_N);
			miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
			miClose.setMnemonic(KeyEvent.VK_C);
			miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
			miEdit.setMnemonic(KeyEvent.VK_E);
			miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
			miDelete.setMnemonic(KeyEvent.VK_D);
			miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
			miHelp.setMnemonic(KeyEvent.VK_H);
			miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
			miAbout.setMnemonic(KeyEvent.VK_A);
			miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
			
			mFile.setMnemonic(KeyEvent.VK_F);
			mEdit.setMnemonic(KeyEvent.VK_E);
			mHelp.setMnemonic(KeyEvent.VK_H);
			
			miNew.setIcon(new ImageIcon("slike/add_menu.jpg"));
			miClose.setIcon(new ImageIcon("slike/close_menu.png"));
			miEdit.setIcon(new ImageIcon("slike/edit_menu.png"));
			miDelete.setIcon(new ImageIcon("slike/delete_menu.png"));
			miHelp.setIcon(new ImageIcon("slike/help_menu.png"));
			miAbout.setIcon(new ImageIcon("slike/about_menu.png"));
			
			miNew.addActionListener(new NewActionListener(parent));
			
			miHelp.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					//JOptionPane.showMessageDialog(null, "");
					HelpDialog dialog = new HelpDialog(parent,"Help");
					dialog.setVisible(true);
				}
			});
			miAbout.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					//JOptionPane.showMessageDialog(null, "");
					AboutDialog dialog = new AboutDialog(parent,"About");
					dialog.setVisible(true);
				}
			});
			
			mFile.add(miNew);
			mFile.addSeparator();
			mFile.add(miClose);
			mEdit.add(miEdit);
			mEdit.addSeparator();
			mEdit.add(miDelete);
			mHelp.add(miHelp);
			mHelp.addSeparator();
			mHelp.add(miAbout);
			
			add(mFile);
			add(mEdit);
			add(mHelp);
			
			LineBorder lb = new LineBorder(Color.LIGHT_GRAY);
			setBorder(lb);
		}
		
	}
