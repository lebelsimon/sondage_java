import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;


@SuppressWarnings("serial")
public class ApplicationSondageSQ extends JFrame {
	public ApplicationSondageSQ(){
		super("Rapid'Sond");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel Fenetre = new JPanel();
		Fenetre.setLayout( new GridLayout() );
		this.setJMenuBar(new Menu(this));
		QuestionSQ question = new QuestionSQ("Aimes-tu les cookies ?");
		PropositionSQ p1 = new PropositionSQ("Oui", true);
		PropositionSQ p2 = new PropositionSQ("Non", false);
		PropositionSQ p3 = new PropositionSQ("Peut etre", false);
		question.addProposition(p1,0);
		question.addProposition(p2,1);
		question.addProposition(p3,2);
		VueSaisieQuestion QCM1 = new VueSaisieQuestion(question);
		this.getContentPane().add(QCM1);
		this.setVisible(true);
	}

}
