import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class BoutonQuestion implements ActionListener {

	VueSaisieQuestion vue;
	Questionnaire quest;
	Question laQuestion;
	String titreQ;
	String nomBouton;
	ConnexionMySQL co;
	Utilisateur u;
	
	public BoutonQuestion(VueSaisieQuestion vue, String nomBouton,ConnexionMySQL maco, Utilisateur ut){
		this.vue=vue;
		titreQ=vue.liste2.getSelectedValue();
		laQuestion = vue.question;
		this.nomBouton = nomBouton;
		this.co=maco;
		this.u=ut;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(this.nomBouton){
		// Bouton Valider : pour valider une question
		case "valider":
			JOptionPane jop = new JOptionPane();
			if (vue.enonceQuestion.getText()!="" && vue.liste.size()!=0){
			    jop.showMessageDialog(null, "Votre question a bien ete enregistre ", "Sauvegarde de la question", JOptionPane.INFORMATION_MESSAGE);
				Question q = new Question(vue.enonceQuestion.getText(), vue.question.getIdT(),vue.question.getMaxVal(),vue.question.getNumQ());
				// permet d'ajouter les propositions a la question
				for(int i=0; i<vue.liste.size(); i++){
					q.addProposition(new Proposition(vue.liste.elementAt(i)));
				}
				System.out.println(q);
				VueCreatQuest vu = new VueCreatQuest(co,u);
				vu.listeQuestions.add(q);
				System.out.println(vu.listeQuestions);
				vue.setVisible(false);}
			else{
				jop.showMessageDialog(null, "Veuillez entrer un énoncé, au moins une proposition ainsi qu'un type.", "Erreur de saisie", JOptionPane.INFORMATION_MESSAGE);
			}
			break;
		// Bouton Modifier : pour modifier une proposition
		case "modifier":
			if (vue.liste.size()!=0 && vue.liste2.getSelectedValue()!=null){
				vue.liste.removeElement(vue.liste2.getSelectedValue());
				JOptionPane jop4 = new JOptionPane(), jop5 = new JOptionPane();
			    String nom = jop4.showInputDialog(null, "Veuillez entrer une proposition", "Modification de la proposition ", JOptionPane.QUESTION_MESSAGE);
			    jop5.showMessageDialog(null, "Vous avez modifié la proposition en " + nom, "Proposition modifié", JOptionPane.INFORMATION_MESSAGE);
			    laQuestion.addProposition(new Proposition(nom));
			    vue.liste.addElement(nom);}
		    else{
				JOptionPane jopp = new JOptionPane();
				jopp.showMessageDialog(null, "Il n'y a pas de proposition a modifier", "Erreur", JOptionPane.INFORMATION_MESSAGE);
			}
			break;
		// Bouton Ajouter : pour ajouter une proposition
		case "ajouter":
			JOptionPane jop3 = new JOptionPane(), jop2 = new JOptionPane();
		    String nom2 = jop3.showInputDialog(null, "Veuillez entrer une proposition", "Ajout de proposition", JOptionPane.QUESTION_MESSAGE);
		    jop2.showMessageDialog(null, "Vous avez ajoute la proposition " + nom2, "Proposition ajoute", JOptionPane.INFORMATION_MESSAGE);
		    laQuestion.addProposition(new Proposition(nom2));
		    vue.liste.addElement(nom2);
			break;
		// Bouton Supprimer : pour supprimer une proposition
		case "supprimer":
			if (vue.liste.size()!=0 && vue.liste2.getSelectedValue()!=null){
				vue.liste.removeElement(vue.liste2.getSelectedValue());
			}
			else{
				JOptionPane jop7 = new JOptionPane();
				jop7.showMessageDialog(null, "Il n'y a pas de proposition a supprimer", "Erreur", JOptionPane.INFORMATION_MESSAGE);
			}
			break;
		// Bouton Annuler : pour annuler les modifications de la question
		case "annuler":
			vue.setVisible(false);
			VueCreatQuest v = new VueCreatQuest(co,u);
			break;
		}
	}

}
