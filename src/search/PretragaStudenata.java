package search;

import izgled.Tab;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.BazaStudenata;
import model.Student;

public class PretragaStudenata {
	private static PretragaStudenata instance = null;

	public static PretragaStudenata getInstance() throws ParseException {
		if (instance == null) {
			instance = new PretragaStudenata();
		}
		return instance;
	}
	
	public List<Student> listapretraga;
	public List<Student> remove;
	
	public PretragaStudenata() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PretragaStudenata(String pretraga) throws ParseException  {
		
	//	BazaStudenata.getInstance().osveziPrikaz();
		listapretraga= new ArrayList<Student>(BazaStudenata.getInstance().getStudenti());
        remove = new ArrayList<Student>();
	
		String[] splits = pretraga.split(" ");
		   
		   for(Student s: listapretraga ) {
			   if(splits.length==1) {
			   if(!s.getPrezime().toUpperCase().contains(splits[0].toUpperCase()))
				   remove.add(s);
			   
			   }else if(splits.length==2) {
				   if(!s.getPrezime().toUpperCase().contains(splits[0].toUpperCase()))
					   remove.add(s);
				   else if(!s.getIme().toUpperCase().contains(splits[1].toUpperCase()))
				       remove.add(s);
	
			   }else if(splits.length==3){
				   if(!s.getPrezime().toUpperCase().contains(splits[0].toUpperCase()))
					   remove.add(s);
				   else if(!s.getIme().toUpperCase().contains(splits[1].toUpperCase()))
				       remove.add(s);
				   else if(!s.getBrojIndeksa().toUpperCase().contains(splits[2].toUpperCase()))
					   remove.add(s);
			   }
		   }
		   
		   listapretraga.removeAll(remove);
			
			if(listapretraga.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Nema studenata!", "Pretraga", JOptionPane.WARNING_MESSAGE,null);
				
			}else {
				BazaStudenata.getInstance().setStudenti(listapretraga);
				Tab.getInstance().azurirajPrikazStudenta(null, -1);
			}
		   }
}
