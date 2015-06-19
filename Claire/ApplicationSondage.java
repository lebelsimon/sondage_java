import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;


@SuppressWarnings("serial")
public class ApplicationSondage extends JFrame {
	public ApplicationSondage(){
		super("Rapid'Sond");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Questionnaire questionnaire = new Questionnaire("Bidule",4, 12, 42, 69, 'v');
		Question question = new Question("Aimes-tu les cookies ?");
		Proposition p1 = new Proposition("Oui");
		Proposition p2 = new Proposition("Non");
		Proposition p3 = new Proposition("Peut etre");
		question.addProposition(p1);
		question.addProposition(p2);
		question.addProposition(p3);
		questionnaire.addQuestion(question);
		VueSaisieQuestion QCM1 = new VueSaisieQuestion(questionnaire, question);
		
		this.getContentPane().add(QCM1);
		JPanel Fenetre = new JPanel();
		Fenetre.setLayout( new GridLayout() );
		this.setJMenuBar(new Menu());
		

		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		ApplicationSondage aplli = new ApplicationSondage();
	}

}
