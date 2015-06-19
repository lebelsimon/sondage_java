import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BoutonModifier implements ActionListener{
	
	VueSaisieQuestion quest;
	Question laQuestion;
	String q;
	
	public BoutonModifier(VueSaisieQuestion vue){
		quest=vue;
		q=vue.liste2.getSelectedValue();
		laQuestion = vue.question;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		quest.liste.removeElement(quest.liste2.getSelectedValue());
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
	    String nom = jop.showInputDialog(null, "Veuillez entrer une proposition", "Modification de la proposition ", JOptionPane.QUESTION_MESSAGE);
	    jop2.showMessageDialog(null, "Vous avez modifié la proposition en " + nom, "Proposition modifié", JOptionPane.INFORMATION_MESSAGE);
	    laQuestion.addProposition(new Proposition(nom));
	    quest.liste.addElement(nom);
	    
	}

}
