import javax.swing.*;
import java.awt.*;

// note: il faudrait pouvoir retirer la selection pour evite d'avoir une reponse involontaire

public class QuestionVue1Choix extends QuestionVue{
	//private Question q;
	
	JRadioButton test1;
	JRadioButton test2;
	JRadioButton test3;
	
	QuestionVue1Choix(){//Question q){
		super();
		
		// Creation des boutons et du groupement de bouton car 1 seule réponce est attendu
		ButtonGroup lesChoix = new ButtonGroup();
		test1 = new JRadioButton(" testeee 1") ;
		test2 = new JRadioButton(" test 2") ;
		test3 = new JRadioButton(" test 3") ;
		
		// Centrage des elements
		//~ test1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		//~ test2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		//~ test3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		//~ 
		
		lesChoix.add(test1);
		lesChoix.add(test2);
		lesChoix.add(test3);
		
		//~ test1.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		//~ test2.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		//~ test3.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		
		// creation du panel contenant les choix et ajout: 
		// ATTENTION 
		JPanel listeChoix = new JPanel(new GridLayout(3,1));
		listeChoix.add(test1);
		listeChoix.add(test2);
		listeChoix.add(test3);
		listeChoix.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));

		this.add(listeChoix, BorderLayout.CENTER);
		
	}
}
		
		