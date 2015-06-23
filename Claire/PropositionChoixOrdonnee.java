import javax.swing.*;
import java.awt.*;

// PB/ PAS D4AFFICHAGE
public class PropositionChoixOrdonnee extends JPanel{

	Integer [] opts;
	int nbValOrdonne;
	DefaultListModel<Proposition>  listeProp;
	
	PropositionChoixOrdonnee(Question question){
		System.out.println("--- PropositionChoixOrdonnee --- ");
		
		GridLayout g = new GridLayout(listeProp.size(),2);
		g.setHgap(4);
		g.setVgap(4);
		this.setLayout(g);
		
		// creation de la liste deroulante et des elements
		nbValOrdonne = question.getMaxVal();
		opts = new Integer[nbValOrdonne];
		listeProp = question.getPropositions();
		System.out.println("listeProp: "+listeProp);
		
		
		// Creation du contenaire
		//~ GridLayout g = new  GridLayout(listeProp.size(),2);
		//~ JPanel listeChoix = new JPanel(g);
		
		
		//remplisage de la lise des choix
		for( int i=1; i< nbValOrdonne+1; i++){
			opts[i] = (Integer) i;
		}
		
		// creation de la liste des elements qui serons affiché
		for(int i=0; i< listeProp.size(); i++){
				this.add( new JComboBox<Integer>(opts));
				JLabel lab = new JLabel( listeProp.get(i).getTexte());
				lab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				this.add( lab );
		}

	}
}
		
		
