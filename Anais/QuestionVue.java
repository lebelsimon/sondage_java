import javax.swing.*;
import java.awt.*;

public class QuestionVue extends JPanel{
	private JLabel idQuestion;
	private JTextField enonce;
	static Question question;
	static boolean estRemplie;
	
	private DefaultListModel<Proposition> listeProp;
	
	QuestionVue(){
		
		// init 
		estRemplie = false;
		String numQuestion = "Question n° "+ question.numQ;
		String enonceQuestion = question.getTexteQuestion();
		DefaultListModel<Proposition>  listeProp = question.propositions;
		
		this.setLayout( new BorderLayout( 40, 4));
		
		idQuestion = new JLabel(numQuestion);
		idQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		
		enonce = new JTextField(enonceQuestion);
		enonce.setEditable(false);
		
		
		JPanel reponces = new JPanel();
		
		//reponces.add(new JLabel("LES REPONSES"));
		
		JPanel haut = new JPanel(new GridLayout(2,1));
		haut.add(idQuestion);
		haut.add(enonce);
		this.add(haut,"North");
	}
}
		
		
