import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author LAVOREL anais
 * Cree un panel contenant les JCheckBox
 */
public class PropositionChoixX extends JPanel{
	ButtonGroup lesChoix;
	DefaultListModel<Proposition>  lesPropositions;
	
		// la JListe des JCheckBox
	JList<JCheckBox> listePropositions;
	ArrayList<Checkbox> mesBox;
	
	
	
	@SuppressWarnings("deprecation")
	PropositionChoixX(QuestionVue questionVue){
		mesBox = new ArrayList<Checkbox>();
		lesPropositions = questionVue.question.getPropositions();
		this.setLayout( new BoxLayout(this, BoxLayout.Y_AXIS));
		
			// implementation de la liste des JCheckBox
		for(int i=0; i< lesPropositions.size(); i++){
			Checkbox elem = new Checkbox( lesPropositions.get(i).getTexte());
			this.add(elem);
			mesBox.add(elem);
		}
	
		this.setBorder(new EmptyBorder(10, 100, 10, 10));
		
		
		

}
}
		
		
