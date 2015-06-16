import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;


public class QuestionButton implements ActionListener {
	
	// Lien vers le questionnaire pour pouvoir modifier certaines de ses propriétés
	Question q;
	
	 // nom du bouton:
	String nom;
	
	// Constructeur
	public QuestionButton(String _nom, Question _q) {
		this.q=_q;
		this.nom=_nom;
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
			}
	}

}