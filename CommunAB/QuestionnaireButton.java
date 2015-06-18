import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;


public class QuestionnaireButton implements ActionListener {
	
	// Lien vers le questionnaire pour pouvoir modifier certaines de ses propriétés
	//~ Questionnaire q;
	
	 // nom du bouton:
	String nom;
	mod mo;
	ModuleSondage modsond;
	
	// Constructeur
	public QuestionnaireButton(String _nom){//Questionnaire _q) {
		//~ this.q=_q;
		this.nom=_nom;
		this.mo=null;
		this.modsond=null;
	}
	public QuestionnaireButton(String _nom,mod mo){//Questionnaire _q) {
		//~ this.q=_q;
		this.nom=_nom;
		this.mo=mo;
		this.modsond=mo.modsond;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

			// on change l'affichage en fonction du boutons choisi
			switch (nom){	
				case "prec": 
					System.out.println("bouton prec"); break;
				case "suiv": 
					System.out.println("bouton suiv"); break;
				case "prem": 
					System.out.println("bouton prem"); break;
				case "dern":
					System.out.println("bouton dern"); break;
				case "suivi":
					System.out.println("1");
					mo.setVisible(false);
					System.out.println("2");
					modsond=new ModuleSondage();
					System.out.println("3");
					mo.setVisible(true);
					System.out.println("4");
					break;
				case "appeler":
					BoiteDialogue bt=new BoiteDialogue(5000);
					bt.start();
					bt.showMessageDialog(null, "Appel en cours...");
					System.out.println("terminer");break;
					
					
					 
			}
	}

}
