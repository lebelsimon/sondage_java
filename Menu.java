import java.awt.*;
import javax.swing.*;

	
public class Menu extends JMenuBar{
	
	 private JMenuBar BarMenu;
	 private JMenu Affichage, Aide, Compte;
	 private JMenuItem changerPerso, deconnexion, zoomPlus, zoomMoins, tuto, manuel;

	Menu(){
		
				// créatiojn des éléments du menu	  
		Compte = new JMenu("Compte");
		changerPerso = new JMenuItem();
		changerPerso.setText("Changer d'Utilisateur");
		deconnexion = new JMenuItem("Deconnexion CTR+D");

		Affichage = new JMenu("Affichage");
		zoomPlus = new JMenuItem("zoom +");
		zoomMoins = new JMenuItem("zoom -");

		Aide = new JMenu("Aide");
		tuto = new JMenuItem("Tutoriel");
		manuel = new JMenuItem("Manuel d'Utilisation");
	  
				// ajout des sous-menu 
		Compte.add(changerPerso);
		Compte.add(deconnexion);
	  
		Affichage.add(zoomPlus);
		Affichage.add(zoomMoins);
	  
		Aide.add(tuto);
		Aide.add(manuel);
				// ajout des separateur
		Compte.addSeparator();
		Affichage.addSeparator();
		Aide.addSeparator();
		
				// creatio label personne
		JPanel p = new JPanel(new FlowLayout());
		
		JLabel PrenomNom = new JLabel();
		PrenomNom.setText("Prenom Nom ");
		

		this.add(Compte);
		this.add(Affichage);
		this.add(Aide);
		this.add(Box.createHorizontalGlue());
		this.add(PrenomNom);
	}
}
