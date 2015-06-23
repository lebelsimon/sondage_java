import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class QuestionVue extends JPanel{
	JLabel idQuestion;
	JTextArea enonce;
	int numQuestion;
	int nombreVal;
	char typeQuestion ;
	DefaultListModel<Proposition> propositions;
	Question question;
	QuestionnaireVue questionnaireVue;
	String enonceQuestion;
	
	
	QuestionVue( Question q, QuestionnaireVue questV){
		this.setLayout( new BorderLayout( 40,50));
		question = q;
		questionnaireVue = questV;
		// initialisation des valeurs corespondant au elements de la Question
		numQuestion = question.getNumQ();
		propositions = question.getPropositions();
		nombreVal = propositions.size();
		typeQuestion = question.getIdT();
		enonceQuestion = question.getTexteQuestion();
		
		
		
		// creations des elements de la vue
		idQuestion = new JLabel("Question numero: "+numQuestion);
		idQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		
		enonce = new JTextArea(enonceQuestion);
		enonce.setEditable(false);
		enonce.setLineWrap(true);
		
		//creation du panel contenant l'identifiant et l'enonce de la question	
		JPanel haut = new JPanel(new GridLayout(2,1));
		
		
		// ajout des element a la vue QUestion
		haut.add(idQuestion);
		haut.add(enonce);
		this.add(haut,"North");
		
		// creation des proposition
		JPanel choix = this.creerProposition(typeQuestion);
		this.add(choix, "Center");
	}
	
	// cree la liste des propositon en fonction du type de question
	public JPanel creerProposition(char typeQuestion){
		JPanel res;
		
		if (typeQuestion=='l'){
			res = new PropositionChoixLibre(this);
		}
		else if( typeQuestion=='c'){
			res = new PropositionChoixOrdonnee(this);
		}
		else if ( typeQuestion=='m'){
			res = new PropositionChoixX(this);
		}
		else if( typeQuestion=='n'){
			res = new PropositionChoixNote(this);
		}
		else{
			res = new PropositionChoix1(this);
		}
		return res;
	}
	
	
		
}
		
		
