import javax.swing.*;
import java.awt.*;

public class QuestionVueChoixNote extends QuestionVue{
	JCheckBox test1;
	JCheckBox test2;
	JCheckBox test3;
	
	QuestionVueChoixNote(){
		super();
		
		JPanel listeChoix = new JPanel();
		
		JSlider slide = new JSlider();
		slide.setMaximum(100);
		slide.setMinimum(0);
		slide.setValue(30);
		
		listeChoix.add(slide);
		this.add(listeChoix);

	}
}
