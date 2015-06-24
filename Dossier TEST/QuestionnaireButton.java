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
					System.out.println("suivant");
					modsond.modif();
					break;
				case "appeler":
					System.out.println("appeler");
					BoiteDialogue bt=new BoiteDialogue(5000);
					bt.start();
					Icon tel = new ImageIcon("../Ressources/tel.png");
					Object[] options = {"Annuler" };
					bt.showOptionDialog(null,"Appel en cours ...", "Appel",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,tel, options, options[0]);
					System.out.println("terminer");break;
					
					
					 
			}
	}
	

}
