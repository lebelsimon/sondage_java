import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class MenuAction implements ActionListener {
	
	Menu men;
	String nom;
	
	
	public MenuAction(String nom,Menu men){
		this.nom=nom;
		this.men=men;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		switch (nom){
			//permet de se deconnecter c'est a dire de fermer la fenetre actuelle et d'ouvrir celle de connexion
			case "deco":
				Connexion co = new Connexion(new ConnexionMySQL("jdbc:mysql://servinfo-db:3306/", "dbdmartin", "dbdmartin","/home/dmartin"));
				men.getfen().dispose();
				break;
			//Permet d'ouvrir le pdf du manuel d'utilisation
			case "manu":
				System.out.println("test");
				try{
					OuverturePDF pdf = new OuverturePDF();
					Desktop.getDesktop().open(pdf.access("/manuel.pdf",".pdf"));
				}
				catch(IOException e){System.out.println(e);}
				break;
			}
	}
}
