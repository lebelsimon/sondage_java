import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

//ICI A SUPPR: 	CREA DE LA FENETRE + UTILISATEUR;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	Module module;
	Utilisateur util;
	Container c;
	Fenetre( Utilisateur u ){
		super("Rapid'Sond | Sondage");
		System.out.println("Fenetre deb");
		util = u;
		System.out.println("ici");
		// mise en place d'une image de fond
		Fond f = new Fond();		
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setContentPane(f);
		c = this.getContentPane();

			// Menu
		this.setJMenuBar(new Menu(this));
		System.out.println("ajout menu");
		
			// creation espace module
		 this.setVisible(true);
		
	}

	// FONCTION NON TESTER, ATTENTION
	public void changerModule(Module _module){
		c.removeAll();
		this.module = _module;
		this.revalidate();
		this.repaint();
	}
	
	public void SetModule(Module m){
		this.module =m;
		c.removeAll();
		System.out.print("\nAjout du module");
		this.c.add(module,"Center");
		this.revalidate();
		this.repaint();
	}
	
	@SuppressWarnings("unused")
	public static void main ( String [] args){
	
		Connexion monLogin = new Connexion(new ConnexionMySQL("jdbc:mysql://servinfo-db:3306/", "dbdmartin", "dbdmartin","/home/dmartin"));
		
		//~ // creation d'1 Utilisateur
	    //~ Utilisateur u1 = new Utilisateur(01, "Lavorel", "Anais", "util2", "util2", "Sondeur");
	    //~ 
		//~ Fenetre f= new Fenetre(u1);
		//~ f.SetModule(new ModuleSondage(u1, f));
	}
	


}
