import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 

/**
 * @author LAVOREL Anais
 * Gestion de la remise a 0 de la reponce à la question
 */
public class QuestionButton implements ActionListener {
	char TypeQ;
	QuestionVue questionVue;
	
	public QuestionButton( QuestionVue qVue){
		this.questionVue= qVue;
		this.TypeQ= questionVue.typeQuestion;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		questionVue.questionnaireVue.module.questionnaire.listeReponses.remove(questionVue.numQuestion);
		questionVue.questionnaireVue.ChangerQuestion(questionVue.question);	
	}
}
