import java.awt.event.*;

import javax.swing.JButton;


public class ControleurVueCreatQuest implements ActionListener {
	VueCreatQuest VCQ;
	ConnexionMySQL connect;
	Utilisateur util;
	public ControleurVueCreatQuest(VueCreatQuest i,ConnexionMySQL connect,Utilisateur util){
		this.VCQ = i;
		this.connect = connect;
		this.util = util;
	}
	public void actionPerformed(ActionEvent arg0) {
		JButton b =(JButton)arg0.getSource();
		if(b.getName()=="Deconnexion"){
			Connexion conn = new Connexion(connect);
			VCQ.dispose();
		}
		if(b.getName()=="Ajouter"){
			//VueSaisieQuestion vue = new VueSaisieQuestion(VCQ.questModif,connect);
			ApplicationSondage appli = new ApplicationSondage(VCQ.questModif,util);
			VCQ.setVisible(false);
		}
		if(b.getName()=="Supprimer"){
			int indiceSuppr = VCQ.listeQ.getSelectedIndex();
			VCQ.list.removeElementAt(indiceSuppr);
		}
		if(b.getName()=="Modifier"){
			// Executable exe = new Executable();
			ApplicationSondage appli = new ApplicationSondage(VCQ.questModif,util);
			VCQ.setVisible(false);
		}
		if(b.getName()=="Annuler"){
			VueGestQuest VGQ = new VueGestQuest(VCQ.connection,util);
			VCQ.setVisible(false);
		}
		if(b.getName()=="Valider"){
			// int tCBSoc = Integer.parseInt(VCQ.CBSociete.getSelectedItem());
			// int tCBPan = Integer.parseInt(VCQ.CBPanel.getSelectedItem());
			// int tTf = Integer.parseInt(VCQ.textField_1.getText());
			// Questionnaire q = new Questionnaire(VCQ.textField.getText(),tCBSoc,util.getIdU(),tCBPan,'S');
			// q.setListeQuestions(VCQ.listeQuestions);
			// VCQ.qBD.ajouterQuestionnaire(q);
			VueGestQuest VGQ = new VueGestQuest(VCQ.connection,util);
			VCQ.setVisible(false);
		}
	}
}
