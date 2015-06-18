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
	String enonceQuestion;
	
	
	QuestionVue( Question question){
		this.setLayout( new BorderLayout( 40,50));
		
		// initialisation des valeurs corespondant au elements de la Question
		numQuestion = question.getNumQ();
		propositions = question.getPropositions();
		nombreVal = propositions.size();
		typeQuestion = question.getIdT()+"";
		enonceQuestion = question.getTexteQuestion();
		this.question = question;
		
		// creations des elements de la vue
		idQuestion = new JLabel("Question numero: "+numQuestion);
		idQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		
		enonce = new JTextArea(enonceQuestion);
		enonce.setEditable(false);
		enonce.setLineWrap(true);
		
		// creation du panel contenant toutes les questions
		JPanel reponces = new JPanel();	
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
	public JPanel creerProposition(String typeQuestion){
		JPanel res;
		
		if (typeQuestion.equals("l")){
			res = new PropositionChoixLibre(this.question);
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
			res = new PropositionChoix1(this.question);
		}
		return res;
	}
}
		
		
