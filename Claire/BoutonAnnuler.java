import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BoutonAnnuler implements ActionListener{
	
	ApplicationSondage appli;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		appli.dispose();
		
	}

}
