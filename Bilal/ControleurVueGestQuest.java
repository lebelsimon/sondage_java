import java.awt.event.*;

import javax.swing.JButton;


public class ControleurVueGestQuest implements ActionListener {
	VueGestQuest VGQ;
	public ControleurVueGestQuest(VueGestQuest i){
		this.VGQ = i;
	}
	public void actionPerformed(ActionEvent arg0) {
		JButton b =(JButton)arg0.getSource();
		if(b.getName()=="Deconnexion"){
			Connexion conn = new Connexion();
			VGQ.dispose();
		}
		if(b.getName()=="Ajouter"){
			VueCreatQuest VCQ = new VueCreatQuest("c");
			VGQ.dispose();
		}
		if(b.getName()=="Supprimer"){
			VGQ.listcat.removeElementAt(VGQ.list.getSelectedIndex());
		}
		if(b.getName()=="Modifier"){
			VueCreatQuest VCQ = new VueCreatQuest("m");
			VGQ.dispose();
		}
	}
}
