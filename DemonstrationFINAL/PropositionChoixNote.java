import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.HTMLEditorKit;

import java.awt.*;
import java.io.*;

/**
 * @author LAVOREL Anais
 * Panel contenant le slider pour choisir la note
 */
public class PropositionChoixNote extends JPanel{
	Integer valMin, valMax,  val;
	JLabel valMaxL, valActuL;
	JSlider slide;
	PropositionChoixNote(QuestionVue questionVue){

		this.setLayout(new BorderLayout());
		
		valMax = questionVue.question.getMaxVal();
		valMin = 0;
		val = null;
		valActuL = new JLabel();
		valActuL.setHorizontalAlignment(getX() +this.getHeight());
		slide = new JSlider();
		slide.setMaximum(valMax);
		slide.setMinimum(valMin);
		slide.setValue(valMin);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		slide.setMinorTickSpacing(valMax/10);
		slide.setMajorTickSpacing(valMax);
		
		slide.addChangeListener(new ChangeListener(){

		public void stateChanged(ChangeEvent event){
			val = ((JSlider)event.getSource()).getValue();
			valActuL.setText("Valeur actuelle : " +val );
		      }});      

		this.add(slide, BorderLayout.CENTER);
		this.add(valActuL, BorderLayout.SOUTH);

		
		
		
		//Note.add( (slide.getValue()+""), BorderLayout.CENTER);
		//~ 
		//listeChoix.add(slide);
		//this.add(listeChoix);
		//this.add(slide);
		//this.add(Note);
	//~ 
	
	

    } 


}
