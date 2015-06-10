import javax.swing.*;
import java.awt.*;

public class QuestionnaireVue extends JPanel{
	//static Questionnaire q, Sonde s;
	private JLabel idQuestionnaire;
	// pour l'instant je crée un affichage vide, mais par la suite le constructeur prendra en parametre:
	//		Questionnaire q, Sonde s
	QuestionnaireVue(){
		super();
		this.setLayout(new BorderLayout());
		
		// Creation du label Questionnaire:
		
		idQuestionnaire = new JLabel("Questionnaire n° X");
		this.add(idQuestionnaire, "Center");
		
		
		
	}
}
