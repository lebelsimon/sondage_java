import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

// PB/ PAS D4AFFICHAGE
public class PropositionChoixOrdonnee extends JPanel{

	Integer [] opts;
	int nbValOrdonne;
	DefaultListModel<Proposition>  listeProp;
	ArrayList< JComboBox<Integer>> mesBoutons;
	PropositionChoixOrdonnee(QuestionVue qVue){
		System.out.println("--- PropositionChoixOrdonnee --- ");
		
		
		
		// creation de la liste deroulante et des elements

		nbValOrdonne = qVue.question.getMaxVal();
		opts = new Integer[nbValOrdonne+1];
		listeProp = qVue.question.getPropositions();
		mesBoutons =  new ArrayList< JComboBox<Integer>>();
		
		GridLayout g = new GridLayout(listeProp.size(),2);
		g.setHgap(4);
		g.setVgap(4);
		this.setLayout(g);
		
		// Creation du contenaire
		//~ GridLayout g = new  GridLayout(listeProp.size(),2);
		//~ JPanel listeChoix = new JPanel(g);
		
		
		//remplisage de la lise des choix
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
		
		
