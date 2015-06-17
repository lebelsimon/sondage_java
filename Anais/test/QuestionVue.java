import javax.swing.*;
import java.awt.*;

public class QuestionVue extends JPanel{
	private JLabel idQuestion;
	private JTextArea enonce;
	
	QuestionVue(){
		this.setLayout( new BorderLayout( 40,50));
		idQuestion = new JLabel("Question n° X/Y");
		
		idQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		enonce = new JTextArea("blablablagrb	pbfguofubio&gbd_u&boi	gvbc_rfvbué	ofvbéy_oàvboé	");
		enonce.setEditable(false);
		enonce.setLineWrap(true);
		
		JPanel reponces = new JPanel();
		reponces.add(new JLabel("LES REPONSES"));
		
		JPanel haut = new JPanel(new GridLayout(2,1));
		haut.add(idQuestion);
		haut.add(enonce);
		this.add(haut,"North");

	}
}
		
		
