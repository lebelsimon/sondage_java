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
	
	QuestionVue( QuestionnaireVue QuestionnaireV, Question q){
		this.setLayout( new BorderLayout());
		
		// initialisation des valeurs corespondant au elements de la Question
		questionnaireVue = QuestionnaireV;
		question = q;
		numQuestion =question.getNumQ();
		propositions = question.getPropositions();
		nombreVal = propositions.size();
		typeQuestion = question.getIdT()+"";
		enonceQuestion = question.getTexteQuestion();
		
		
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
	
	public void modifQuestion(Question q){	
		System.out.println("test1");

		QuestionnaireVue stock = questionnaireVue;
		this.question = q;
		this.removeAll();
		this.question = q;
		this.add(haut,"North");
		this.add(choix, "Center");
		this.questionnaireVue.module.fenetre.revalidate();
		this.questionnaireVue.module.fenetre.repaint();
		System.out.println("\nQuestion : "+q+ "MAQ: "+question);
		
		System.out.println("idQuestion: "+numQuestion);
		
		
		System.out.println("idQuestion: "+idQuestion.getText());
		this.add(choix, "Center");
		
		//this.revalidate();
		//~ this.repaint();
		//System.out.println(this.question);
		
		
		//~ this.removeAll();
		//~ this.questionnaireVue.question = q;
		//~ this.questionnaireVue.questionVue = new QuestionVue(this.questionnaireVue, this.questionnaireVue.question);
		//~ this.add(espaceSonde);
		//~ this.add(questionnaireVue);
		//~ this.revalidate();
		//~ this.repaint();
		
		//~ m.modif();
		//System.out.println("test");
	}
	
	
	
		
}
		
		
