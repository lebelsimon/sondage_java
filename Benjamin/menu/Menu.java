import java.awt.*;
import javax.swing.*;

	
public class Menu extends JMenuBar{
	private JFrame fen;
	private JMenuBar BarMenu;
	private JMenu Affichage, Aide, Compte, Personne;
	private JMenuItem changerPerso, deconnexion, zoomPlus, zoomMoins, tuto, manuel, changerPerso2, deconnexion2;

	Menu(JFrame fen){
		
				// créatiojn des éléments du menu	  
		this.fen=fen;
		Compte = new JMenu("Compte");
		changerPerso = new JMenuItem("Paramètres");
		deconnexion = new JMenuItem("Deconnexion CTR+D");
		deconnexion.setName("deco");
		deconnexion.addActionListener(new MenuAction(deconnexion.getName(),this));

		Affichage = new JMenu("Affichage");
		zoomPlus = new JMenuItem("zoom +");
		zoomMoins = new JMenuItem("zoom -");

		Aide = new JMenu("Aide");
		tuto = new JMenuItem("Tutoriel");
		manuel = new JMenuItem("Manuel d'Utilisation");
		manuel.setName("manu");
		manuel.addActionListener(new MenuAction(manuel.getName(),this));

	  
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
		
				// creatio label personne permettant l'acces aux sous-menu du Compte	
		Personne = new JMenu("Prenom Nom ");
		
			// 1 JMenuItem ne peut appartenir qu'a un JMenu, il faut donc recréer des JMenuItem
		changerPerso2 = new JMenuItem("Paramètres");
		deconnexion2 = new JMenuItem("Deconnexion CTR+D");
		deconnexion2.setName("deco");
		deconnexion2.addActionListener(new MenuAction(deconnexion2.getName(),this));

		Personne.add(changerPerso2);
		Personne.add(deconnexion2);
		

		this.add(Compte);
		this.add(Affichage);
		this.add(Aide);
		this.add(Box.createHorizontalGlue()); // permet d'espacer les element dans le menu
		this.add(Personne);
		
	}
	public JFrame getfen(){
			return fen;
		}
}
