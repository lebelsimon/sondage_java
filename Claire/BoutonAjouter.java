import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class BoutonAjouter implements ActionListener{
	
	VueSaisieQuestion quest;
	
	public BoutonAjouter(){
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
	    String nom = jop.showInputDialog(null, "Veuillez entrer une proposition", "Ajout de proposition", JOptionPane.QUESTION_MESSAGE);
	    jop2.showMessageDialog(null, "Vous avez ajouté la proposition " + nom, "Proposition ajouté", JOptionPane.INFORMATION_MESSAGE);
	    
	}
	
	

}
