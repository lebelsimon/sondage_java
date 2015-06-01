import javax.swing.*;

import java.awt.*;

		// Panel Module Sondage
@SuppressWarnings("serial")
public class Module extends JPanel{
	private JPanel perso;
	
	public Module(){
		
		perso =new JPanel();
		JLabel PrenomNom = new JLabel();
		PrenomNom.setText("Prenom Nom");
		perso.add(PrenomNom);
	
		// END
		

		this.add( perso,"SOUTH");
	}
}
