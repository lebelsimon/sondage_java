import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

// note: REGLER PB DU SCROLL

public class PropositionChoix1 extends JPanel{
	
	// la liste des Propositions
	Proposition[] lesPropositions;
	// la JList elle même
	JList<Proposition> listePropositions;
	
	int propLargeur, propHauteur, posX, posY;
	
	PropositionChoix1(QuestionVue qVue){
			

		System.out.println("--- PropositionChoix1 --- ");
		propLargeur = qVue.questionnaireVue.largeur - qVue.questionnaireVue.largeur/10;
		propHauteur = qVue.questionnaireVue.hauteur/2 - qVue.enonce.getHeight();
		
		
		lesPropositions = new Proposition [qVue.question.getPropositions().size()];
		
		for( int i=0; i< qVue.question.getPropositions().size(); i++)
			lesPropositions[i] = qVue.question.getPropositions().get(i);
		
		//this.setLayout(new GridLayout(question.getPropositions().size(),1));
		
		
		
		listePropositions = new JList<Proposition>(lesPropositions); 
		listePropositions.setLayoutOrientation(JList.VERTICAL);
		//listePropositions.setPreferredSize(new Dimension(propLargeur, propHauteur));
		JScrollPane  scroll = new JScrollPane(listePropositions, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize( new Dimension(propLargeur,propHauteur));
		scroll.setBorder(new TitledBorder("Choix possibles" ));
		
		

		this.add(scroll);
	}
}
		
		
