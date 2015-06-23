import javax.swing.*;
import java.awt.*;

public class PropositionChoixX extends JPanel{
	ButtonGroup lesChoix;
	DefaultListModel<Proposition>  lesPropositions;
	
	PropositionChoixX(Question q){
	System.out.println("--- PropositionChoixX --- ");
		// initialisation:
		lesPropositions = q.getPropositions();
		this.setLayout( new GridLayout(lesPropositions.size(),1));
		
		for(int i=0; i< lesPropositions.size(); i++){
			JCheckBox elem = new JCheckBox( lesPropositions.get(i).getTexte());
			elem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			this.add(elem);
		}
	}
}
		
		
