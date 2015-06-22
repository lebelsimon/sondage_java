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
			VGQ.dispose();
		}
		if(b.getName()=="Ajouter"){
			VueCreatQuest VCQ = new VueCreatQuest(VGQ.connection);
			VGQ.dispose();
		}
		if(b.getName()=="Supprimer"){
			int indiceSuppr = VGQ.list.getSelectedIndex();
			VGQ.qBD.supprimerQuestionnaire(VGQ.listeQ.get(indiceSuppr).getIdQ());
			VGQ.listcat.removeElementAt(indiceSuppr);
		}
		if(b.getName()=="Modifier"){
			int indiceModif = VGQ.list.getSelectedIndex();
			VueCreatQuest VCQ = new VueCreatQuest(VGQ.connection,VGQ.listeQ.get(indiceModif));
			VGQ.dispose();
		}
	}
}
