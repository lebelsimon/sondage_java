import javax.swing.*;

import java.awt.*;

/**
 * @author LAVOREL Anais
 * Panel contenant une JListe des reponce déjà entré et un espace de réponce
 */
public class PropositionChoixLibre extends JPanel{

	DefaultListModel<Proposition> lesPropositions;
	JList<Proposition> listePropositions;
	JTextField marep;
	
	PropositionChoixLibre(QuestionVue qVue){
		super();
		this.setLayout(new BorderLayout());

		lesPropositions = qVue.question.getPropositions();
		
		// creation de la liste des choix:
		listePropositions = new JList<Proposition>(lesPropositions); 
		listePropositions.setLayoutOrientation(JList.VERTICAL);
		
		// creation du choix libre
		JLabel info = new JLabel("Autre réponse :");
		marep = new JTextField(20);
		
		marep.setBorder(BorderFactory.createLineBorder(Color.black));

		JPanel reponce = new JPanel(new GridLayout(1,2));
		reponce.add(info);
		reponce.add(marep);
		
		// scroll bar
		JScrollPane  scroll = new JScrollPane(listePropositions, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		int propLargeur = qVue.questionnaireVue.largeur - qVue.questionnaireVue.largeur/10;
		int propHauteur = qVue.questionnaireVue.hauteur/2 - qVue.enonce.getHeight()-50;
		scroll.setPreferredSize( new Dimension(propLargeur,propHauteur));

		this.add(scroll, BorderLayout.NORTH);
		this.add(reponce, BorderLayout.SOUTH);
		this.setSize(300, 500);
		this.revalidate();
		
	}
}
