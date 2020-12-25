package izgled;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

import javax.swing.JTabbedPane;


public class Tab extends JTabbedPane{

private static Tab instance=null;

    public static Tab getInstance() {
        if (instance == null) {
            instance = new Tab();
        }
        return instance;
    }

    private Tab() {

        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension dim=t.getScreenSize();
        int w=dim.width*3/4;
        int h=dim.height*3/4;

        JPanel stud=new JPanel();
        JPanel prof=new JPanel();
        JPanel pred=new JPanel();
        add("Studenti",stud);
        add("Profesori",prof);
        add("Predmeti",pred);

        // stud.setBackground(new Color(91, 102, 117));
        // prof.setBackground(new Color(91, 102, 117));
        // pred.setBackground(new Color(91, 102, 117));



    }
}