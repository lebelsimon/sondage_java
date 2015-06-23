import javax.swing.*;
import java.awt.*;

public class PropositionChoixNote extends JPanel{
	int valMin, valMax;
	JLabel valMaxL, valActuL;
	
	PropositionChoixNote(QuestionVue questionVue){
		//~ GridLayout g= new GridLayout(2,1);
		//~ g.setVgap(4);
		//~ this.setLayout( g);
		System.out.println("--- PropositionChoixNote --- ");
		JPanel listeChoix = new JPanel();
		
		valMax = questionVue.questionnaireVue.question.getMaxVal();
		valMin = 0;
		JSlider slide = new JSlider();
		slide.setMaximum(valMax);
		slide.setMinimum(valMin);
		slide.setValue(valMin);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		slide.setMinorTickSpacing(valMax/10);
		slide.setMajorTickSpacing(valMax);
		
		
		 //~ BorderLayout b=  new BorderLayout();
		 //~ b.setHgap(140);
		//~ JPanel Note = new JPanel(b);

		
		
		
		//Note.add( (slide.getValue()+""), BorderLayout.CENTER);
		//~ 
		System.out.println("la");
		listeChoix.add(slide);
		this.add(listeChoix);
		this.add(slide);
		//this.add(Note);
	//~ 
	
	

    } 
}
