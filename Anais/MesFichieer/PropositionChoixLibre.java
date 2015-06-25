import javax.swing.*;

import java.awt.*;

// note:  a refaire pour mettre une liste deroulante: URGENT 

public class PropositionChoixLibre extends JPanel{
	//private Question q;
	DefaultListModel<Proposition> lesPropositions;
	JList<Proposition> listePropositions;

	JTextField marep;
	
	PropositionChoixLibre(QuestionVue qVue){
		
		System.out.println("--- PropositionChoixLibre --- ");
		//~ super();
		this.setLayout(new BorderLayout());

		lesPropositions = qVue.question.getPropositions();
		
		// creation de la liste des choix:
	
		listePropositions = new JList<Proposition>(lesPropositions); 

		listePropositions.setLayoutOrientation(JList.VERTICAL);
		System.out.println("listePropositions: " +listePropositions);
		// creation du choix libre
		marep = new JTextField(20);
		marep.setBorder(BorderFactory.createLineBorder(Color.black));

		
		//System.out.println("deb crea scroll");
		
		
		// scroll bar
		JScrollPane  scroll = new JScrollPane(listePropositions, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		int propLargeur = qVue.questionnaireVue.largeur - qVue.questionnaireVue.largeur/10;
		int propHauteur = qVue.questionnaireVue.hauteur/2 - qVue.enonce.getHeight()-20;
		scroll.setPreferredSize( new Dimension(propLargeur,propHauteur));

		
		
		
		this.add(scroll, BorderLayout.NORTH);
		this.add(marep, BorderLayout.SOUTH);
		this.setSize(300, 500);
		this.revalidate();
		
	}
}
