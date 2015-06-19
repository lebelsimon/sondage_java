import javax.swing.*;
import java.awt.*;

public class QuestionVue extends JPanel{
	private JLabel idQuestion;
	private JTextField enonce;
	
	QuestionVue(){
		this.setLayout( new BorderLayout( 40, 4));
		idQuestion = new JLabel("Question n° X/Y");
		idQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		enonce = new JTextField("blablabla");
		enonce.setEditable(false);
		
		
		JPanel reponces = new JPanel();
		reponces.add(new JLabel("LES REPONSES"));
		
		JPanel haut = new JPanel(new GridLayout(2,1));
		haut.add(idQuestion);
		haut.add(enonce);
		this.add(haut,"North");
	}
}
		
		
