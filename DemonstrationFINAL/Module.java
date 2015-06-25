import javax.swing.*;

import java.awt.*;

/**
 * @author LAVOREL anais
 * Cree le JFrame contenant tout les elements necessaire a l'utilisation du Module Sondage
 */
 
@SuppressWarnings("serial")
public class Module extends JPanel{
	private JPanel perso;
	JFrame fenetre;
	
	public Module(){
		
	}
	public void setSource(JFrame f){
		fenetre = f;
	}
}
