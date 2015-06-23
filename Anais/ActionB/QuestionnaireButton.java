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
	QuestionnaireVue questionVue;
	
	// Constructeur
	public QuestionnaireButton(String _nom, QuestionnaireVue qVue){//Questionnaire _q) {
		this.questionVue=qVue;
		this.nom=_nom;
		this.mo=null;
		this.modsond=null;
	}
	public QuestionnaireButton(String _nom, mod mo){//Questionnaire _q) {
		//~ this.q=_q;
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
					newNumQ = questionVue.question.getNumQ() -1;
					newQ = new Question(questionVue.questionnaire.getListeQuestions().get(newNumQ));
					System.out.println("Question: "+newQ);
					questionVue.ChangerQuestion(questionVue, newQ);
					
					break;
					
				case "suiv": 
					System.out.println("bouton suiv"); 
					newNumQ = questionVue.question.getNumQ() +1;
					newQ = new Question(questionVue.questionnaire.getListeQuestions().get(newNumQ));
					System.out.println("Question: "+newQ);
					questionVue.ChangerQuestion(questionVue, newQ);

					break;
				case "prem": 
					newNumQ = 1;
					System.out.println("bouton prem"); 
					newQ = new Question(questionVue.questionnaire.getListeQuestions().get(newNumQ));

					
					System.out.println("Question: "+newQ);
					questionVue.ChangerQuestion(questionVue, newQ);
					
					break;
				case "dern":
					newNumQ = questionVue.questionnaire.getListeQuestions().size()-1;
					System.out.println("bouton dern"); 
					newQ = new Question(questionVue.questionnaire.getListeQuestions().get(newNumQ));

					System.out.println("Question: "+newQ);
					questionVue.ChangerQuestion(questionVue, newQ);

					break;				
					 
			}

	}

}
