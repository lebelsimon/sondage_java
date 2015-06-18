import javax.swing.*;
import java.awt.*;

public class QuestionVueXChoix extends QuestionVue{
	JCheckBox test1;
	JCheckBox test2;
	JCheckBox test3;
	
	QuestionVueXChoix(){
		super();
		
		ButtonGroup lesChoix = new ButtonGroup();
		test1 = new JCheckBox(" test1") ;
		test2 = new JCheckBox(" test2") ;
		test3 = new JCheckBox(" test3") ;
		
		// Centrage des elements
		test1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		test2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		test3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		JPanel listeChoix = new JPanel(new GridLayout(3,1));
		listeChoix.add(test1);
		listeChoix.add(test2);
		listeChoix.add(test3);
		
		this.add(listeChoix);

	}
}
		
		
