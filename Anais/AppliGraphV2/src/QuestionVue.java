import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class QuestionVue extends JPanel{
	JLabel idQuestion;
	JTextArea enonce;
	int numQuestion;
	int nombreVal;
	String typeQuestion ;
	DefaultListModel<Proposition> propositions;
	Question question;
	QuestionnaireVue questionnaireVue;
	String enonceQuestion;
	JPanel haut,choix;
	
	QuestionVue( QuestionnaireVue _questionnaireVue, Question q){
		this.setLayout( new BorderLayout( 40,50));
		questionnaireVue = _questionnaireVue;
		
		// initialisation des valeurs corespondant au elements de la Question
		numQuestion = q.getNumQ();
		propositions = q.getPropositions();
		nombreVal = propositions.size();
		typeQuestion = q.getIdT();
		enonceQuestion = q.getTexteQuestion();
		
		
		// creations des elements de la vue
		idQuestion = new JLabel("Question numero: "+numQuestion);
		idQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		
		enonce = new JTextArea(enonceQuestion);
		enonce.setEditable(false);
		enonce.setLineWrap(true);
		
		//creation du panel contenant l'identifiant et l'enonce de la question	
		haut = new JPanel(new GridLayout(2,1)); /// A MODIFIERRRRRRRRRRRRRRRR CAR GRID => TAILLE IDQ == TAILLE ENONCE
		
		
		// ajout des element a la vue QUestion
		haut.add(idQuestion);
		haut.add(enonce);
		this.add(haut,"North");
		
		// creation des proposition
		choix = this.creerProposition(typeQuestion);
		this.add(choix, "Center");
	}
	
	// cree la liste des propositon en fonction du type de question
	public JPanel creerProposition(String typeQuestion){
		JPanel res;
		
		if (typeQuestion.equals("l")){
			res = new PropositionChoixLibre(this);
		}
		else if( typeQuestion.equals("c")){
			res = new PropositionChoixOrdonnee(this.question);
		}
		else if ( typeQuestion.equals("m")){
			res = new PropositionChoixX(this.question);
		}
		else if( typeQuestion.equals("n")){
			res = new PropositionChoixNote(this.question);
		}
		else{
			res = new PropositionChoix1(this);
		}
		return res;
	}
	
		
}
		
		
