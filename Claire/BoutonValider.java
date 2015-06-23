import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BoutonValider implements ActionListener{
	
	VueSaisieQuestion vue;
	Questionnaire quest;
	
	BoutonValider(VueSaisieQuestion vue){
		this.vue=vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane jop = new JOptionPane();
	    jop.showMessageDialog(null, "Votre question a bien ete enregistre ", "Sauvegarde de la question", JOptionPane.INFORMATION_MESSAGE);
		Question q = new Question(vue.enonceQuestion.getText(), vue.question.getIdT(),vue.question.getMaxVal(),vue.question.getNumQ());
		// permet d'ajouter les propositions a la question
		for(int i=0; i<vue.liste.size(); i++){
			q.addProposition(new Proposition(vue.liste.elementAt(i)));
		}
		System.out.println(q);
	}

}
