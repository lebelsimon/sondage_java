import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;

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
			case "deco":
			Connexion co = new Connexion();
			men.getfen().dispose();
				
				}
	}
}
