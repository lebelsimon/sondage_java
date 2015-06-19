import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class BoutonAjouter implements ActionListener{
	
	VueSaisieQuestion quest;
	Question q;
	
	public BoutonAjouter(VueSaisieQuestion vue){
		quest=vue;
		q=vue.question;
		
		
	}

	public void actionPerformed(ActionEvent e) {
		
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
	    String nom = jop.showInputDialog(null, "Veuillez entrer une proposition", "Ajout de proposition", JOptionPane.QUESTION_MESSAGE);
	    jop2.showMessageDialog(null, "Vous avez ajoute la proposition " + nom, "Proposition ajoute", JOptionPane.INFORMATION_MESSAGE);
	    q.addProposition(new Proposition(nom));
	    quest.liste.addElement(nom);
	}
	
	

}
