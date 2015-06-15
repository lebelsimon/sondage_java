import javax.swing.*;
import java.awt.*;

public class QuestionnaireVue extends JPanel{
	//static Questionnaire q, Sonde s;
	private JLabel idQuestionnaire;
	private QuestionVue q;
	
	// pour l'instant je crée un affichage vide, mais par la suite le constructeur prendra en parametre:
	//		Questionnaire q, Sonde s
	QuestionnaireVue(){
		super();
		this.setLayout(new BorderLayout());

		
		// Creation du label Questionnaire:
		
		JPanel idQuestionnaireJ = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 4));
		idQuestionnaire = new JLabel("Questionnaire n° X");
		idQuestionnaireJ.add(idQuestionnaire);
		idQuestionnaireJ.setBorder(BorderFactory.createLineBorder(Color.black));
		
		// creation des boutons et de leur panel
		
		JPanel boutonsQuestions = new JPanel();
		boutonsQuestions.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton qsuiv = new JButton(">");
		JButton qprec = new JButton("<");
		JButton qprem = new JButton("<<");
		JButton qder = new JButton(">>>");
		
		boutonsQuestions.add(qprem); 
		boutonsQuestions.add(qprec);
		boutonsQuestions.add(qsuiv); 
		boutonsQuestions.add(qder); 

		// réation de la vue de la question:
			// par la suite on donnera une question et il creera la vue en fonction de la question
		q = new QuestionVueChoixOrdonnee();
		
		q.setBorder(BorderFactory.createLineBorder(Color.black));

		
		//this.add(new JLabel("TESTTTTT"));
		this.add(idQuestionnaireJ, BorderLayout.NORTH);
		this.add(q, BorderLayout.CENTER);
		this.add(boutonsQuestions,BorderLayout.SOUTH); 		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
	}
}
