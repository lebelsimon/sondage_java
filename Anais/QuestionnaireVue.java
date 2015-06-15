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
		this.setLayout(new GridLayout(3,1));

		
		// Creation du label Questionnaire:
		
		JPanel idQuestionnaireJ = new JPanel(new FlowLayout());
		idQuestionnaire = new JLabel("Questionnaire n° X");
		idQuestionnaireJ.add(idQuestionnaire);
		
		// réation de la vue de la question:
			// par la suite on donnera une question et il creera la vue en fonction de la question
		q = new QuestionVueXChoix();
		
		
		//this.add(new JLabel("TESTTTTT"));
		this.add(idQuestionnaireJ);
		this.add(q);
		
		
		
	}
}
