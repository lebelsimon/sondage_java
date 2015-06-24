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
	char typeQ;
	
	// Constructeur
	public QuestionnaireButton(String _nom, QuestionnaireVue qVue){
		this.questionnaireVue=qVue;
		this.nom=_nom;
		this.mo=null;
		this.modsond=null;
		this.typeQ = this.questionnaireVue.questionVue.question.getIdT();
	}
	public QuestionnaireButton(String _nom, mod mo){

		this.nom=_nom;
		this.mo=mo;
		this.modsond=mo.modsond;
		this.typeQ = 'x';
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
					System.out.print(questionnaireVue.questionVue.question.getNumQ());
					int nb = (questionnaireVue.questionVue.question.getNumQ())-2;
					System.out.println(nb);
					System.out.println(questionnaireVue.module.questionnaire.getListeQuestions().get(nb));
					if ( questionnaireVue.module.questionnaire.getListeQuestions().get(nb).getNumQ() ==1){
						questionnaireVue.qprec.setEnabled(false);
						questionnaireVue.qprem.setEnabled(false);
					}
					questionnaireVue.qsuiv.setEnabled(true);
					questionnaireVue.qder.setEnabled(true);
					questionnaireVue.ChangerQuestion(questionnaireVue.module.questionnaire.getListeQuestions().get(nb));
					
					break;
					
				case "suiv": 
					System.out.println("bouton suiv"); 
					if (questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.questionVue.question.getNumQ()) == questionnaireVue.module.questionnaire.getListeQuestions().get((questionnaireVue.module.questionnaire.getListeQuestions().size())-1)){
						questionnaireVue.qder.setEnabled(false);
						questionnaireVue.qsuiv.setEnabled(false);
					}
					questionnaireVue.qprec.setEnabled(true);
					questionnaireVue.qprem.setEnabled(true);
					questionnaireVue.ChangerQuestion(questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.questionVue.question.getNumQ())); //newQ);

					break;
				case "prem": 
					System.out.println("bouton prem");
					
					questionnaireVue.qprec.setEnabled(false);
					questionnaireVue.qprem.setEnabled(false);
					questionnaireVue.qsuiv.setEnabled(true);
					questionnaireVue.qder.setEnabled(true);
					questionnaireVue.ChangerQuestion( questionnaireVue.module.questionnaire.getListeQuestions().get(0));
								
					break;
					
				case "dern":
					System.out.println("bouton dern"); 
					questionnaireVue.qsuiv.setEnabled(false);
					questionnaireVue.qder.setEnabled(false);
					questionnaireVue.qprec.setEnabled(true);
					questionnaireVue.qprem.setEnabled(true);
					questionnaireVue.terminer.setEnabled(true);
					questionnaireVue.ChangerQuestion( questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.module.questionnaire.getListeQuestions().size()-1));
					
					break;				
				
				case "suivi":
					System.out.println("suiv");
					modsond.modif();
					break;
				case "appeler":
					BoiteDialogue bt=new BoiteDialogue(5000);
					bt.start();
					Icon tel = new ImageIcon("../Ressources/tel.png");
					Object[] options = {"Annuler" };
					bt.showOptionDialog(null,"Appel en cours ...", "Appel",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,tel, options, options[0]);
					System.out.println("terminer");break;
			}

	}
	
	//~ public void misePlaceRep(){
		//~ questionnaireVue.questionnaire.ajouterReponse(questionnaireVue.questionVue.question.getNumQ(), reponse)
			//~ }
		//~ }

}
