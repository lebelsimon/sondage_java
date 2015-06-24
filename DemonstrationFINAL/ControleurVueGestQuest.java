import java.awt.event.*;

import javax.swing.JButton;


public class ControleurVueGestQuest implements ActionListener {
	VueGestQuest VGQ;
	ConnexionMySQL connect;
	Utilisateur util;
	public ControleurVueGestQuest(VueGestQuest i,ConnexionMySQL connect,Utilisateur util){
		this.VGQ = i;
		this.util = util;
		this.connect = connect;
	}
	public void actionPerformed(ActionEvent arg0) {
		JButton b =(JButton)arg0.getSource();
		if(b.getName()=="Deconnexion"){
			Connexion conn = new Connexion(connect);
			VGQ.dispose();
		}
		if(b.getName()=="Ajouter"){
			VueCreatQuest VCQ = new VueCreatQuest(VGQ.connection,util);
			VGQ.dispose();
		}
		if(b.getName()=="Supprimer"){
			int indiceSuppr = VGQ.list.getSelectedIndex();
			VGQ.qBD.supprimerQuestionnaire(VGQ.listeQ.get(indiceSuppr).getIdQ());
			VGQ.listeQ.remove(indiceSuppr);
			VGQ.listcat.removeElementAt(indiceSuppr);
		}
		if(b.getName()=="Modifier"){
			int indiceModif = VGQ.list.getSelectedIndex();
			VueCreatQuest VCQ = new VueCreatQuest(VGQ.connection,VGQ.listeQ.get(indiceModif),util);
			VGQ.qBD.supprimerQuestionnaire(VGQ.listeQ.get(indiceModif).getIdQ());
			VGQ.dispose();
		}
	}
}
