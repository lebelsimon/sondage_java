import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;


/**
 * @author LAVOREL anais
 * @param Un utilisateur u
 * Cree le JFrame contenant tout les elements necessaire a l'utilisation du Module Sondage
 */

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	
	// =================================================================
	//     Creations des variable reutilise dans le module sondage
	// =================================================================
	Module module;
	Utilisateur util;
	Container c;
	
	Rectangle bounds;
	// =================================================================
	//                         Constructeur
	// =================================================================
	Fenetre( Utilisateur u ){
		super("Rapid'Sond | Sondage");
		
			// Recuperation des donnee de l'utilisateur connecte
		util = u;
		bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		Fond f = new Fond();
		
			// Modification du JFrame
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation((bounds.width - 800)/2, (bounds.height- 600)/2);
		this.setLayout(new BorderLayout());
		this.setContentPane(f);
		c = this.getContentPane();
		
			// Ajout du menu
		this.setJMenuBar(new Menu(this));
		
			// Forcement de l'affichage de la fenetre
		this.setVisible(true);
		
	}

	/**
	 * 
	 * @param un module
	 * Ajout le module Souhaiter à la fenetre
	 */
	public void SetModule(Module m){
		this.module =m;
		c.removeAll();
		this.c.add(module,"Center");
		this.revalidate();
		this.repaint();
	}
	
}
