import javax.swing.*;
import java.awt.*;

// note: REGLER PB DU SCROLL

public class PropositionChoix1 extends JPanel{
	
	// la liste des Propositions
	Proposition[] lesPropositions;
	// la JList elle même
	JList<Proposition> listePropositions;
	
	PropositionChoix1(Question q){
		System.out.println("--- PropositionChoix1 --- ");
		lesPropositions = new Proposition [q.getPropositions().size()];
		
		for( int i=0; i< q.getPropositions().size(); i++)
			lesPropositions[i] = q.getPropositions().get(i);
		
		this.setLayout(new GridLayout(q.getPropositions().size(),1));
		
		listePropositions = new JList<Proposition>(lesPropositions); 
		listePropositions.setLayoutOrientation(JList.VERTICAL_WRAP);
		
		JScrollPane  scroll = new JScrollPane(listePropositions, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize( new Dimension(300,400));
		//scroll.setBorder(new TitledBorder("Choix possibles" ));
		
		

		this.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));
		this.add(scroll);
	}
}
		
		
