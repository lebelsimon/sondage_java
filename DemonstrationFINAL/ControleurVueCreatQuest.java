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
			ApplicationSondage exe = new ApplicationSondage(VCQ.questModif,util);
			VCQ.setVisible(false);
		}

		if(b.getName()=="Supprimer"){
			int indiceSuppr = VCQ.listeQ.getSelectedIndex();
			VCQ.list.removeElementAt(indiceSuppr);
		}

		if(b.getName()=="Modifier"){
			// Executable exe = new Executable();
			VCQ.setVisible(false);
		}

		if(b.getName()=="Annuler"){
			VueGestQuest VGQ = new VueGestQuest(VCQ.connection,util);
			VCQ.setVisible(false);
		}

		if(b.getName()=="Valider"){
			String cliChoi = VCQ.CBSociete.getSelectedItem().toString();
			String panChoi = VCQ.CBPanel.getSelectedItem().toString();

			int numCli =0;
			int numPan =0;
			for(int cle: VCQ.dictClient.keySet()){
				if(VCQ.dictClient.get(cle)==cliChoi){
					numCli = cle;
				}
			}

			for(int cle: VCQ.dictPanel.keySet()){
				if(VCQ.dictPanel.get(cle)==panChoi){
					numPan = cle;
				}
			}

			Questionnaire q = new Questionnaire(VCQ.textField.getText(),numCli,util.getIdU(),numPan,'S');
			q.setListeQuestions(VCQ.listeQuestions);
			VCQ.qBD.ajouterQuestionnaire(q);
			VueGestQuest VGQ = new VueGestQuest(VCQ.connection,util);
			VCQ.setVisible(false);
			
		}
	}
}
