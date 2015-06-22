import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BoutonAnnuler implements ActionListener{
	
	ApplicationSondageSQ appli;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		appli.dispose();
		
	}

}
