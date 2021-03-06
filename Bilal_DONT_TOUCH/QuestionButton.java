import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;


public class QuestionButton implements ActionListener {
	
	// Lien vers le questionnaire pour pouvoir modifier certaines de ses propriétés
	//~ Question q;
	
	 // nom du bouton:
	String nom;
	
	// Constructeur
	public QuestionButton(String _nom){//, Question _q) {
		//~ this.q=_q;
		this.nom=_nom;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

			// on change l'affichage en fonction du boutons choisi
			switch (nom){	
				case "prec": 
					System.out.println("bouton prec"); 

					questionnaireVue.ChangerQuestion(questionnaireVue.questionnaire.getListeQuestions().get(questionnaireVue.questionVue.question.getNumQ() -2));
					questionnaireVue.qder.setEnabled(true);
					questionnaireVue.qsuiv.setEnabled(true);
					questionnaireVue.terminer.setVisible(false);
					
					if ( questionnaireVue.questionVue.question.numQ == 1){
						questionnaireVue.qprem.setEnabled(false);
						questionnaireVue.qprec.setEnabled(false);
					}
					break;
					
				case "suiv": 
					System.out.println("bouton suiv"); 

					questionnaireVue.ChangerQuestion(questionnaireVue.questionnaire.getListeQuestions().get(questionnaireVue.questionVue.question.getNumQ())); //newQ);
					
					questionnaireVue.qprem.setEnabled(true);
					questionnaireVue.qprec.setEnabled(true);
					if ( questionnaireVue.questionVue.question.numQ == questionnaireVue.questionnaire.nbQuestions()){
						questionnaireVue.qder.setEnabled(false);
						questionnaireVue.qsuiv.setEnabled(false);
						questionnaireVue.terminer.setVisible(true);
					}

					break;
				case "prem": 
					System.out.println("bouton prem"); 

					questionnaireVue.ChangerQuestion(questionnaireVue.questionnaire.getListeQuestions().get(0));
					questionnaireVue.qprem.setEnabled(false);
					questionnaireVue.qprec.setEnabled(false);
					questionnaireVue.terminer.setVisible(false);
					
					
					break;
				case "dern":

					System.out.println("bouton dern"); 

					questionnaireVue.ChangerQuestion(questionnaireVue.questionnaire.getListeQuestions().get(questionnaireVue.questionnaire.getListeQuestions().size()-1));
					
					questionnaireVue.qder.setEnabled(false);
					questionnaireVue.qsuiv.setEnabled(false);
					questionnaireVue.terminer.setVisible(true);

					break;	
					
				case "suivi":
					modsond.modif();
					break;
				case "appeler":
					BoiteDialogue bt=new BoiteDialogue(5000);
					bt.start();
					bt.showMessageDialog(null, "Appel en cours...");
					System.out.println("terminer");break;
			}
	}

}
