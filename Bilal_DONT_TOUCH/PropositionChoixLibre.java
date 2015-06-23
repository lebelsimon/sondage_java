import javax.swing.*;
import java.awt.*;

// note:  a refaire pour mettre une liste deroulante: URGENT 

public class PropositionChoixLibre extends JPanel{
	//private Question q;
	DefaultListModel<Proposition> lesPropositions;
	JList<Proposition> listePropositions;
	// scroll
	
	
	PropositionChoixLibre(Question q){
		
		System.out.println("--- PropositionChoixLibre --- ");
		//~ super();
		this.setLayout(new BorderLayout());
		
		lesPropositions = q.getPropositions();
		
		// creation de la liste des choix:
	
		listePropositions = new JList<Proposition>(lesPropositions); 
		//~ listePropositionsT = new JList<String>(listePropositionsT);
		//~ for( int i=0; i< listePropositions.size(); i++){
			//~ listePropositionsT.add(listePropositions.get(i).getTexte());
		//~ }
		listePropositions.setLayoutOrientation(JList.VERTICAL_WRAP);
		System.out.println("listePropositions: " +listePropositions);
		// creation du choix libre
		JTextField marep = new JTextField(20);
		
		// creation du panel contenant les choix et ajout: 
		// ATTENTION 
		

;


		
		
		//~ listeChoix.setLayoutOrientation(JList.VERTICAL_WRAP);
		
		System.out.println("deb crea scroll");
		
		
		// scroll bar
		JScrollPane  scroll = new JScrollPane(listePropositions, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize( new Dimension(50,300));
		

		
		
		
		this.add(scroll, BorderLayout.WEST);
		this.add(marep, BorderLayout.EAST);
		this.setSize(300, 500);
		this.revalidate();
		
	}
}
