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
		test1 = new JRadioButton(" test 1") ;
		test2 = new JRadioButton(" test 2") ;
		test3 = new JRadioButton(" test 3") ;
		
		// Centrage des elements
		test1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		test2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		test3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		
		lesChoix.add(test1);
		lesChoix.add(test2);
		lesChoix.add(test3);
		
		
		// creation du panel contenant les choix et ajout: 
		// ATTENTION 
		JPanel listeChoix = new JPanel(new GridLayout(3,1));
		listeChoix.add(test1);
		listeChoix.add(test2);
		listeChoix.add(test3);
		
		this.add(listeChoix);
		
	}
}
		
		
