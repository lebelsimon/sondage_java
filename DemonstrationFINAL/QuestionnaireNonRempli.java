import javax.swing.*;
import java.util.List;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import java.awt.*;


/**
 * @author LAVOREL anais
 * Cree un Panel contenant la JListe des question a remplir
 */
public class QuestionnaireNonRempli extends JPanel{
	
	QuestionnaireNonRempli(QuestionnaireVue q){
		QuestionnaireVue questionnaireVue = q;
		
			// Liste des question a remplir
		String[] questionAremplir = new String[q.module.questionnaire.getListeQuestions().size() - q.module.questionnaire.getListeReponses().size()];

			// Implementation de la liste des question non rempli
		int id=0;
		for(int i=0; i< q.module.questionnaire.getListeQuestions().size(); i++){
				//on verifie que la question n'a pas de reponses pour l'instant
			if (! q.module.questionnaire.getListeReponses().containsKey(q.module.questionnaire.getListeQuestions().get(i).getNumQ())){
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
		
	}
}
