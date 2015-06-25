import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;


/**
 * @author LAVOREL anais
 * Cree un panel contenant la Jliste des Proposition
 */
public class PropositionChoix1 extends JPanel{
	
	// =================================================================
	//     Creations des variable 
	// =================================================================
		// La liste des proposition
	Proposition[] lesPropositions;
		// la JList elle même
	JList<Proposition> listePropositions;
	
	int propLargeur, propHauteur, posX, posY;
	
		// Constructeur
	PropositionChoix1(QuestionVue qVue){
		
		propLargeur = qVue.questionnaireVue.largeur - qVue.questionnaireVue.largeur/10;
		propHauteur = qVue.questionnaireVue.hauteur/2 - qVue.enonce.getHeight();
		lesPropositions = new Proposition [qVue.question.getPropositions().size()];
		
			// implémentation de la liste des Proposition
		for( int i=0; i< qVue.question.getPropositions().size(); i++)
			lesPropositions[i] = qVue.question.getPropositions().get(i);
		
			// JListe contenant les choix
		listePropositions = new JList<Proposition>(lesPropositions); 
		listePropositions.setLayoutOrientation(JList.VERTICAL);
		
			// creation du scroll
		JScrollPane  scroll = new JScrollPane(listePropositions, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize( new Dimension(propLargeur,propHauteur));
		scroll.setBorder(new TitledBorder("Choix possibles" ));
		
		this.add(scroll);
	}
}
		
		
