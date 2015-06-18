import java.awt.event.*;

import javax.swing.JButton;


public class ControleurVueGestQuest implements ActionListener {
	VueGestQuest VGQ;
	ConnexionMySQL connect;
	public ControleurVueGestQuest(VueGestQuest i,ConnexionMySQL connect){
		this.VGQ = i;
		this.connect = connect;
	}
	public void actionPerformed(ActionEvent arg0) {
		JButton b =(JButton)arg0.getSource();
		if(b.getName()=="Deconnexion"){
			Connexion conn = new Connexion(connect);
			VGQ.setVisible(false);
		}
		if(b.getName()=="Ajouter"){
			VueCreatQuest VCQ = new VueCreatQuest("c",VGQ.connection);
			VGQ.setVisible(false);
		}
		if(b.getName()=="Supprimer"){
			VGQ.listcat.removeElementAt(VGQ.list.getSelectedIndex());
		}
		if(b.getName()=="Modifier"){
			VueCreatQuest VCQ = new VueCreatQuest("m",VGQ.connection);
			VGQ.setVisible(false);
		}
	}
}