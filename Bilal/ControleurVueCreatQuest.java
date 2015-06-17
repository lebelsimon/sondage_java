import java.awt.event.*;

import javax.swing.JButton;


public class ControleurVueCreatQuest implements ActionListener {
	VueCreatQuest VCQ;
	public ControleurVueCreatQuest(VueCreatQuest i){
		this.VCQ = i;
	}
	public void actionPerformed(ActionEvent arg0) {
		JButton b =(JButton)arg0.getSource();
		if(b.getName()=="Deconnexion"){
			Connexion conn = new Connexion();
			VCQ.dispose();
		}
		if(b.getName()=="Ajouter"){
//			VueSaisieQuestion VSQ = new VueSaisieQuestion();
			VCQ.dispose();
		}
		if(b.getName()=="Supprimer"){
			VCQ.list.removeElementAt(VCQ.listeQ.getSelectedIndex());
		}
		if(b.getName()=="Modifier"){
//			VueSaisieQuestion VSQ = new VueSaisieQuestion();
			VCQ.dispose();
		}
		if(b.getName()=="Annuler"){
			VueGestQuest VGQ = new VueGestQuest();
			VCQ.dispose();
		}
		if(b.getName()=="Valider"){
			VueGestQuest VGQ = new VueGestQuest();
			VCQ.dispose();
		}
	}
}
