package search;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import izgled.Tab;
import model.BazaPredmeta;
import model.Predmet;


public class PretragaPredmeta {
	private static PretragaPredmeta instance = null;

	public static PretragaPredmeta getInstance() throws ParseException {
		if (instance == null) {
			instance = new PretragaPredmeta();
		}
		return instance;
	}
	
	public List<Predmet> listapretraga;
	public List<Predmet> remove;
	
	public PretragaPredmeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PretragaPredmeta(String pretraga) throws ParseException  {

		listapretraga= new ArrayList<Predmet>(BazaPredmeta.getInstance().getPredmeti());
        remove =new ArrayList<Predmet>();
        String[] splits = pretraga.split(" ");
        
		 
		   for(Predmet p: listapretraga ) {
		       
			       for(int i=0;i<splits.length;i++) {
				   if(!p.getNaziv().toUpperCase().contains(splits[i].toUpperCase()))
					
					   remove.add(p);
			       }
			 
	
		       
		   }
		   
		   listapretraga.removeAll(remove);
			
			if(listapretraga.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Nema predmeta!", "Pretraga", JOptionPane.WARNING_MESSAGE,null);
				
			}else {
				BazaPredmeta.getInstance().setPredmeti(listapretraga);
				Tab.getInstance().azurirajPrikazPredmeta(null, -1);
			}
		   
		   }	
			
}
