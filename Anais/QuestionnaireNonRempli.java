import javax.swing.*;

import java.util.List;

import javax.swing.JList;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class QuestionnaireNonRempli extends JPanel{
	
	QuestionnaireNonRempli(QuestionnaireVue q){
		System.out.println("DEB creation VUE ERREUR ENREGISTREMENT");
		QuestionnaireVue questionnaireVue = q;
		System.out.println("Rep: "+q.module.questionnaire.getListeReponses() );
		String[] questionAremplir = new String[q.module.questionnaire.getListeQuestions().size() - q.module.questionnaire.getListeReponses().size()];
		System.out.println("Taille Liste: "+ (q.module.questionnaire.getListeQuestions().size() - q.module.questionnaire.getListeReponses().size()));
		int id= 0;
		for(int i=0; i< q.module.questionnaire.getListeQuestions().size(); i++){
			// on regarde si la question a une reponce
			if (! q.module.questionnaire.getListeReponses().containsKey(q.module.questionnaire.getListeQuestions().get(i).getNumQ())){
				System.out.println("idQ: "+q.module.questionnaire.getListeQuestions().get(i).getNumQ()+"\nTitre: "+ q.module.questionnaire.getListeQuestions().get(i).getTexteQuestion());
				questionAremplir[id] = q.module.questionnaire.getListeQuestions().get(i).getTexteQuestion();
				id++;
			}
		}
		
		JList<String> listeQuestions = new JList<String>(questionAremplir); 
		listeQuestions.setLayoutOrientation(JList.VERTICAL);
		
		
		// scroll bar
		JScrollPane  scroll = new JScrollPane(listeQuestions, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		int propLargeur = q.largeur - q.largeur/10;
		int propHauteur = q.hauteur/2 - q.getHeight()/10;
		scroll.setPreferredSize( new Dimension(propLargeur,propHauteur));
		scroll.setBorder(new TitledBorder("Question mal Remplis" ));
		
		// label Attention
		JLabel message = new JLabel("Veillez remplir les questions suivantes");
		this.add(message);
		this.add(scroll);
		this.setVisible(true);
		
		// on affiche dans le terminal pour verifier OSO
		for( int i=0; i<q.module.questionnaire.getListeQuestions().size() - q.module.questionnaire.getListeReponses().size(); i++ )
			System.out.println(questionAremplir[i]);
	}
}
