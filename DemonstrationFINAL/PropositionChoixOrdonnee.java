import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author LAVOREL anais
 * Cree un panel contenant les JComboBox
 */
public class PropositionChoixOrdonnee extends JPanel{

	Integer [] opts; // la liste des Entier permetant de classer les choix
	int nbValOrdonne;
	
		// La Liste des proposition
	DefaultListModel<Proposition>  listeProp;
		// la liste des JComboBox
	ArrayList< JComboBox<Integer>> mesBoutons;
	
		// Constructeur
	PropositionChoixOrdonnee(QuestionVue qVue){
		
		nbValOrdonne = qVue.question.getMaxVal();
		opts = new Integer[nbValOrdonne+1];
		listeProp = qVue.question.getPropositions();
		mesBoutons =  new ArrayList< JComboBox<Integer>>();
		
			// mise en place d'un GridLayout pour espacer les element du panel
		GridLayout g = new GridLayout(listeProp.size(),2);
		g.setHgap(4);
		g.setVgap(4);
		this.setLayout(g);
		
		
		//remplisage de la liste des choix
		for( int i=1; i< nbValOrdonne+1; i++){
			opts[i] = (Integer) i;
		}

		// creation de la liste des elements qui serons affiché
		for(int i=0; i< listeProp.size(); i++){
			JComboBox<Integer> maliste = new JComboBox<Integer>(opts);
				this.add(maliste  );
				mesBoutons.add(maliste);
				JLabel lab = new JLabel( listeProp.get(i).getTexte());
				lab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				this.add( lab );
		}

	}
}
		
		
