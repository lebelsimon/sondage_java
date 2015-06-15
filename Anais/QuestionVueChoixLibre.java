import javax.swing.*;
import java.awt.*;

// note: il faudrait pouvoir retirer la selection pour evite d'avoir une reponse involontaire

public class QuestionVueChoixLibre extends QuestionVue{
	//private Question q;
	
	JRadioButton test1;
	JRadioButton test2;
	JRadioButton test3;
	
	QuestionVueChoixLibre(){//Question q){
		super();
		
		// Creation des boutons et du groupement de bouton car 1 seule réponce est attendu
		ButtonGroup lesChoix = new ButtonGroup();
		
		// Choix pre rentré
		test1 = new JRadioButton(" test 1") ;
		test2 = new JRadioButton(" test 2") ;
		test3 = new JRadioButton(" test 3") ;
		
		lesChoix.add(test1);
		lesChoix.add(test2);
		lesChoix.add(test3);
		
		
		// creation du choix libre
		JTextField marep = new JTextField(20);
		
		
		
		
		// creation du panel contenant les choix et ajout: 
		// ATTENTION 
		
		JPanel RadioButon = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JPanel listeChoix = new JPanel(new GridLayout(2,1));
		RadioButon.add(test1);
		RadioButon.add(test2);
		RadioButon.add(test3);
		
		listeChoix.add(RadioButon);
		listeChoix.add(marep);
		
		this.add(listeChoix);
		
	}
}
