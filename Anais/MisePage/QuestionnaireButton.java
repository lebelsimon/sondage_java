import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;


public class QuestionnaireButton implements ActionListener {
	
	// Lien vers le questionnaire pour pouvoir modifier certaines de ses propriétés
	//~ Questionnaire q;
	
	 // nom du bouton:
	String nom;
	mod mo;
	ModuleSondage modsond;
	QuestionnaireVue questionnaireVue;
	
	// Constructeur
	public QuestionnaireButton(String _nom, QuestionnaireVue qVue){
		this.questionnaireVue=qVue;
		this.nom=_nom;
		this.mo=null;
		this.modsond=null;
	}
	public QuestionnaireButton(String _nom, mod mo){

		this.nom=_nom;
		this.mo=mo;
		this.modsond=mo.modsond;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source;
			// on change l'affichage en fonction du boutons choisi
			
			source =  arg0.getSource();
			int newNumQ;
			Question newQ;
			switch (nom){	
				case "prec": 
					System.out.println("bouton prec"); 
					if ( (questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.question.getNumQ()).getNumQ())-2 ==0){
						questionnaireVue.qprec.setEnabled(false);
						questionnaireVue.qprem.setEnabled(false);
					}
					questionnaireVue.qsuiv.setEnabled(true);
					questionnaireVue.qder.setEnabled(true);
					questionnaireVue.ChangerQuestion(questionnaireVue, questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.question.getNumQ()));
					
					break;
					
				case "suiv": 
					System.out.println("bouton suiv"); 
					if (questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.question.getNumQ()) == questionnaireVue.module.questionnaire.getListeQuestions().get((questionnaireVue.module.questionnaire.getListeQuestions().size())-1)){
						questionnaireVue.qsuiv.setEnabled(false);
						questionnaireVue.qprem.setEnabled(false);
					}
					questionnaireVue.qprec.setEnabled(true);
					questionnaireVue.qprem.setEnabled(true);
					questionnaireVue.ChangerQuestion(questionnaireVue,questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.question.getNumQ())); //newQ);

					break;
				case "prem": 
					System.out.println("bouton prem");
					
					questionnaireVue.qprec.setEnabled(false);
					questionnaireVue.qprem.setEnabled(false);
					questionnaireVue.ChangerQuestion(questionnaireVue, questionnaireVue.module.questionnaire.getListeQuestions().get(0));
					
					// on rend les boutons precedent et Prem inactivé 
					
					
					
					break;
					
				case "dern":
					System.out.println("bouton dern"); 
					questionnaireVue.ChangerQuestion(questionnaireVue, questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.module.questionnaire.getListeQuestions().size()-1));
					questionnaireVue.qsuiv.setEnabled(false);
					questionnaireVue.qder.setEnabled(false);
					break;				
					 
			}

	}

}
