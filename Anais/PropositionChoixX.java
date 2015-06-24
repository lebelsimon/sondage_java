import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.ArrayList;

public class PropositionChoixX extends JPanel{
	ButtonGroup lesChoix;
	DefaultListModel<Proposition>  lesPropositions;
	JList<JCheckBox> listePropositions;
	ArrayList<Checkbox> mesBox;
	
	@SuppressWarnings("deprecation")
	PropositionChoixX(QuestionVue questionVue){
	System.out.println("--- PropositionChoixX --- ");
		// initialisation:

		mesBox = new ArrayList<Checkbox>();

		
		lesPropositions = questionVue.question.getPropositions();
		//b.Y_AXIS = questionVue.questionnaireVue.largeur/3 + questionVue.questionnaireVue.getX();
		this.setLayout( new BoxLayout(this, BoxLayout.Y_AXIS));
		
		for(int i=0; i< lesPropositions.size(); i++){
			Checkbox elem = new Checkbox( lesPropositions.get(i).getTexte());
			//elem.setMargin();;
			//elem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			this.add(elem);
			mesBox.add(elem);
			

		}
		System.out.println(mesBox);
		
		
		
//		this.getCon
		this.setBorder(new EmptyBorder(10, 100, 10, 10));
		
		
		

}
}
		
		
