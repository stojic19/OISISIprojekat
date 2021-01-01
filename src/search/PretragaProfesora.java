package search;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import izgled.Tab;
import model.BazaProfesora;
import model.Profesor;


public class PretragaProfesora {
	private static PretragaProfesora instance = null;

	public static PretragaProfesora getInstance() throws ParseException {
		if (instance == null) {
			instance = new PretragaProfesora();
		}
		return instance;
	}
	
	public List<Profesor> listapretraga;
	public List<Profesor> remove;
	
	public PretragaProfesora() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PretragaProfesora(String pretraga) throws ParseException  {

		listapretraga= new ArrayList<Profesor>(BazaProfesora.getInstance().getProfesori());
        remove =new ArrayList<Profesor>();
	
		String[] splits = pretraga.split(" ");
		   
		   for(Profesor p: listapretraga ) {
			   if(splits.length==1) {
			   if(!p.getPrz().toUpperCase().contains(splits[0].toUpperCase()))
				
				   remove.add(p);
			   
			   }else if(splits.length==2) {
				   if(!p.getPrz().toUpperCase().contains(splits[0].toUpperCase()))
						
					   remove.add(p);
				   else if(!p.getIme().toUpperCase().contains(splits[1].toUpperCase()))
				       remove.add(p);
	
			   }
		   }
		   
		   listapretraga.removeAll(remove);
			
			if(listapretraga.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Nema profesora!", "Pretraga", JOptionPane.WARNING_MESSAGE,null);
				
			}else {
				BazaProfesora.getInstance().setProfesori(listapretraga);
				Tab.getInstance().azurirajPrikazProfesora(null, -1);
			}
		   
		   }	
			
	
}
