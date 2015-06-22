import java.awt.event.*;

import javax.swing.JButton;


public class ControleurVueCreatQuest implements ActionListener {
	VueCreatQuest VCQ;
	ConnexionMySQL connect;
	public ControleurVueCreatQuest(VueCreatQuest i,ConnexionMySQL connect){
		this.VCQ = i;
		this.connect = connect;
	}
	public void actionPerformed(ActionEvent arg0) {
		JButton b =(JButton)arg0.getSource();
		if(b.getName()=="Deconnexion"){
			Connexion conn = new Connexion(connect);
			VCQ.dispose();
		}
		if(b.getName()=="Ajouter"){
			ApplicationSondageSQ exe = new ApplicationSondageSQ();
			VCQ.setVisible(false);
		}
		if(b.getName()=="Supprimer"){
			VCQ.list.removeElementAt(VCQ.listeQ.getSelectedIndex());
		}
		if(b.getName()=="Modifier"){
			// Executable exe = new Executable();
			VCQ.setVisible(false);
		}
		if(b.getName()=="Annuler"){
			VueGestQuest VGQ = new VueGestQuest(VCQ.connection);
			VCQ.setVisible(false);
		}
		if(b.getName()=="Valider"){
			// Questionnaire q = new Questionnaire(VCQ.textField.getText(),VCQ.CBSociete.getSelectedItem(),IDUTILISATEUR,VCQ.CBPanel.getSelectItem(),VCQ.textField_1.getText(),"S");
			// q.setListeQuestions(VCQ.listeQuestions);
			// VCQ.qBD.ajouterQuestionnaire(q);
			VueGestQuest VGQ = new VueGestQuest(VCQ.connection);
			VCQ.setVisible(false);
		}
	}
}
